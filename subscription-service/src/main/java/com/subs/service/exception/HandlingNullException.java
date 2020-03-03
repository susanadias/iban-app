package com.subs.service.exception;



import java.util.Optional;
import java.util.function.Supplier;

/*
 * HandlingNullException class: If some object have null exception
 * This class return an optional to protect null exceptions
 * 
 */

public abstract class HandlingNullException {
    
    public static <T> Optional<T> resolve(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }


}
