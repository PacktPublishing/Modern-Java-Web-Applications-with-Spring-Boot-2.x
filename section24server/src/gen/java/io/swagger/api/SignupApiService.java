package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.ProfileInformation;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-09-01T10:52:02.844+08:00")
public abstract class SignupApiService {
    public abstract Response addNewFormSignupUsingPOST(Object reqParams,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addNewSignupUsingPOST(ProfileInformation profile,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteSignupUsingDELETE(String username,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getApprovedUsersUsingGET(SecurityContext securityContext) throws NotFoundException;
    public abstract Response getSignedupUserUsingGET(String username,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getSignedupUsersUsingGET(SecurityContext securityContext) throws NotFoundException;
    public abstract Response getTotalUsersUsingGET(SecurityContext securityContext) throws NotFoundException;
    public abstract Response partialupdateSignupUsingPATCH(Object updates,String username,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateSignupUsingPUT(ProfileInformation profile,String username,SecurityContext securityContext) throws NotFoundException;
}
