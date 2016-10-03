using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BankingDotNetCore.Server;

namespace BankingDotNetCore.DTOs
{
    public class CustomerDTO
    {
        public ICredential Credential { get; }

        public List<AccountDTO> Accounts { get; }

        public CustomerDTO(ICustomer customer)
        {
            Credential = customer.GetCredential();
            Accounts = customer.GetAccounts().Select(x => new AccountDTO(x)).ToList();
        }
    }
}
