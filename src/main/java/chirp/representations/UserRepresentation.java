package chirp.representations;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.common.base.Function;

import chirp.model.User;

public class UserRepresentation {

	private final String username;
	private final String realname;

	@JsonCreator
	public UserRepresentation(
			@JsonProperty("username") String username,
			@JsonProperty("realname") String realname) {
		this.username = username;
		this.realname = realname;
	}

	public String getUsername() {
		return username;
	}

	public String getRealname() {
		return realname;
	}

	public static Function<User, UserRepresentation> builder() {
		return new Function<User, UserRepresentation>() {
			public UserRepresentation apply(User user) {
				return new UserRepresentation(user.getUsername(), user.getRealname());
			}
		};
	}
}
