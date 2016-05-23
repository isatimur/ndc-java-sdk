package org.iata.ndc.builder;

/**
 *
 * Interface for all builders
 */
public interface Buildable<T> {
    
    String VERSION = "1.1.5";
    
    T build();
}
