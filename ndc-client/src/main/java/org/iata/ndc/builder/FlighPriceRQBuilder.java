package org.iata.ndc.builder;

import org.iata.ndc.schema.FlightPriceRQ;
import org.iata.ndc.schema.MsgPartiesType;
import org.iata.ndc.schema.ObjectFactory;

/**
 *
 * Builder for the {@link FlighPriceRQ}
 */
public class FlighPriceRQBuilder implements Buildable<FlightPriceRQ>{
    private static final String MESSAGE = "NDC FlightPriceRQ Message";
    
    private final ObjectFactory factory;
    
    private FlightPriceRQ request;

    public FlighPriceRQBuilder() {
        this.factory = new ObjectFactory();
        clear();
    }
    
    public final void clear() {
        request = Initializer.getObject(FlightPriceRQ.class);
    }
    
    public FlighPriceRQBuilder setParty(MsgPartiesType party) {
        request.setParty(party);
        
        return this;
    }
    

    @Override
    public FlightPriceRQ build() {
        request.setVersion(VERSION);
        request.setDocument(MessageDocumentFactory.create(MESSAGE));
        return request;
    }
    
    
    
}
