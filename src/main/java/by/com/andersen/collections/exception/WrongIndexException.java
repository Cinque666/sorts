package by.com.andersen.collections.exception;

public class WrongIndexException extends Exception {

    public WrongIndexException() {
    }

    public WrongIndexException(String message) {
        super(message);
    }

    public WrongIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongIndexException(Throwable cause) {
        super(cause);
    }

    public WrongIndexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
