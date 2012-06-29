package chirp.representations;

import java.net.URI;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import com.sun.jersey.server.linking.Link;
import com.sun.jersey.server.linking.Links;
import com.sun.jersey.server.linking.Ref;

import chirp.model.User;

@Links({
	@Link(value=@Ref("/users/{username}"), rel="self"),
	@Link(value=@Ref("/users"), rel="collection"),
	@Link(value=@Ref("/posts/{username}"), rel="related")
})
public class UserRepresentation {

	private final String username;
	private final String realname;
	@Ref("/users/{username}") private URI self;

	public UserRepresentation(boolean summary, User user) {
		this.username = user.getUsername();
		this.realname = summary ? null : user.getRealname();
	}

	@JsonCreator
	public UserRepresentation(
			@JsonProperty("username") String username,
			@JsonProperty("realname") String realname,
			@JsonProperty("self") URI self) {
		this.username = username;
		this.realname = realname;
		this.self = self;
	}

	public String getUsername() {
		return username;
	}

	public String getRealname() {
		return realname;
	}

	public URI getSelf() {
		return self;
	}
}
