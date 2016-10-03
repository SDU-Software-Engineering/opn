using System;
using System.Threading;

namespace BankingDotNetCore.Server
{
    /// <summary>
    /// Credentials used to login a user and retrieve account information
    /// </summary>
    public class Credential : ICredential
    {
        /// <summary>
        /// Gets the name of the user
        /// </summary>
        /// <returns>Name of user</returns>
        public string Name { get; set; }
        /// <summary>
        /// Gets the ID of the user
        /// </summary>
        /// <returns>ID of user</returns>
        public int Id { get; set; }

        // Counter for account numbers
        private static int _counter = 0;

        /// <summary>
        /// Credentials used to retrieve accounts
        /// </summary>
        /// <param name="name">Name of user</param>
        /// <param name="id">Id for user</param>
        public Credential(string name, int id)
        {
            Name = name;
            Id = id;
        }

	    // Return a new, unique account number
        private static int NewCredentialId()
        {
            return Interlocked.Increment(ref _counter);
        }

        /// <summary>
        /// Method used to create a new customer
        /// </summary>
        /// <param name="name">Name of customer</param>
        /// <returns>Credential object with name and ID</returns>
        public static Credential CreateNewCredential(string name)
        {
            return new Credential(name, NewCredentialId());
        }

        /// <inheritdoc />
        public override int GetHashCode()
        {
            unchecked
            {
                return ((Name?.GetHashCode() ?? 0) * 397) ^ Id;
            }
        }


        /// <inheritdoc />
        public override bool Equals(object obj)
        {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (this.GetType() != obj.GetType())
                return false;
            Credential other = (Credential)obj;
            if (Id != other.Id)
                return false;
            if (Name == null)
            {
                if (other.Name != null)
                    return false;
            }
            else if (!Name.Equals(other.Name))
                return false;
            return true;
        }
    }
}
