package chirp.representations;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import chirp.model.Post;

public class PostRepresentation {

	private final String timestamp;
	private final String content;

	public PostRepresentation(boolean summary, Post post) {
		this.timestamp = post.getTimestamp();
		this.content = summary ? null : post.getContent();
	}

	@JsonCreator
	public PostRepresentation(
			@JsonProperty("timestamp") String timestamp,
			@JsonProperty("content") String content) {
		this.timestamp = timestamp;
		this.content = content;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public String getContent() {
		return content;
	}

}
