package chirp.model;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;

public class User {

	private final String username;
	private final String realname;
	private final Map<DateTime, Post> posts = new HashMap<DateTime, Post>();

	public User(String username, String realname) {
		this.username = username;
		this.realname = realname;
	}

	public String getUsername() {
		return username;
	}

	public String getRealname() {
		return realname;
	}

	public Map<DateTime, Post> getPosts() {
		return posts;
	}

}
