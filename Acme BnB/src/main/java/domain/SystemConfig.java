
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class SystemConfig extends DomainEntity {

	public SystemConfig() {
		super();
	}


	private double	fee;
	private String	VATNumber;


	@NotNull
	@Min(0)
	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	@NotNull
	public String getVATNumber() {
		return VATNumber;
	}

	public void setVATNumber(String vATNumber) {
		VATNumber = vATNumber;
	}
}
