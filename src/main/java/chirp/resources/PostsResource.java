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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import chirp.model.Application;
import chirp.model.Post;
import chirp.model.User;
import chirp.representations.PostCollectionRepresentation;
import chirp.representations.PostRepresentation;

@Path("/posts/{username}")
public class PostsResource {

	private final User user;

	public PostsResource(@PathParam("username") String username) {
		this.user = Application.getUser(username);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPosts(@Context UriInfo info) {
		Collection<Post> posts = user.getPosts().values();
		return Response.ok(new PostCollectionRepresentation(false, posts, info.getRequestUri())).build();
	}

	@GET
	@Path("{timestamp}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPost(@PathParam("timestamp") String timestamp) {
		Post post = Application.getPost(user, timestamp);
		return Response.ok(new PostRepresentation(false, post)).build();
	}

	@POST
	public Response createPost(@FormParam("content") String content) {
		String timestamp = DateTimeFormat.forPattern("yyyyMMddHHmmss").print(new DateTime());
		Application.createPost(user, timestamp, content);
		URI uri = UriBuilder.fromPath(timestamp).build();
		return Response.created(uri).build();
	}

	@DELETE
	@Path("{timestamp}")
	public Response deletePost(@PathParam("timestamp") String timestamp) {
		Application.deletePost(user, timestamp);
		return Response.noContent().build();
	}

}
