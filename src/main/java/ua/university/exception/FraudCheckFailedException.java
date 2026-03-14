package ua.university.exception;

public class FraudCheckFailedException extends RuntimeException {
    public FraudCheckFailedException(String message) {
        super(message);
    }

    public FraudCheckFailedException (String message, Throwable cause) {
        super(message, cause);
    }
}
