using System;

namespace BankingDotNetCore.Server
{
    public class Credential : ICredential
    {
        private readonly string _name;
        private readonly int _id;
        public Credential(string name, int id)
        {
            this._name = name; this._id = id;
        }

        public string GetName() { return _name; }

        public int GetId() { return _id; }

        public override int GetHashCode()
        {
            unchecked
            {
                return ((_name?.GetHashCode() ?? 0) * 397) ^ _id;
            }
        }


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
