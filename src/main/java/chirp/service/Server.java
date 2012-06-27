package chirp.service;

import java.io.Closeable;
import java.io.IOException;

import com.sun.jersey.simple.container.SimpleServerFactory;

public class Server {

	public static void main(String[] args) {
		try {
			Closeable server = SimpleServerFactory.create("http://localhost:8080");
			try {
				System.out.println("Hit return to shut down server.");
				System.in.read();
			} finally {
				server.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
