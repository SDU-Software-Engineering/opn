package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.HelloworldApiService;
import io.swagger.api.factories.HelloworldApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.StatusDTO;
import io.swagger.model.Person;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/helloworld")


@io.swagger.annotations.Api(description = "the helloworld API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-10T20:46:37.180Z")
public class HelloworldApi  {
   private final HelloworldApiService delegate = HelloworldApiServiceFactory.getHelloworldApi();

    @POST
    @Path("/hello")
    @Consumes({ "application/json", "text/json", "application/json-patch+json" })
    @Produces({ "text/plain", "application/json", "text/json" })
    @io.swagger.annotations.ApiOperation(value = "Say hello to the given user", notes = "This is an example of how the JSON should be structured             {                 \"firstName\" : \"Nicolai\",                 \"lastName\" : \"Oksen\"             }", response = StatusDTO.class, tags={ "Person", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = StatusDTO.class) })
    public Response helloWorldHello(@ApiParam(value = "Who to say hello to" ) Person who
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.helloWorldHello(who,securityContext);
    }
}
