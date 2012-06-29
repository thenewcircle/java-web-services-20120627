package chirp.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Application {

	private static final Map<String, User> users = new HashMap<String, User>();

	public static User createUser(String username, String realname) {
		if (users.containsKey(username)) {
			throw new EntityAlreadyExistsError();
		} else {
			User user = new User(username, realname);
			users.put(username, user);
			return user;
		}
	}

	public static Collection<User> getAllUsers() {
		return users.values();
	}

	public static User getUser(String username) {
		User user = users.get(username);
		if (user == null) {
			throw new NoSuchEntityError();
		} else {
			return user;
		}
	}

	public static void deleteUser(String username) {
		if (users.remove(username) == null) {
			throw new NoSuchEntityError();
		}
	}

	public static Post getPost(User user, String timestamp) {
		Post post = user.getPosts().get(timestamp);
		if (post == null) {
			throw new NoSuchEntityError();
		} else {
			return post;
		}
	}

	public static Post createPost(User user, String timestamp, String content) {
		Post post = new Post(timestamp, content, user);
		user.getPosts().put(timestamp, post);
		return post;
	}

	public static void deletePost(User user, String timestamp) {
		if (user.getPosts().remove(timestamp) == null) {
			throw new NoSuchEntityError();
		}
	}
}
