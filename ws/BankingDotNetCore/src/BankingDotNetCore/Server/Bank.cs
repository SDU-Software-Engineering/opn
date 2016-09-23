using System.Collections.Generic;

namespace BankingDotNetCore.Server
{
    public class Bank : IBank
    {
        /// <summary>
        /// Customers of the bank
        /// </summary>
        private readonly Dictionary<ICredential, Customer> _customers;

        private static IBank instance = null;

        public static IBank GetInstance()
        {
            return instance ?? (instance = new Bank());
        }

        private Bank()
        {
            _customers = new Dictionary<ICredential, Customer>();
        }

        public void AccrueInterest()
        {
            foreach (var value in _customers.Values)
            {
                foreach (IAccount a in value.GetAccounts())
                    a.accrueInterest();
            }
                
        }

        public bool AddCustomer(ICredential who)
        {
            if (_customers.ContainsKey(who)) return false;
            _customers.Add(who, new Customer(who));
            return true;
        }

        public bool IsOpen()
        {
            return true;
        }

        public ICustomer Login(ICredential who)
        {
            Customer customer;
            if(!_customers.TryGetValue(who, out customer)) throw new BankException("Unknown customer");
            return customer;
        }
    }
}
