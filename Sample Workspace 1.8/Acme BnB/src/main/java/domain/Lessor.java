
package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

@Entity
@Access(AccessType.PROPERTY)
public class Lessor extends Actor implements Commentable {

	public Lessor() {
		super();
		comments = new ArrayList<Comment>();
		requests = new ArrayList<Request>();
		properties = new ArrayList<Property>();
	}


	private Collection<Comment>	comments;
	private double				totalFee;


	@Min(0)
	public double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}


	private Collection<Request>		requests;
	private Collection<Property>	properties;
	private CreditCard				creditCard;


	@OneToOne
	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	@OneToMany
	public Collection<Request> getRequests() {
		return requests;
	}

	public void setRequests(Collection<Request> requests) {
		this.requests = requests;
	}

	@OneToMany(mappedBy = "lessor")
	public Collection<Property> getProperties() {
		return properties;
	}

	public void setProperties(Collection<Property> properties) {
		this.properties = properties;
	}

	@Override
	@OneToMany
	public Collection<Comment> getComments() {
		return comments;
	}

	@Override
	public void setComments(Collection<Comment> comments) {
		this.comments = comments;

	}

}
