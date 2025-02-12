package org.bharath.exceptions;

public class IncorrectExcelFilePathException extends InvalidFilePathException {


    public IncorrectExcelFilePathException(String message) {
        super(message);
    }

    public IncorrectExcelFilePathException(String message, Throwable cause) {
        super(message, cause);
    }
}
