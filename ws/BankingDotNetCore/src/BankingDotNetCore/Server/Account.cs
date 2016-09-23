using System.Threading;

namespace BankingDotNetCore.Server
{
    public class Account : IAccount
    {
        private float balance;
        private string name;
        private int number;
        private float positiveInterest, negativeInterest;
        public Account(string name, float positiveInterest, float negativeInterest)
        {
		    this.name = name;
		    this.positiveInterest = positiveInterest/100;
		    this.negativeInterest = negativeInterest/100;
		    this.number = newAccountNumber();
        }

        public void accrueInterest()
        {
            if (balance >= 0)
                balance *= (1 + positiveInterest);
            else
                balance *= (1 - negativeInterest);
        }

        public void deposit(float amount)
        {
            balance += amount;
        }

        public float GetBalance()
        {
            return balance;
        }

        public string GetName()
        {
            return name;
        }

        public int GetNumber()
        {
            return number;
        }

        public void withdraw(float amount)
        {
            balance -= amount;
        }

        /**
	     * Return a new, unique account number
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
