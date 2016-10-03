namespace BankingDotNetCore.Server
{
    public interface IAccount
    {
        void accrueInterest();
        void deposit(float amount);
        void withdraw(float amount);
        float Balance { get; set; }
        string Name { get; }
        int Number { get; }
        float PositiveInterest { get; }
        float NegativeInterest { get; }
    }
}