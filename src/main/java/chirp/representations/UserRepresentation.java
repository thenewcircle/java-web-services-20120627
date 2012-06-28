package chirp.representations;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserRepresentation {

	@XmlAttribute private String username;
	@XmlAttribute private String realname;

	public UserRepresentation() {}

	public UserRepresentation(String username, String realname) {
		this.username = username;
		this.realname = realname;
	}

	public String getUsername() {
		return username;
	}

	public String getRealname() {
		return realname;
	}

}
