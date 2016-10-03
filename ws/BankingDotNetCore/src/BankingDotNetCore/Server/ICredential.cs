namespace BankingDotNetCore.Server
{
    public interface ICredential
    {
        string Name { get; set; }

        int Id { get; set; }
    }
}
