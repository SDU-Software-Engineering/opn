using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BankingDotNetCore.Server;

namespace BankingDotNetCore.DTOs
{
    public class AccountDTO
    {
        public string Name { get; }
        public int Number { get; }
        public float Balance { get; }
        public AccountDTO(IAccount account)
        {
            Name = account.GetName();
            Number = account.GetNumber();
            Balance = account.GetBalance();
        }

    }
}
