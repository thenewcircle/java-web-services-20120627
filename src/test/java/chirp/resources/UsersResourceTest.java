package chirp.resources;

import java.io.Closeable;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;
import com.sun.jersey.simple.container.SimpleServerFactory;

public class UsersResourceTest {

	private Closeable server;
	private Client client;

	@Before
	public void startServer() throws IOException {
		server = SimpleServerFactory.create("http://localhost:8080");
		client = Client.create();
	}

	@After
	public void stopServer() throws IOException {
		server.close();
		client.destroy();
	}

	private ClientResponse postNewUser(String username, String realname) {
		WebResource resource = client.resource("http://localhost:8080/users");
		Form form = new Form();
		form.add("username", username);
		form.add("realname", realname);

		return resource.post(ClientResponse.class, form);
	}

	@Test
	public void postNewUserShouldReturnCreated() {
		ClientResponse response = postNewUser("dr", "Dan Rosen");
		Assert.assertEquals(ClientResponse.Status.CREATED, response.getClientResponseStatus());
	}
}
