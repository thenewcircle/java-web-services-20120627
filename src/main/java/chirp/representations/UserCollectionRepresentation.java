package chirp.representations;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import chirp.model.User;

import com.sun.jersey.server.linking.Link;
import com.sun.jersey.server.linking.Ref;

@Link(value=@Ref("/users"), rel="self")
public class UserCollectionRepresentation {

	private final Collection<UserRepresentation> users;
	@Ref("/users") private URI self;

	public UserCollectionRepresentation(boolean summary, Collection<User> users) {
		this.users = new ArrayList<UserRepresentation>();
		for (User user : users) {
			this.users.add(new UserRepresentation(summary, user));
		}
	}

	@JsonCreator
	public UserCollectionRepresentation(
			@JsonProperty("users") Collection<UserRepresentation> users,
			@JsonProperty("self") URI self) {
		this.users = users;
		this.self = self;
	}

	public Collection<UserRepresentation> getUsers() {
		return users;
	}

	public URI getSelf() {
		return self;
	}

}
