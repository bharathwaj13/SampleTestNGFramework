package org.bharath.exceptions;

public class DriverInvocationFailedException extends FrameworkException {
    public DriverInvocationFailedException(String message) {
        super(message);
    }

    public DriverInvocationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
