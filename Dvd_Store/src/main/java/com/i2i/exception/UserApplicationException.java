package com.i2i.exception;

/**
 * <h1>UserApplicationException</h1>
 * <p>
 * UserApplicationException class is user defined exception
 * which extends the Exception class and handles
 * the exception and print the error message to the user
 * </p>
 *
 * @author Manikandan
 * @created 2016-07-25
 */
public class UserApplicationException extends Exception {
    
    /**
     * <p>
     * This UserApplicationException method override the Exception method
     * </p>
     * @param message   which holds the message  
     */ 
    public UserApplicationException(String message) {
        super(message);
    }    
    
    /** 
     * This UserApplicationException method override the Exception method
     * @param message   which holds the message 
     * @param exception  Exception object   
     */    
    public UserApplicationException(String message, Throwable exception) {
        super(message, exception);
    } 
}