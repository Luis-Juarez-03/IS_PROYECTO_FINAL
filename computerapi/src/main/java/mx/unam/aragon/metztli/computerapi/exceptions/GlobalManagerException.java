package mx.unam.aragon.metztli.computerapi.exceptions;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalManagerException {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<HashMap<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
        //return new ResponseEntity<>("Model Contraint Failed. Review definition Models and Fields" + ex.getConstraintName(), HttpStatus.BAD_REQUEST);
        HashMap<String, String> response = new HashMap<>();
        response.put("Message", "Model Contraint Failed. Review definition Models and Fields: " + ex.getConstraintName());
        response.put("Error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        HashMap<String, String> response = new HashMap<>();
        response.put("Message", "Model Contraint Failed. Review definition Models and Fields: " + ex.getLocalizedMessage());
        response.put("Error", ex.getMessage());
        ex.getBody().getProperties().forEach((key, value) -> response.put(key.toString(), value.toString()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
