
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Entity
@Access(AccessType.PROPERTY)
public class Administrator extends Actor {

	public Administrator() {
		super();

	}
	

	/* Relationships */
	
	private SystemConfig systemConfig;
	private Attribute attribute;
	
	@OneToMany
	public Attribute getAttribute(){
		return attribute;
	}
	
	public void setAttribute(Attribute attribute){
		this.attribute = attribute;
	}


	@NotNull
	@Valid
	@OneToOne(optional = false)
	public SystemConfig getSystemConfig() {
		return systemConfig;
	}

	public void setSystemConfig(SystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	}

}
