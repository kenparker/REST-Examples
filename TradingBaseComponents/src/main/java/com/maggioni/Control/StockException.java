package com.maggioni.Control;

/**
 *
 * @author angelomaggioni
 */
public class StockException extends Exception {
    
    private static final long serialVersionUID = 4664456874499611218L;

    private String errorCode = "Unknown_Exception";

    public StockException(String message, String errorCode)
    {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode()
    {
        return errorCode;
    }
    
   
    
    

}
