using System.Collections.Generic;

namespace BankingDotNetCore.Server
{
    public interface ICustomer
    {
        /**
	     * Get the credential of the customer
	     */
        ICredential GetCredential();
        /**
         * Get all account associated with the customer 
         */
        List<IAccount> GetAccounts();
        
        void AddAccount(string name, float positiveInterest, float negativeInterest);
        void AddAccount(IAccount account);
    }
}
