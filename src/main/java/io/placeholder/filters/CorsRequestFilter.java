package io.placeholder.filters;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * @author Pascal Lombard
 * @since 22/01/2017.
 */
@Provider
@PreMatching
public class CorsRequestFilter implements ContainerRequestFilter {
  @Override
  public void filter(ContainerRequestContext containerRequestContext) throws
      IOException {

    if (containerRequestContext.getRequest().getMethod().equals(HttpMethod
        .OPTIONS)) {
      // Just send a OK signal back to the browser
      containerRequestContext.abortWith(Response.status(Response.Status.OK)
          .build());
    }
  }
}
