using System.Threading;

namespace BankingDotNetCore.Server
{
    public class Account : IAccount
    {
        public float Balance { get; set; }
        public string Name { get; set; }
        public int Number { get; set; }
        public float PositiveInterest { get; set; }
        public float NegativeInterest { get; set; }
        public Account(string name, float positiveInterest, float negativeInterest)
        {
		    this.Name = name;
		    this.PositiveInterest = positiveInterest/100;
		    this.NegativeInterest = negativeInterest/100;
		    this.Number = newAccountNumber();
        }

        public void accrueInterest()
        {
            if (Balance >= 0)
                Balance *= (1 + PositiveInterest);
            else
                Balance *= (1 - NegativeInterest);
        }

        public void deposit(float amount)
        {
            Balance += amount;
        }

        public void withdraw(float amount)
        {
            Balance -= amount;
        }

        /**
	     * Return a new, unique account Number
	     */
        private static int newAccountNumber()
        {
            return Interlocked.Increment(ref COUNTER);
        }

        /**
         * Counter for account numbers
         */
        private static int COUNTER = 1;
    }
}
