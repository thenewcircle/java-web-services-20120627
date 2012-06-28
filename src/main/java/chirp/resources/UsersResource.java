package chirp.resources;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

@Path("/users")
public class UsersResource {

	private static Map<String, String> users = new HashMap<String, String>();

	@GET
	@Path("{username}")
	public Response getUser(@PathParam("username") String username) {
		String realname = users.get(username);
		if (realname != null) {
			return Response.ok(realname).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@POST
	public Response putUser(@FormParam("username") String username, @FormParam("realname") String realname) {
		if (users.containsKey(username)) {
			return Response.status(Status.FORBIDDEN).build();
		} else {
			users.put(username, realname);
			URI uri =
					UriBuilder
					.fromPath(username)
					.build();
			return Response.created(uri).build();
		}
	}

	@DELETE
	@Path("{username}")
	public Response deleteUser(@PathParam("username") String username) {
		if (users.remove(username) != null) {
			return Response.noContent().build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
}
