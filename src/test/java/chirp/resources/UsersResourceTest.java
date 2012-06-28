package chirp.resources;

import java.io.Closeable;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
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
	
	@Test
	public void doSomething() {
		client.resource("http://this-is-your-hint.com:8080");
	}
}
