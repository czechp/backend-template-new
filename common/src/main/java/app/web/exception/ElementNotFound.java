package app.web.exception;

public class ElementNotFound extends RuntimeException {
    ElementNotFound(String message) {
        super(message);
    }
}
