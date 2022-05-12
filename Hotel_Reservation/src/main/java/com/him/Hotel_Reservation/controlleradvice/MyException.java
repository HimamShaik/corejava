package com.him.Hotel_Reservation.controlleradvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.him.Hotel_Reservation.entity.Admin;
import com.him.Hotel_Reservation.exception.InvalidCredentialException;
import com.him.Hotel_Reservation.exception.ResourceAllreadyExists;
import com.him.Hotel_Reservation.exception.ResourseNotFound;
import com.him.Hotel_Reservation.model.ErrorClass;

@ControllerAdvice
public class MyException extends ResponseEntityExceptionHandler {
	
	ErrorClass error=new ErrorClass();

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> map = new HashMap<>();
		List<ObjectError> error = ex.getBindingResult().getAllErrors();
		for (ObjectError obj : error) {
			String messgae = obj.getDefaultMessage();
			String fildmsg = ((FieldError) obj).getField();
			map.put(fildmsg, messgae);
		}
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceAllreadyExists.class)
	public ResponseEntity<Object> resourseallreadypresent(Exception e) {
		error.setStatus_Code(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(ResourseNotFound.class)
	public ResponseEntity<Object> resourseNotFound(Exception e) {
		error.setStatus_Code(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<Object> InvalidCredentials(Exception e) {
		error.setStatus_Code(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	
	

}
