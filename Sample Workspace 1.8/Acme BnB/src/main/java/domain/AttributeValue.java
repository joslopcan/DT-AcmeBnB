
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class AttributeValue extends DomainEntity {

	public AttributeValue() {
		super();
	}


	private String	value;


	@NotBlank
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	private Attribute	attribute;


	@ManyToOne
	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

}
