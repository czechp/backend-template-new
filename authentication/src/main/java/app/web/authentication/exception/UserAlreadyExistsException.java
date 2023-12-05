package app.web.authentication.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String login, String email) {
        super(String.format("Użytkownik z loginem: %s lub emailem: %s już istnieje", login, email));
    }
}
