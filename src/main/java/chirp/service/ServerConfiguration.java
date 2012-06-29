package chirp.service;

import static org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;

@Provider
public class ServerConfiguration implements ContextResolver<ObjectMapper> {

	public ObjectMapper getContext(Class<?> type) {
		return new ObjectMapper().setSerializationInclusion(NON_NULL);
	}

}
