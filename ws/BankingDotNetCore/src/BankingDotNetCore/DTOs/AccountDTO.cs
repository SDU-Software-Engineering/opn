using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BankingDotNetCore.Server;

namespace BankingDotNetCore.DTOs
{
    public class AccountDTO
    {
        public string Name { get; set; }
        public int Number { get; set; }
        public float Balance { get; set; }
        public AccountDTO(IAccount account)
        {
            Name = account.Name;
            Number = account.Number;
            Balance = account.Balance;
        }

    }
}
