package io.placeholder.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.StringJoiner;

import static javax.ws.rs.HttpMethod.*;

/**
 * @author Pascal Lombard
 * @since 22/01/2017.
 */
@Provider
public class CorsResponseFilter implements ContainerResponseFilter {
  @Override
  public void filter(ContainerRequestContext containerRequestContext,
                     ContainerResponseContext containerResponseContext)
      throws IOException {
    containerResponseContext.getHeaders().add("Access-Control-Allow-Origin",
        "*");
    containerResponseContext.getHeaders().add("Access-Control-Allow-Headers",
        "origin, content-type, accept, authorization");
    containerResponseContext.getHeaders().add
        ("Access-Control-Allow-Credentials", "true");
    containerResponseContext.getHeaders().add("Access-Control-Allow-Methods",
        new StringJoiner(",")
            .add(GET)
            .add(POST)
            .add(PUT)
            .add(DELETE)
            .add(OPTIONS)
            .add(HEAD)
            .toString());
  }
}
