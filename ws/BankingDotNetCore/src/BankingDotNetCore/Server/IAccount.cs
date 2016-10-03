namespace BankingDotNetCore.Server
{
    public interface IAccount
    {
        void accrueInterest();
        void deposit(float amount);
        void withdraw(float amount);
        float Balance { get; set; }
        string Name { get; set; }
        int Number { get; set; }
        float PositiveInterest { get; set; }
        float NegativeInterest { get; set; }
    }
}