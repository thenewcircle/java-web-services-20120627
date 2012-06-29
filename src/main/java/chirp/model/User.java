package chirp.model;

import java.util.HashMap;
import java.util.Map;

public class User {

	private final String username;
	private final String realname;
	private final Map<String, Post> posts = new HashMap<String, Post>();

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

	public Map<String, Post> getPosts() {
		return posts;
	}

}
