package chirp.representations;

import java.net.URI;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.sun.jersey.server.linking.Link;
import com.sun.jersey.server.linking.Links;
import com.sun.jersey.server.linking.Ref;

import chirp.model.Post;

@Links({
	@Link(value=@Ref("/posts/{username}/{timestamp}"), rel="self"),
	@Link(value=@Ref("/posts/{username}"), rel="collection"),
	@Link(value=@Ref("/users/{username}"), rel="related")
})
public class PostRepresentation {

	private final String timestamp;
	private final UserRepresentation user;
	private final String content;
	@Ref("/posts/{username}/{timestamp}") private URI self;

	public PostRepresentation(boolean summary, Post post) {
		this.timestamp = post.getTimestamp();
		this.user = new UserRepresentation(true, post.getUser());
		this.content = summary ? null : post.getContent();
	}

	@JsonCreator
	public PostRepresentation(
			@JsonProperty("timestamp") String timestamp,
			@JsonProperty("user") UserRepresentation user,
			@JsonProperty("content") String content,
			@JsonProperty("self") URI self) {
		this.timestamp = timestamp;
		this.user = user;
		this.content = content;
		this.self = self;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public UserRepresentation getUser() {
		return user;
	}

	public String getContent() {
		return content;
	}

	public URI getSelf() {
		return self;
	}

	@JsonIgnore
	public String getUsername() {
		return user.getUsername();
	}
}
