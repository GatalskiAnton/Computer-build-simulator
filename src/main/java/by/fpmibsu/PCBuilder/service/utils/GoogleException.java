package by.fpmibsu.PCBuilder.service.utils;


public class GoogleException extends Exception {
    public GoogleException() {

    }

    public GoogleException(String message) {
        super(message);
    }

    public GoogleException(String massage, Throwable cause) {
        super(massage, cause);
    }

    public GoogleException(Throwable cause) {
        super(cause);
    }
}
