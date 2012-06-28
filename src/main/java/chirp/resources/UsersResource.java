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
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import chirp.representations.UserRepresentation;

@Path("/users")
public class UsersResource {

	private static Map<String, UserRepresentation> users = new HashMap<String, UserRepresentation>();

	@GET
	@Path("{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("username") String username) {
		UserRepresentation user = users.get(username);
		if (user != null) {
			return Response.ok(user).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@POST
	public Response putUser(@FormParam("username") String username, @FormParam("realname") String realname) {
		if (users.containsKey(username)) {
			return Response.status(Status.FORBIDDEN).build();
		} else {
			users.put(username, new UserRepresentation(username, realname));
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
