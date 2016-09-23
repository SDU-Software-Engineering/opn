namespace BankingDotNetCore.Server
{
    public interface IAccount
    {
        float GetBalance();

        string GetName();

        void deposit(float amount);

        void withdraw(float amount);

        int GetNumber();

        void accrueInterest();
    }
}