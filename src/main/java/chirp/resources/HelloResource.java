package chirp.resources;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/hello")
public class HelloResource {

	private static Set<String> users = new HashSet<String>();

	@GET
	@Path("{name}")
	public String hello(@PathParam("name") String name) {
		return "Hello, " + (users.contains(name) ? name : "UNKNOWN");
	}

	@PUT
	@Path("{name}")
	public String putUser(@PathParam("name") String name) {
		users.add(name);
		return "Accepted " + name;
	}
}
