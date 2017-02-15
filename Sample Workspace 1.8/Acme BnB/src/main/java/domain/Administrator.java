
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@Access(AccessType.PROPERTY)
public class Administrator extends Actor {

	public Administrator() {
		super();

	}


	/* Relationships */

	private Collection<Attribute>	attributes;


	@OneToMany
	public Collection<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttribute(Collection<Attribute> attributes) {
		this.attributes = attributes;
	}

}
