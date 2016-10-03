namespace BankingDotNetCore.Server
{
    public interface ICredential
    {
        string Name { get; }

        int Id { get; }
    }
}
