
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
@Access(AccessType.PROPERTY)
public class CreditCard extends DomainEntity {

	public CreditCard() {
		super();
	}


	private String	holderName;
	private String	brandName;
	private Integer	number;
	private Integer	expirationMonth;
	private Integer	expirationYear;
	private Integer	cvvCode;


	@NotBlank
	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	@NotBlank
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	@NotNull
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	@NotNull
	@Range(min = 1, max = 12)
	public Integer getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(Integer expirationMonth) {
		this.expirationMonth = expirationMonth;
	}
	@NotNull
	public Integer getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(Integer expirationYear) {
		this.expirationYear = expirationYear;
	}
	@NotNull
	@Range(min = 100, max = 9999)
	public Integer getCvvCode() {
		return cvvCode;
	}

	public void setCvvCode(Integer cvvCode) {
		this.cvvCode = cvvCode;
	}
}
