package chirp.service;

import static org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.api.core.ResourceConfigurator;
import com.sun.jersey.server.linking.LinkFilter;

@Provider
public class ServerConfiguration implements ResourceConfigurator, ContextResolver<ObjectMapper> {

	@SuppressWarnings("unchecked")
	public void configure(ResourceConfig config) {
		config.getContainerResponseFilters().add(LinkFilter.class);
	}

	public ObjectMapper getContext(Class<?> type) {
		return new ObjectMapper().setSerializationInclusion(NON_NULL);
	}

}
