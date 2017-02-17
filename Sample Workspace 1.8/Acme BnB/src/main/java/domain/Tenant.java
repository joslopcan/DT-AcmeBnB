
package domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Access(AccessType.PROPERTY)
public class Tenant extends Actor implements Commentable {

	public Tenant() {
		super();
		comments = new HashSet<Comment>();
		invoices = new HashSet<Invoice>();
	}


	private Collection<Request>	requests;
	private Collection<Comment>	comments;
	private Collection<Invoice>	invoices;
	private Finder				finder;
	private CreditCard			creditCard;


	@OneToMany(mappedBy = "tenant")
	public Collection<Request> getRequests() {
		return requests;
	}

	public void setRequests(Collection<Request> requests) {
		this.requests = requests;
	}

	@OneToMany
	public Collection<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Collection<Invoice> invoices) {
		this.invoices = invoices;
	}
	@OneToOne(optional = false)
	public Finder getFinder() {
		return finder;
	}

	public void setFinder(Finder finder) {
		this.finder = finder;
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

	@OneToOne
	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

}
