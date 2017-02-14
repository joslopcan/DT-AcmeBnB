
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class SocialIdentity extends DomainEntity {

	public SocialIdentity() {
		super();
	}


	private String	nick;
	private String	socialNetworkName;
	private String	profileURL;


	@NotBlank
	public String getNick() {
		return nick;
	}
	@NotBlank
	public void setNick(String nick) {
		this.nick = nick;
	}
	@NotBlank
	@URL
	public String getSocialNetworkName() {
		return socialNetworkName;
	}

	public void setSocialNetworkName(String socialNetworkName) {
		this.socialNetworkName = socialNetworkName;
	}

	public String getProfileURL() {
		return profileURL;
	}

	public void setProfileURL(String profileURL) {
		this.profileURL = profileURL;
	}

}
