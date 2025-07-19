package org.jugistanbul.ai.client;

import dev.langchain4j.agent.tool.Tool;
import io.quarkus.rest.client.reactive.ClientQueryParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestQuery;

/**
 * @author hakdogan (hakdogan75@gmail.com)
 * Created on 15.07.2025
 ***/
@RegisterRestClient(configKey = "exchangeapi")
public interface ExchangeRestClient {

    @GET
    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    @ClientQueryParam(name = "function", value = "CURRENCY_EXCHANGE_RATE")
    @ClientQueryParam(name = "apikey", value = "${api.exchange.key}")
    @Tool("Returns the current price of the given exchange rate")
    String fetchExchangePrice(@RestQuery("from_currency") String fromCurrency,
                              @RestQuery("to_currency") String toCurrency);
}
