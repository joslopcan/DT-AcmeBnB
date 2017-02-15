
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Finder extends DomainEntity {

	public Finder() {
		super();
	}


	private String	destinationCity;
	private double	minimumPrice;
	private double	maximumPrice;
	private String	keyword;


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


	private Collection<Property>	propertiesFound;


	@OneToMany
	public Collection<Property> getPropertiesFound() {
		return propertiesFound;
	}

	public void setPropertiesFound(Collection<Property> propertiesFound) {
		this.propertiesFound = propertiesFound;
	}

}
