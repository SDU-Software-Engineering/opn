using System;
using System.Threading;

namespace BankingDotNetCore.Server
{
    /// <summary>
    /// Credentials used to login a user and retrieve account information
    /// </summary>
    public class Credential : ICredential
    {
        private readonly string _name;
        private readonly int _id;

        // Counter for account numbers
        private static int _counter = 0;

        /// <summary>
        /// Used when creating account for the first time. 
        /// </summary>
        /// <param name="name">Name of user</param>
        public Credential(string name) : this(name, NewCredentialId()) { }

        /// <summary>
        /// Credentials used to retrieve accounts
        /// </summary>
        /// <param name="name">Name of user</param>
        /// <param name="id">Id for user</param>
        public Credential(string name, int id)
        {
            _name = name;
            _id = id;
        }

	    // Return a new, unique account number
        private static int NewCredentialId()
        {
            return Interlocked.Increment(ref _counter);
        }

        /// <summary>
        /// Gets the name of the user
        /// </summary>
        /// <returns>Name of user</returns>
        public string GetName() { return _name; }

        /// <summary>
        /// Gets the ID of the user
        /// </summary>
        /// <returns>ID of user</returns>
        public int GetId() { return _id; }

        /// <inheritdoc />
        public override int GetHashCode()
        {
            unchecked
            {
                return ((_name?.GetHashCode() ?? 0) * 397) ^ _id;
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
            if (_id != other._id)
                return false;
            if (_name == null)
            {
                if (other._name != null)
                    return false;
            }
            else if (!_name.Equals(other._name))
                return false;
            return true;
        }
    }
}
