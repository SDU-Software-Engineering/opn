using System.Collections.Generic;

namespace BankingDotNetCore.Server
{
    public class Customer :ICustomer
    {
        private ICredential who;
        private List<IAccount> _accounts = new List<IAccount>();

        public Customer(ICredential who)
        {
            this.who = who;
        }

        public ICredential GetCredential()
        {
            return who;
        }

        public List<IAccount> GetAccounts()
        {
            return _accounts;
        }

        /// <summary>
        /// Add a new account for this customer with the given name (account number is automatically generated)
        /// </summary>
        /// <param name="name">account name</param>
        /// <param name="positiveInterest">the interest to accrue when the balance is positive</param>
        /// <param name="negativeInterest">the interest to subtract when the balance in negative  </param>
        public void AddAccount(string name, float positiveInterest, float negativeInterest)
        {
            _accounts.Add(new Account(name, positiveInterest, negativeInterest));
        }

        /// <summary>
        /// Add a new account for this customer
        /// </summary>
        /// <param name="account">new account for customer</param>
        public void AddAccount(IAccount account)
        {
            _accounts.Add(account);
        }
    }
}
