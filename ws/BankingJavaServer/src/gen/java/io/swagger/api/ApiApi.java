package io.swagger.api;

import dk.sdu.mmmi.opn.swaggerbank.model.*;
import io.swagger.api.ApiApiService;
import io.swagger.api.factories.ApiApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import dk.sdu.mmmi.opn.swaggerbank.model.CredentialAndAccount;
import dk.sdu.mmmi.opn.swaggerbank.model.CustomerDTO;
import dk.sdu.mmmi.opn.swaggerbank.model.DepositOrWithdrawDTO;
import dk.sdu.mmmi.opn.swaggerbank.model.Credential;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/api")


@io.swagger.annotations.Api(description = "the api API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-04T09:28:53.557+02:00")
public class ApiApi  {
   private final ApiApiService delegate = ApiApiServiceFactory.getApiApi();

    @POST
    @Path("/Bank/accrue-interest")
    
    @Produces({ "text/plain", "application/json", "text/json" })
    @io.swagger.annotations.ApiOperation(value = "Placeholder for the action that is invoked when you ask to accrue interest             Functionality: for every account, add positive or negative interest to             the Balance of the account.", notes = "", response = String.class, tags={ "Bank", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = String.class) })
    public Response apiBankAccrueInterestPost(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.apiBankAccrueInterestPost(securityContext);
    }
    @POST
    @Path("/Bank/create-account")
    @Consumes({ "application/json", "text/json", "application/json-patch+json" })
    @Produces({ "text/plain", "application/json", "text/json" })
    @io.swagger.annotations.ApiOperation(value = "Create an account for the given user", notes = "This is an example of how the JSON should be structured             {                 \"credential\" : {                  \"name\" : \"Nicolai\",                  \"id\" : 1                  },                 \"account\" : {                  \"name\" : \"Budget Account\",                  \"PositiveInterest\" : 2.0,                  \"NegativeInterest\" : 5.0                 }             }", response = CustomerDTO.class, tags={ "Bank", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = CustomerDTO.class) })
    public Response apiBankCreateAccountPost(@ApiParam(value = "CredentialAndAccount object containing credential and account information" ) CredentialAndAccount credentialAndAccount
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.apiBankCreateAccountPost(credentialAndAccount,securityContext);
    }
    @POST
    @Path("/Bank/create")
    @Consumes({ "application/json", "text/json", "application/json-patch+json" })
    @Produces({ "text/plain", "application/json", "text/json" })
    @io.swagger.annotations.ApiOperation(value = "Create a new user", notes = "This is an example of how the BODY should be structured              \"Nicolai Oksen\"", response = CustomerDTO.class, tags={ "Bank", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = CustomerDTO.class) })
    public Response apiBankCreatePost(@ApiParam(value = "Name of customer" ) String name
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.apiBankCreatePost(name,securityContext);
    }
    @POST
    @Path("/Bank/deposit")
    @Consumes({ "application/json", "text/json", "application/json-patch+json" })
    @Produces({ "text/plain", "application/json", "text/json" })
    @io.swagger.annotations.ApiOperation(value = "Deposit money on the given account of the given customer", notes = "This is an example of how the JSON should be structured             {             \"credential\" : {              \"name\" : \"Nicolai\",              \"id\" : 1              },             \"accountId\" : 2,             \"amount\" : 100.0             }", response = CustomerDTO.class, tags={ "Bank", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = CustomerDTO.class) })
    public Response apiBankDepositPost(@ApiParam(value = "JSON object containing credentials, account id and withdraw amount" ) DepositOrWithdrawDTO deposit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.apiBankDepositPost(deposit,securityContext);
    }
    @POST
    @Path("/Bank/login")
    @Consumes({ "application/json", "text/json", "application/json-patch+json" })
    @Produces({ "text/plain", "application/json", "text/json" })
    @io.swagger.annotations.ApiOperation(value = "Login to the system with the given user", notes = "This is an example of how the JSON should be structured             {                 \"name\" : \"Nicolai\",                 \"id\" : 1             }", response = CustomerDTO.class, tags={ "Bank", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = CustomerDTO.class) })
    public Response apiBankLoginPost(@ApiParam(value = "Login credentials for customer" ) Credential credential
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.apiBankLoginPost(credential,securityContext);
    }
    @POST
    @Path("/Bank/withdraw")
    @Consumes({ "application/json", "text/json", "application/json-patch+json" })
    @Produces({ "text/plain", "application/json", "text/json" })
    @io.swagger.annotations.ApiOperation(value = "Withdraw money from the given account of the given customer", notes = "This is an example of how the JSON should be structured             {             \"credential\" : {              \"name\" : \"Nicolai\",              \"id\" : 1              },             \"accountId\" : 2,             \"amount\" : 100.0             }", response = CustomerDTO.class, tags={ "Bank", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = CustomerDTO.class) })
    public Response apiBankWithdrawPost(@ApiParam(value = "JSON object containing credentials, account id and withdraw amount" ) DepositOrWithdrawDTO withdraw
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.apiBankWithdrawPost(withdraw,securityContext);
    }
}
