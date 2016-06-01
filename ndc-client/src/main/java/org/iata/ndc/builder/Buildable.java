package org.iata.ndc.builder;

/**
 *
 * Interface for all builders
 */
public interface Buildable<T> {
    
    String VERSION = "15.2";
    
    T build();
}
