
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Audit extends DomainEntity {

	public Audit() {
		super();
	}


	private Date				writtenMoment;
	private String				text;
	private Boolean				isDraft;
	private Collection<String>	attachments;


	@NotNull
	public Date getWrittenMoment() {
		return writtenMoment;
	}

	public void setWrittenMoment(Date writtenMoment) {
		this.writtenMoment = writtenMoment;
	}
	@NotBlank
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	@NotNull
	public Boolean getIsDraft() {
		return isDraft;
	}

	public void setIsDraft(Boolean isDraft) {
		this.isDraft = isDraft;
	}
	@ElementCollection
	@URL
	public Collection<String> getAttachments() {
		return attachments;
	}

	public void setAttachments(Collection<String> attachments) {
		this.attachments = attachments;
	}
}
