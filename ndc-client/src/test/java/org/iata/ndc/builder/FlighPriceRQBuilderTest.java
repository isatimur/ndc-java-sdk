package org.iata.ndc.builder;

import org.iata.ndc.schema.FlightPriceRQ;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class FlighPriceRQBuilderTest {
    
    private FlighPriceRQBuilder testedClass;
    
    @Before
    public void setUp() {
        testedClass = new FlighPriceRQBuilder();
    }
    
    /**
     * Test of build method, of class FlighPriceRQBuilder.
     */
    @Test
    public void testBuild_Travelers() {
        FlightPriceRQ result = testedClass.build();
        assertEquals(1, result.getTravelers().size());
    }
    
     /**
     * Test of build method, of class FlighPriceRQBuilder.
     */
    @Test
    public void testBuild_Sender() {
        FlightPriceRQ result = testedClass.build();
        assertNotNull(result.getParty().getSender());
    }
}
