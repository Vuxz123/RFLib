package com.ethnicthv.rflib.node.eception;

public class RFNullException extends RFException{
    public RFNullException() {
    }

    public RFNullException(String message) {
        super(message);
    }

    public RFNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public RFNullException(Throwable cause) {
        super(cause);
    }

    public RFNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
