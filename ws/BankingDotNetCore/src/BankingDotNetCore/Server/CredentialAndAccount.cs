using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BankingDotNetCore.Server
{
    /// <summary>
    /// Class used for creating an account for given credentials.
    /// </summary>
    public class CredentialAndAccount
    {
        /// <summary>
        /// Credential information
        /// </summary>
        public Credential Credential { get; set; }
        /// <summary>
        /// Account information
        /// </summary>
        public Account Account { get; set; }

        /// <summary>
        /// Constructor
        /// </summary>
        /// <param name="credential"></param>
        /// <param name="account"></param>
        public CredentialAndAccount(Credential credential, Account account)
        {
            Credential = credential;
            Account = account;
        }
    }
}
