package chirp.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import chirp.model.Application;
import chirp.model.User;
import chirp.representations.UserCollectionRepresentation;
import chirp.representations.UserRepresentation;

@Path("/users")
public class UsersResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers() {
		Collection<User> users = Application.getAllUsers();
		return Response.ok(UserCollectionRepresentation.builder().apply(users)).build();
	}

	@GET
	@Path("{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("username") String username) {
		User user = Application.getUser(username);
		return Response.ok(UserRepresentation.builder().apply(user)).build();
	}

	@POST
	public Response createUser(@FormParam("username") String username, @FormParam("realname") String realname) {
		Application.createUser(username, realname);
		URI uri = UriBuilder.fromPath(username).build();
		return Response.created(uri).build();
	}

	@DELETE
	@Path("{username}")
	public Response deleteUser(@PathParam("username") String username) {
		Application.deleteUser(username);
		return Response.noContent().build();
	}
}
