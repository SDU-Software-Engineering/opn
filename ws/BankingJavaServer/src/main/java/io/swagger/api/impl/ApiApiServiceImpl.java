package io.swagger.api.impl;

import io.swagger.api.*;
import dk.sdu.mmmi.opn.swaggerbank.model.*;

import dk.sdu.mmmi.opn.swaggerbank.model.CredentialAndAccount;
import dk.sdu.mmmi.opn.swaggerbank.model.CustomerDTO;
import dk.sdu.mmmi.opn.swaggerbank.model.DepositOrWithdrawDTO;
import dk.sdu.mmmi.opn.swaggerbank.model.Credential;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-04T09:28:53.557+02:00")
public class ApiApiServiceImpl extends ApiApiService {
    @Override
    public Response apiBankAccrueInterestPost(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response apiBankCreateAccountPost(CredentialAndAccount credentialAndAccount, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response apiBankCreatePost(String name, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response apiBankDepositPost(DepositOrWithdrawDTO deposit, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response apiBankLoginPost(Credential credential, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response apiBankWithdrawPost(DepositOrWithdrawDTO withdraw, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
