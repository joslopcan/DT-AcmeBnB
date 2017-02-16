
package domain;

import java.util.Collection;

public interface Commentable {

	public Collection<Comment> getComments();
	public void setComments(Collection<Comment> comments);

}
