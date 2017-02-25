
package forms;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import domain.DomainEntity;

@Entity
@Access(AccessType.PROPERTY)
public class TenantRegisterForm extends DomainEntity {

	public TenantRegisterForm() {
		super();
	}


	private String	userName;
	private String	password;
	private String	name;
	private String	surname;
	private String	email;
	private String	phone;
	private String	picture;
	private String	destinationCity;
	private double	minimumPrice;
	private double	maximumPrice;
	private String	keyword;


	@Length(min = 5)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Length(min = 5)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@NotBlank
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	@Email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Pattern(regexp = "^(\\+(?:00[1-9]|0[1-9]\\d|[1-9]\\d\\d)$*(\\((?:00[1-9]|0[1-9]\\d|[1-9]\\d\\d)$*\\)))?[0]?[a-zA-Z0-9\\- ]*$")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@URL
	@NotBlank
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

	@NotBlank
	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	@Min(0)
	public double getMinimumPrice() {
		return minimumPrice;
	}

	public void setMinimumPrice(double minimumPrice) {
		this.minimumPrice = minimumPrice;
	}

	@Min(0)
	public double getMaximumPrice() {
		return maximumPrice;
	}

	public void setMaximumPrice(double maximumPrice) {
		this.maximumPrice = maximumPrice;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
