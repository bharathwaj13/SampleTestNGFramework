package org.bharath.exceptions;

public class InvalidPropertyFilePathException extends InvalidFilePathException{
    public InvalidPropertyFilePathException(String message) {
        super(message);
    }

    public InvalidPropertyFilePathException(String message, Throwable cause) {
        super(message, cause);
    }
}
