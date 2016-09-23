namespace BankingDotNetCore.Server
{
    public interface IBank
    {
        /**
	     * Check if the bank is open
	     */
        bool IsOpen();
        /**
         * Given customer name and corresponding ID, give access to that customer
         */
        ICustomer Login(ICredential who);
        /**
         * Add new customer with the given name and ID
         */
        bool AddCustomer(ICredential who);
        /**
         * Accrue interest on all accounts
         */
        void AccrueInterest();
    }
}
