package com.prismaticsoftware.leavemanagementsystem.exception;

import com.prismaticsoftware.leavemanagementsystem.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.bind.ValidationException;

/**
 * Purpose : Handle both the validation and custom exception if it is occurred
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 07-04-2022
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = NoDataFoundException.class)
    public ResponseEntity<ResponseDto> handleCustomException(NoDataFoundException noDataFoundException) {
        return new ResponseEntity<ResponseDto>(new ResponseDto(noDataFoundException.getMessage(), null), HttpStatus.BAD_REQUEST);
    }

    /**
     * Purpose : This method is used to handle Validation Exception occurred during the handle of validation fields
     *
     * @param validationException defines exception occurred during validation
     * @return response message if it is occurred
     */
    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<ResponseDto> handleValidationException(ValidationException validationException) {
        return new ResponseEntity<>(new ResponseDto(validationException.getMessage(), null), HttpStatus.NOT_FOUND);
    }

}
