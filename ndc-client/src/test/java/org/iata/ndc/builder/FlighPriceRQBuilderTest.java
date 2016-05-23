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
    public void testBuild() {
        FlightPriceRQ result = testedClass.build();
        assertNotNull(result);
    }
    
}
