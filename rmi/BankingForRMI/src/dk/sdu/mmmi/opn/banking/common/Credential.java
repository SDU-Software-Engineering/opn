package dk.sdu.mmmi.opn.banking.common;

import java.io.Serializable;

public class Credential implements ICredential, Serializable {
	private String name;
	private int id;
	public Credential(String name, int id) {
		this.name = name; this.id = id;
	}

	@Override
	public String getName() { return name; }

	@Override
	public int getID() { return id; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credential other = (Credential) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	private static final long serialVersionUID = -8451574332165991119L;
}
