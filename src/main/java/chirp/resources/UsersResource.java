package chirp.resources;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

@Path("/users")
public class UsersResource {

	private static Set<String> users = new HashSet<String>();

	@GET
	@Path("{name}")
	public Response hello(@PathParam("name") String name) {
		if (users.contains(name)) {
			return Response.ok("Hello, " + name).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@PUT
	@Path("{name}")
	public Response putUser(@PathParam("name") String name, @Context UriInfo info) {
		if (users.contains(name)) {
			return Response.noContent().build();
		} else {
			users.add(name);
			return Response.created(info.getRequestUri()).build();
		}
	}

	@DELETE
	@Path("{name}")
	public Response deleteUser(@PathParam("name") String name) {
		if (users.remove(name)) {
			return Response.noContent().build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
}
