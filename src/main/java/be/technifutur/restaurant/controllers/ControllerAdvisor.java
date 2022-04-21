package be.technifutur.restaurant.controllers;

import be.technifutur.restaurant.exceptions.MailAlreadyExistException;
import be.technifutur.restaurant.exceptions.UsernameAlreadyExistException;
import be.technifutur.restaurant.models.dto.ErrorDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(UsernameAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handleUsernameAlreadyExist(UsernameAlreadyExistException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
                .body(
                        ErrorDTO.builder()
                                .id(1)
                                .message(ex.getMessage())
                                .method(HttpMethod.resolve(request.getMethod()))
                                .status(418)
                                .uri(request.getRequestURI())
                                .build()
                );
    }

    @ExceptionHandler(MailAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handleMailAlreadyExist(MailAlreadyExistException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        ErrorDTO.builder()
                                .id(2)
                                .message(ex.getMessage())
                                .method(HttpMethod.resolve(request.getMethod()))
                                .status(400)
                                .uri(request.getRequestURI())
                                .build()
                );
    }
}
