package io.swagger.api.factories;

import io.swagger.api.SignupApiService;
import io.swagger.api.impl.SignupApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-09-01T10:52:02.844+08:00")
public class SignupApiServiceFactory {
    private final static SignupApiService service = new SignupApiServiceImpl();

    public static SignupApiService getSignupApi() {
        return service;
    }
}
