package com.ethnicthv.rflib.node.eception;

public class RFException extends Exception{
    public RFException() {
    }

    public RFException(String message) {
        super(message);
    }

    public RFException(String message, Throwable cause) {
        super(message, cause);
    }

    public RFException(Throwable cause) {
        super(cause);
    }

    public RFException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
