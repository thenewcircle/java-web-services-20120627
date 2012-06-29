package chirp.representations;

import java.util.Collection;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import chirp.model.User;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

public class UserCollectionRepresentation {

	private final Collection<UserRepresentation> users;

	@JsonCreator
	public UserCollectionRepresentation(
			@JsonProperty("users") Collection<UserRepresentation> users) {
		this.users = users;
	}

	public Collection<UserRepresentation> getUsers() {
		return users;
	}

	public static Function<Collection<User>, UserCollectionRepresentation> builder() {
		return new Function<Collection<User>, UserCollectionRepresentation>() {
			public UserCollectionRepresentation apply(Collection<User> users) {
				return new UserCollectionRepresentation(Collections2.transform(
						users, UserRepresentation.builder()));
			}
		};
	}
}
