namespace BankingDotNetCore.Server
{
    public interface ICredential
    {
        string GetName();

        int GetId();
    }
}
