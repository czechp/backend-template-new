package app.web.web;

import app.web.exception.ConditionsNotFulfilled;
import app.web.exception.ElementNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;

@ControllerAdvice
class ControllerAdviceHandler {

    @ExceptionHandler({ConditionsNotFulfilled.class})
    ResponseEntity<HashMap<String, String>> badRequestHandler(Exception exception) {
        return new ResponseEntity<>(buildBody(exception), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ElementNotFound.class})
    ResponseEntity<HashMap<String, String>> notFoundHandler(Exception exception) {
        return new ResponseEntity<>(buildBody(exception), HttpStatus.NOT_FOUND);
    }


    private HashMap<String, String> buildBody(Exception exception) {
        HashMap<String, String> requestBody = new HashMap<>();
        requestBody.put("message", exception.getMessage());
        requestBody.put("timestamp", LocalDateTime.now().toString());
        return requestBody;
    }
}
