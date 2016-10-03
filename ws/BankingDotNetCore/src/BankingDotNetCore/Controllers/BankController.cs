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
        /// <param name="credentialAndAccount">CredentialAndAccount object containing credential and account information</param>
        /// <remarks>
        /// This is an example of how the JSON should be structured
        /// {
        ///	    "credential" : {
        ///		    "name" : "Nicolai",
        ///		    "id" : 1	
        ///	    },
        ///	    "account" : {
        ///		    "name" : "Budget Account",
        ///		    "PositiveInterest" : 2.0,
        ///		    "NegativeInterest" : 5.0
        ///	    }
        /// }
        /// </remarks>
        /// <returns>Returns JSON serialized Customer DTO</returns>
        [HttpPost("create-account")]
        [Produces(typeof(CustomerDTO))]
        [SwaggerResponse(System.Net.HttpStatusCode.OK, Type = typeof(CustomerDTO))]
        public CustomerDTO CreateAccount([FromBody] CredentialAndAccount credentialAndAccount)
        {
            var customer = _bank.Login(credentialAndAccount.Credential);
            customer.AddAccount(credentialAndAccount.Account);
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
        public CustomerDTO Withdraw([FromBody] DepositOrWithdrawDTO withdraw) 
        {
            var customer = _bank.Login(withdraw.Credential);
            foreach (IAccount account in customer.GetAccounts()) {
			    if(account.Number == withdraw.AccountId) {
				    account.withdraw(withdraw.Amount);
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
        public string DepositAction([FromBody] DepositOrWithdrawDTO deposit)
        {
            var customer = _bank.Login(deposit.Credential);
            foreach (IAccount account in customer.GetAccounts()) {
			    if(account.Number == deposit.AccountId) {
				    account.deposit(deposit.Amount);
			        break;
			    }
            }
            return JsonConvert.SerializeObject(new CustomerDTO(customer));
        }

       
        /// <summary>
        /// Placeholder for the action that is invoked when you ask to accrue interest
        /// Functionality: for every account, add positive or negative interest to
        /// the Balance of the account.
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