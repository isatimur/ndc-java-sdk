package org.iata.ndc.builder;

import java.util.List;
import org.iata.ndc.schema.FlightPriceRQ;
import org.iata.ndc.schema.MsgPartiesType;
import org.iata.ndc.schema.ObjectFactory;
import org.iata.ndc.schema.TravelersTraveler;

/**
 *
 * Builder for the {@link FlighPriceRQ}
 */
public class FlighPriceRQBuilder implements Buildable<FlightPriceRQ> {

    private static final String MESSAGE = "NDC FlightPriceRQ Message";
    
    private final ObjectFactory factoy;

    private TravelersTravelerBuilder travelerBuilder;

    private FlightPriceRQ request;

    public FlighPriceRQBuilder() {
        factoy = new ObjectFactory();
        clear();
    }

    public final void clear() {
        travelerBuilder = new TravelersTravelerBuilder();
        request = Initializer.getObject(FlightPriceRQ.class);
    }

    /**
     * Adds anonymous traveler of type {@link Traveler} to traveler list.<br>
     * <strong>Note:</strong> if this type of traveler already exists,
     * increments the count for this type of traveler.
     *
     * @param traveler type of traveler
     * @return current builder instance
     */
    public FlighPriceRQBuilder addAnonymousTraveler(Traveler traveler) {
        return addAnonymousTravelers(traveler, 1);
    }

    /**
     * Adds multiple anonymous travelers of type {@link Traveler} to traveler
     * list.<br>
     * <strong>Note:</strong> if this type of traveler already exists,
     * increments the count for this type of traveler.
     *
     * @param traveler type of traveler
     * @param count number of travelers
     * @return current builder instance
     */
    public FlighPriceRQBuilder addAnonymousTravelers(Traveler traveler, int count) {
        travelerBuilder.addAnonymousTravelers(traveler, count);
        return this;
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

    private void setDefaults() {
        request.setDocument(MessageDocumentFactory.create(MESSAGE));
        travelerBuilder.setDefaults();
        if(request.getParty() == null){
            MsgPartiesType party = factoy.createMsgPartiesType();
            //TODO we need an object with some meanigfull data here
            MsgPartiesType.Sender sender = factoy.createMsgPartiesTypeSender();
            party.setSender(sender);
            request.setParty(party);
        }
    }

    private void addTravelers() {
        List<TravelersTraveler> travelers = travelerBuilder.build();
        request.getTravelers().addAll(travelers);
    }

}
