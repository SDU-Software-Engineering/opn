using System;

namespace BankingDotNetCore.Server
{
    public class BankException : Exception
    {
        public BankException(string message) :base(message) { }
    }
}
