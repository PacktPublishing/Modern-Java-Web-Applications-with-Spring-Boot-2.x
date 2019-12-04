package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.SignupApiService;
import io.swagger.api.factories.SignupApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.ProfileInformation;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/signup")


@io.swagger.annotations.Api(description = "the signup API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-09-01T10:52:02.844+08:00")
public class SignupApi  {
   private final SignupApiService delegate;

   public SignupApi(@Context ServletConfig servletContext) {
      SignupApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("SignupApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (SignupApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = SignupApiServiceFactory.getSignupApi();
      }

      this.delegate = delegate;
   }

    @POST
    @Path("/user/add/form")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "*/*" })
    @io.swagger.annotations.ApiOperation(value = "Add new user.", notes = "", response = String.class, tags={ "signup-controller", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful data entry!", response = String.class),
        
        @io.swagger.annotations.ApiResponse(code = 201, message = "Created", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Request handler problem!", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "URL invalid!", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Form data invalid!", response = Void.class) })
    public Response addNewFormSignupUsingPOST(@ApiParam(value = "reqParams", required=true)  @FormParam("reqParams")  Object reqParams
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addNewFormSignupUsingPOST(reqParams,securityContext);
    }
    @POST
    @Path("/user/add")
    @Consumes({ "application/json", "Profile data" })
    @Produces({ "*/*" })
    @io.swagger.annotations.ApiOperation(value = "Add new user.", notes = "", response = String.class, tags={ "signup-controller", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = String.class),
        
        @io.swagger.annotations.ApiResponse(code = 201, message = "Created", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found", response = Void.class) })
    public Response addNewSignupUsingPOST(@ApiParam(value = "profile" ,required=true) ProfileInformation profile
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addNewSignupUsingPOST(profile,securityContext);
    }
    @DELETE
    @Path("/user/delete/{username}")
    
    @Produces({ "*/*" })
    @io.swagger.annotations.ApiOperation(value = "Delete user account.", notes = "", response = String.class, tags={ "signup-controller", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully deleted profile!", response = String.class),
        
        @io.swagger.annotations.ApiResponse(code = 204, message = "No Content", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Request handler problem!", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "URL invalid!", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Delete transaction invalid!", response = Void.class) })
    public Response deleteSignupUsingDELETE(@ApiParam(value = "username",required=true) @PathParam("username") String username
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteSignupUsingDELETE(username,securityContext);
    }
    @GET
    @Path("/users/approved")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns all approved users only.", notes = "", response = Object.class, responseContainer = "List", tags={ "signup-controller", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Object.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found", response = Void.class) })
    public Response getApprovedUsersUsingGET(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getApprovedUsersUsingGET(securityContext);
    }
    @GET
    @Path("/users/{username}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns users with matched username.", notes = "", response = Object.class, responseContainer = "List", tags={ "signup-controller", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Object.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found", response = Void.class) })
    public Response getSignedupUserUsingGET(@ApiParam(value = "Login username",required=true) @PathParam("username") String username
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getSignedupUserUsingGET(username,securityContext);
    }
    @GET
    @Path("/users")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns all users.", notes = "", response = Object.class, responseContainer = "List", tags={ "signup-controller", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Object.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found", response = Void.class) })
    public Response getSignedupUsersUsingGET(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getSignedupUsersUsingGET(securityContext);
    }
    @GET
    @Path("/users/count")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Returns total number of users.", notes = "", response = String.class, tags={ "signup-controller", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = String.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found", response = Void.class) })
    public Response getTotalUsersUsingGET(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getTotalUsersUsingGET(securityContext);
    }
    @PATCH
    @Path("/user/update/partial/{username}")
    @Consumes({ "application/json" })
    @Produces({ "*/*" })
    @io.swagger.annotations.ApiOperation(value = "Update some profile detail.", notes = "", response = String.class, tags={ "signup-controller", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully updated profile!", response = String.class),
        
        @io.swagger.annotations.ApiResponse(code = 204, message = "No Content", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Request handler problem!", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "URL invalid!", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Partial update transaction invalid!", response = Void.class) })
    public Response partialupdateSignupUsingPATCH(@ApiParam(value = "updates" ,required=true) Object updates
,@ApiParam(value = "username",required=true) @PathParam("username") String username
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.partialupdateSignupUsingPATCH(updates,username,securityContext);
    }
    @PUT
    @Path("/user/update/full/{username}")
    @Consumes({ "application/json" })
    @Produces({ "*/*" })
    @io.swagger.annotations.ApiOperation(value = "Update a user account.", notes = "", response = String.class, tags={ "signup-controller", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully updated profile!", response = String.class),
        
        @io.swagger.annotations.ApiResponse(code = 201, message = "Created", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Request handler problem!", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "URL invalid!", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Update transaction invalid!", response = Void.class) })
    public Response updateSignupUsingPUT(@ApiParam(value = "profile" ,required=true) ProfileInformation profile
,@ApiParam(value = "username",required=true) @PathParam("username") String username
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateSignupUsingPUT(profile,username,securityContext);
    }
}
