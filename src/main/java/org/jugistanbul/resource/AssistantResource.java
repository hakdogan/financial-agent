package org.jugistanbul.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jugistanbul.ai.api.FinancialAssistant;

/**
 * @author hakdogan (hakdogan75@gmail.com)
 * Created on 15.07.2025
 ***/

@Path("/api/v1")
public class AssistantResource {

    private final FinancialAssistant expert;

    public AssistantResource(FinancialAssistant expert) {
        this.expert = expert;
    }

    @GET
    @Path("/exchange/{question}")
    @Produces(MediaType.TEXT_PLAIN)
    public String info(String question){
        return expert.priceInfo(question);
    }
}
