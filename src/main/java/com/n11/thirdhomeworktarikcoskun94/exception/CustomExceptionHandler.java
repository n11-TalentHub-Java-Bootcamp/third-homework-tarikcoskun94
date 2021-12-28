package com.n11.thirdhomeworktarikcoskun94.exception;

import com.n11.thirdhomeworktarikcoskun94.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    /** START: HttpStatus.NOT_FOUND Exceptions */
    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException userNotFoundException) {

        ExceptionDTO exceptionDTO = ExceptionDTO.builder()
                .errorTitle(userNotFoundException.getErrorTitle())
                .errorMessages(userNotFoundException.getErrorMessages())
                .httpStatus(HttpStatus.NOT_FOUND)
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ProductCommentNotFoundException.class})
    public ResponseEntity<?> handleProductCommentNotFoundException(ProductCommentNotFoundException productCommentNotFoundException) {

        ExceptionDTO exceptionDTO = ExceptionDTO.builder()
                .errorTitle(productCommentNotFoundException.getErrorTitle())
                .errorMessages(productCommentNotFoundException.getErrorMessages())
                .httpStatus(HttpStatus.NOT_FOUND)
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }
    /** END: HttpStatus.NOT_FOUND Exceptions */
}
