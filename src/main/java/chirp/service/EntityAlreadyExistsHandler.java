package chirp.service;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import chirp.model.EntityAlreadyExistsError;

@Provider
public class EntityAlreadyExistsHandler implements ExceptionMapper<EntityAlreadyExistsError> {

	public Response toResponse(EntityAlreadyExistsError exception) {
		return Response.status(Status.FORBIDDEN).build();
	}

}
