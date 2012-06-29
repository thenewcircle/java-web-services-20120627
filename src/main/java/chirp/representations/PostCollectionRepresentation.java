package chirp.representations;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import chirp.model.Post;

public class PostCollectionRepresentation {

	private final Collection<PostRepresentation> posts;
	private final URI self;

	public PostCollectionRepresentation(boolean summary, Collection<Post> posts, URI self) {
		this.posts = new ArrayList<PostRepresentation>();
		for (Post post : posts) {
			this.posts.add(new PostRepresentation(summary, post));
		}
		this.self = self;
	}

	@JsonCreator
	public PostCollectionRepresentation(
			@JsonProperty("posts") Collection<PostRepresentation> posts,
			@JsonProperty("self") URI self) {
		this.posts = posts;
		this.self = self;
	}

	public Collection<PostRepresentation> getPosts() {
		return posts;
	}

	public URI getSelf() {
		return self;
	}

}
