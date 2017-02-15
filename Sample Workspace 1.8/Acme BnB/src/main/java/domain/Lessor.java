
package domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Lessor extends Actor implements Commentable {

	public Lessor() {
		super();
		comments = new HashSet<Comment>();
	}


	private Collection<Comment>	comments;
	private double				totalFee;


	@NotNull
	@Min(0)
	public double getFee() {
		return totalFee;
	}

	public void setFee(double fee) {
		this.totalFee = fee;
	}


	private Collection<Request>		requests;
	private Collection<Property>	properties;


	@OneToMany
	public Collection<Request> getRequests() {
		return requests;
	}

	public void setRequests(Collection<Request> requests) {
		this.requests = requests;
	}

	@OneToMany
	public Collection<Property> getProperties() {
		return properties;
	}

	public void setProperties(Collection<Property> properties) {
		this.properties = properties;
	}

	@Override
	public Collection<Comment> getComments() {
		return comments;
	}

	@Override
	public void setComments(Collection<Comment> comments) {
		this.comments = comments;

	}

}
