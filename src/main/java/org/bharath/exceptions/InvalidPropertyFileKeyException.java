package org.bharath.exceptions;

public class InvalidPropertyFileKeyException extends FrameworkException {
    public InvalidPropertyFileKeyException(String message) {
        super(message);
    }

    public InvalidPropertyFileKeyException(String message, Throwable cause) {
        super(message, cause);
    }
}
