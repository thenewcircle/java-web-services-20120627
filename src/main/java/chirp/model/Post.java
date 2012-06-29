package chirp.model;


public class Post {

	private final String timestamp;
	private final String content;
	private final User user;

	public Post(String timestamp, String content, User user) {
		this.timestamp = timestamp;
		this.content = content;
		this.user = user;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public String getContent() {
		return content;
	}

	public User getUser() {
		return user;
	}

}
