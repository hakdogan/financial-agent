package org.jugistanbul.ai.client;

import dev.langchain4j.agent.tool.Tool;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * @author hakdogan (hakdogan75@gmail.com)
 * Created on 16.07.2025
 ***/
@RegisterRestClient(configKey = "preciousmetalsapi")
public interface PreciousMetalsRestClient {

    @GET
    @Path("/api/{metal}/{currency}")
    @ClientHeaderParam(name = "x-access-token", value = "${api.precious.metals.key}")
    @Tool("Returns the current price of the given precious metal")
    String fetchPreciousMetalsPrice(@PathParam("metal") String metal,
                                    @PathParam("currency") String  currency);
}
