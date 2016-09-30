using BankingDotNetCore.DTOs;
using BankingDotNetCore.Server;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using Swashbuckle.SwaggerGen.Annotations;

namespace BankingDotNetCore.Controllers
{
    /// <summary>
    /// Wep API for communication with the Bank server in OPN
    /// </summary>
    [Route("api/[controller]")]
    [Produces("application/json")]
    public class BankController : Controller
    {
        private readonly IBank _bank = Bank.GetInstance();

        ///  <summary>
        ///  Create a new user
        ///  </summary>
        /// <param name="name">Name of customer</param>
        /// <remarks>
        ///  This is an example of how the BODY should be structured
        /// 	"Nicolai Oksen"
        ///  </remarks>
        ///  <returns>Returns JSON serialized Customer DTO</returns>
        [HttpPost("create")]
        [Produces(typeof(CustomerDTO))]
        [SwaggerResponse(System.Net.HttpStatusCode.OK, Type = typeof(CustomerDTO))]
        public CustomerDTO Create([FromBody] string name)
        {
            var credential = Credential.CreateNewCredential(name);
            _bank.AddCustomer(credential);
            var customer = _bank.Login(credential);
            return new CustomerDTO(customer);
        }

        /// <summary>
        /// Login to the system with the given user
        /// </summary>
        /// <param name="credential">Login credentials for customer</param>
        /// <remarks>
        /// This is an example of how the JSON should be structured
        /// {
        ///	    "name" : "Nicolai",
        ///	    "id" : 1
        /// }
        /// </remarks>
        /// <returns>Returns JSON serialized Customer DTO</returns>
        [HttpPost("login")]
        [Produces(typeof(CustomerDTO))]
        [SwaggerResponse(System.Net.HttpStatusCode.OK, Type = typeof(CustomerDTO))]
        public CustomerDTO Login([FromBody] Credential credential)
        {
            var customer = _bank.Login(credential);
            return new CustomerDTO(customer);
        }

        /// <summary>
        /// Create an account for the given user
        /// </summary>
        /// <param name="credentialAndAccount">JSON object containing credential and account information</param>
        /// <remarks>
        /// This is an example of how the JSON should be structured
        /// {
        ///	    "credential" : {
        ///		    "name" : "Nicolai",
        ///		    "id" : 1	
        ///	    },
        ///	    "account" : {
        ///		    "name" : "Budget Account",
        ///		    "positiveInterest" : 2.0,
        ///		    "negativeInterest" : 5.0
        ///	    }
        /// }
        /// </remarks>
        /// <returns>Returns JSON serialized Customer DTO</returns>
        [HttpPost("create-account")]
        [Produces(typeof(CustomerDTO))]
        [SwaggerResponse(System.Net.HttpStatusCode.OK, Type = typeof(CustomerDTO))]
        public CustomerDTO CreateAccount([FromBody] JObject credentialAndAccount)
        {
            var credential = credentialAndAccount.GetValue("credential").ToObject<Credential>();
            var account = credentialAndAccount.GetValue("account").ToObject<Account>();
            var customer = _bank.Login(credential);
            customer.AddAccount(account);
            return new CustomerDTO(customer);
        }


        /// <summary>
        /// Withdraw money from the given account of the given customer
        /// </summary>
        /// <param name="withdraw">JSON object containing credentials, account id and withdraw amount</param>
        /// <remarks>
        /// This is an example of how the JSON should be structured
        /// {
        ///	"credential" : {
        ///		"name" : "Nicolai",
        ///		"id" : 1	
        ///	},
        ///	"accountId" : 2,
        ///	"amount" : 100.0
        /// }
        /// </remarks>
        /// <returns>Customer DTO object</returns>
        [HttpPost("withdraw")]
        [Produces(typeof(CustomerDTO))]
        [SwaggerResponse(System.Net.HttpStatusCode.OK, Type = typeof(CustomerDTO))]
        public CustomerDTO Withdraw([FromBody] JObject withdraw) 
        {
            var credential = withdraw.GetValue("credential").ToObject<Credential>();
            var accountId = withdraw.GetValue("accountId").ToObject<int>();
            var amount = withdraw.GetValue("amount").ToObject<float>();

            var customer = _bank.Login(credential);
            foreach (IAccount account in customer.GetAccounts()) {
			    if(account.GetNumber() == accountId) {
				    account.withdraw(amount);
			        break;
			    }
            }

            return new CustomerDTO(customer);
        }


        /// <summary>
        /// Deposit money on the given account of the given customer
        /// </summary>
        /// <param name="deposit">JSON object containing credentials, account id and withdraw amount</param>
        /// <remarks>
        /// This is an example of how the JSON should be structured
        /// {
        ///	"credential" : {
        ///		"name" : "Nicolai",
        ///		"id" : 1	
        ///	},
        ///	"accountId" : 2,
        ///	"amount" : 100.0
        /// }
        /// </remarks>
        /// <returns>Customer DTO object</returns>
        [HttpPost("deposit")]
        [Produces(typeof(CustomerDTO))]
        [SwaggerResponse(System.Net.HttpStatusCode.OK, Type = typeof(CustomerDTO))]
        public string DepositAction([FromBody] JObject deposit)
        {
            var credential = deposit.GetValue("credential").ToObject<Credential>();
            var accountId = deposit.GetValue("accountId").ToObject<int>();
            var amount = deposit.GetValue("amount").ToObject<float>();

            var customer = _bank.Login(credential);
            foreach (IAccount account in customer.GetAccounts()) {
			    if(account.GetNumber()== accountId) {
				    account.deposit(amount);
			        break;
			    }
            }
            return JsonConvert.SerializeObject(new CustomerDTO(customer));
        }

       
        /// <summary>
        /// Placeholder for the action that is invoked when you ask to accrue interest
        /// Functionality: for every account, add positive or negative interest to
        /// the balance of the account.
        /// </summary>
        [HttpPost("accrue-interest")]
        [Produces(typeof(string))]
        [SwaggerResponse(System.Net.HttpStatusCode.OK, Type = typeof(string))] 
        public string AccrueInterest()
        {
            _bank.AccrueInterest();
            return "Interest accrued";
        }
    }
}