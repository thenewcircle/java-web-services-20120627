package chirp.representations;

import java.util.Collection;
import java.util.HashSet;

import chirp.model.User;

public class UserCollectionRepresentation {

	private final Collection<UserRepresentation> users;

	public UserCollectionRepresentation(Collection<User> users) {
		this.users = new HashSet<UserRepresentation>();
		for (User user : users) {
			this.users.add(new UserRepresentation(user));
		}
	}

	public Collection<UserRepresentation> getUsers() {
		return users;
	}

}
