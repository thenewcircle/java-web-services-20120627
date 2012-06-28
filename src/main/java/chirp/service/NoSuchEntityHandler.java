package chirp.service;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import chirp.model.NoSuchEntityError;

@Provider
public class NoSuchEntityHandler implements ExceptionMapper<NoSuchEntityError> {

	public Response toResponse(NoSuchEntityError exception) {
		return Response.status(Status.NOT_FOUND).build();
	}

}
