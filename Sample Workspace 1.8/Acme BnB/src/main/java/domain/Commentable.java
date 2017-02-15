
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.PROPERTY)
public interface Commentable {

	public Collection<Comment> getComments();
	public void setComments(Collection<Comment> comments);

}
