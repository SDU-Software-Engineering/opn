package io.swagger.api.factories;

import io.swagger.api.HelloworldApiService;
import io.swagger.api.impl.HelloworldApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-10T20:46:37.180Z")
public class HelloworldApiServiceFactory {
    private final static HelloworldApiService service = new HelloworldApiServiceImpl();

    public static HelloworldApiService getHelloworldApi() {
        return service;
    }
}
