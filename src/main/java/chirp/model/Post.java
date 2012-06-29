package chirp.model;


public class Post {

	private final String timestamp;
	private final String content;

	public Post(String timestamp, String content) {
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
