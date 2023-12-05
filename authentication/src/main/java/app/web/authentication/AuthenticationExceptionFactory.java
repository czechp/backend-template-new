package app.web.authentication;

import app.web.exception.ConditionsNotFulfilled;

class AuthenticationExceptionFactory {
    static RuntimeException userAlreadyExists(String login, String email) {
        return new ConditionsNotFulfilled(String.format("Użytkownik z loginem: %s lub emailem: %s już istnieje", login, email));
    }
}
