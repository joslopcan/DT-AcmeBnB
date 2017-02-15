
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
@Access(AccessType.PROPERTY)
public class Comment extends DomainEntity {

	public Comment() {
		super();
	}


	private String	title;
	private Date	postMoment;
	private String	text;
	private int		stars;


	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@NotNull
	public Date getPostMoment() {
		return postMoment;
	}

	public void setPostMoment(Date postMoment) {
		this.postMoment = postMoment;
	}
	@NotBlank
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	@Range(min = 1, max = 5)
	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}


	private Actor	writer;


	@ManyToOne
	public Actor getWriter() {
		return writer;
	}

	public void setWriter(Actor writer) {
		this.writer = writer;
	}

}
