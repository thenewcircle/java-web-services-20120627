package chirp.model;

import org.joda.time.DateTime;

public class Post {

	private final DateTime timestamp = new DateTime();
	private final String content;

	public Post(String content) {
		this.content = content;
	}

	public DateTime getTimestamp() {
		return timestamp;
	}

	public String getContent() {
		return content;
	}

}
