using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BankingDotNetCore.Server;

namespace BankingDotNetCore.DTOs
{
    public class CustomerDTO
    {
        public int Id { get; }
        public string Name { get; }

        public List<AccountDTO> Accounts { get; }

        public CustomerDTO(ICustomer customer)
        {
            var cred = customer.GetCredential();
            Name = cred.GetName();
            Id = cred.GetId();
            Accounts = customer.GetAccounts().Select(x => new AccountDTO(x)).ToList();
        }
    }
}
