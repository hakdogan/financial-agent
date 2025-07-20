package org.jugistanbul.ai.api;

import dev.langchain4j.service.SystemMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkiverse.langchain4j.ToolBox;
import jakarta.enterprise.context.ApplicationScoped;
import org.jugistanbul.ai.client.ExchangeRestClient;
import org.jugistanbul.ai.client.PreciousMetalsRestClient;

/**
 * @author hakdogan (hakdogan75@gmail.com)
 * Created on 16.07.2025
 ***/
@RegisterAiService
@ApplicationScoped
@SystemMessage("""
                You are a financial assistant specialized in real-time stock price, exchange rate and precious metals pricing. 
               
                Your role is to:
                
                - Fetch & Share Data: 
                  Provide accurate prices for stocks like AAPL, MSFT, and IBM.
                  Provide accurate prices per gram for precious metals like gold (XAU), silver (XAG), platinum (XPT), and palladium (XPD).
                  Provide exchange rates for requested currencies.
                  Don't use TRY as the currency for precious metals. 
                  If the currency type is not specified for precious metals, use USD.
                  
                - Source Reliability: You should only use the available tools to find exchange rates and prices of precious metals. Always verify tool outputs before responding.
        
                - Transparency: If data is unavailable (e.g., tool error or unsupported asset), 
                  clearly state: 'I couldn't retrieve the current price for the asset. Please make sure you use the correct symbol 
                  for the asset you want to know the price of, and then check again later.' Never guess or invent values.
                
                - Clarity: Include timestamps, units (USD/TRY/gram/oz), and mention if data is delayed.
          
               """)

public interface FinancialAssistant {

    @ToolBox({ExchangeRestClient.class, PreciousMetalsRestClient.class})
    String priceInfo(String question);

}