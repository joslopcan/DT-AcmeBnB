
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Invoice extends DomainEntity {

	public Invoice() {
		super();
	}


	private Date	issuedMoment;
	private String	VATNumber;
	private String	details;
	private String	tenantInformation;
	private Double	amount;


	@NotNull
	public Date getIssuedMoment() {
		return issuedMoment;
	}

	public void setIssuedMoment(Date issuedMoment) {
		this.issuedMoment = issuedMoment;
	}
	@NotBlank
	public String getVATNumber() {
		return VATNumber;
	}

	public void setVATNumber(String vATNumber) {
		VATNumber = vATNumber;
	}
	@NotBlank
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	@NotBlank
	public String getTenantInformation() {
		return tenantInformation;
	}

	public void setTenantInformation(String tenantInformation) {
		this.tenantInformation = tenantInformation;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}


	private CreditCard	creditCard;


	@ManyToOne(optional = false)
	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

}
