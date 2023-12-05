package app.web.exception;

public class ConditionsNotFulfilled extends RuntimeException {
    public ConditionsNotFulfilled(String message) {
        super(message);
    }
}
