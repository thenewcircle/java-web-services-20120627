package chirp.model;

public class User {

	private final String username;
	private final String realname;

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

}
