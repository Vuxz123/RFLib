package com.ethnicthv.rflib.node.eception;

public class RFNotMatchTypeException extends RFException{
    public RFNotMatchTypeException() {
    }

    public RFNotMatchTypeException(String message) {
        super(message);
    }

    public RFNotMatchTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public RFNotMatchTypeException(Throwable cause) {
        super(cause);
    }

    public RFNotMatchTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
