package org.iata.ndc.builder;

import org.iata.ndc.schema.FlightPriceRQ;
import org.iata.ndc.schema.MsgPartiesType;

/**
 *
 * Builder for the {@link FlighPriceRQ}
 */
public class FlighPriceRQBuilder extends AbstractTravelAgencyBuilder<FlightPriceRQ> {

    private static final String MESSAGE = "NDC FlightPriceRQ Message";
    

    private FlightPriceRQ request;

    @Override
    public void doInitialize() {
        request = Initializer.getObject(FlightPriceRQ.class);
    }

    public FlighPriceRQBuilder setParty(MsgPartiesType party) {
        request.setParty(party);

        return this;
    }

    @Override
    public FlightPriceRQ build() {
        request.setVersion(VERSION);
        
        setDefaults();

        addTravelers();

        return request;
    }

    @Override
    protected void setDefaults() {
        super.setDefaults();
        request.setDocument(MessageDocumentFactory.create(MESSAGE));
        if(request.getParty() == null){
            MsgPartiesType party = getFactoy().createMsgPartiesType();
            party.setSender(getSender());
            request.setParty(party);
        }
    }

    private void addTravelers() {
        request.getTravelers().addAll(buildTravelers());
    }

}
