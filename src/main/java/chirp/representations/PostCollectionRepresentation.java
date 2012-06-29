package chirp.representations;

import java.util.ArrayList;
import java.util.Collection;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import chirp.model.Post;

public class PostCollectionRepresentation {

	private final Collection<PostRepresentation> posts;

	public PostCollectionRepresentation(boolean summary, Collection<Post> posts) {
		this.posts = new ArrayList<PostRepresentation>();
		for (Post post : posts) {
			this.posts.add(new PostRepresentation(summary, post));
		}
	}

	@JsonCreator
	public PostCollectionRepresentation(
			@JsonProperty("posts") Collection<PostRepresentation> posts) {
		this.posts = posts;
	}

	public Collection<PostRepresentation> getPosts() {
		return posts;
	}

}
