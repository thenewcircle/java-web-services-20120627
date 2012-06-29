package chirp.representations;

import java.util.ArrayList;
import java.util.Collection;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import chirp.model.User;

public class UserCollectionRepresentation {

	private final Collection<UserRepresentation> users;

	public UserCollectionRepresentation(boolean summary, Collection<User> users) {
		this.users = new ArrayList<UserRepresentation>();
		for (User user : users) {
			this.users.add(new UserRepresentation(summary, user));
		}
	}

	@JsonCreator
	public UserCollectionRepresentation(
			@JsonProperty("users") Collection<UserRepresentation> users) {
		this.users = users;
	}

	public Collection<UserRepresentation> getUsers() {
		return users;
	}

}
