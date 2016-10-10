package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.StatusDTO;
import io.swagger.model.Person;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import dk.sdu.mmmi.opn.hellows.HelloServer;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-10T20:46:37.180Z")
public class HelloworldApiServiceImpl extends HelloworldApiService {
    @Override
    public Response helloWorldHello(Person who, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(HelloServer.get().hello(who)).build();
    }
}
