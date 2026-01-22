package org.example;

public class MovieNotFoundException extends RuntimeException {
    /**
     *
     * @param message is the exception that will be thrown in the removeMovie method.
     */
    public MovieNotFoundException(String message) {
        super(message);
    }
}
