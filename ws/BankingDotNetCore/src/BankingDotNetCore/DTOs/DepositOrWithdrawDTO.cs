using BankingDotNetCore.Server;

namespace BankingDotNetCore.DTOs
{
    public class DepositOrWithdrawDTO
    {
        /// <summary>
        /// Credential information
        /// </summary>
        public Credential Credential { get; set; }
        /// <summary>
        /// Amount information
        /// </summary>
        public float Amount{ get; set; }
        /// <summary>
        /// Account ID
        /// </summary>
        public int AccountId { get; set; }

        /// <summary>
        /// Constructor
        /// </summary>
        /// <param name="credential"></param>
        /// <param name="accountId"></param>
        /// <param name="amount"></param>
        public DepositOrWithdrawDTO(Credential credential, int accountId, float amount)
        {
            Credential = credential;
            AccountId = accountId;
            Amount = amount;
        }
    }
}
