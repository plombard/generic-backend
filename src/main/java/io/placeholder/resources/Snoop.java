package io.placeholder.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/snoop")
public class Snoop {

  @GET
  public Response snoop() {
    return Response.ok().build();
  }
}
