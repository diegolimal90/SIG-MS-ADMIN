package br.com.sig.msadmin.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.sig.msadmin.exception.entity.StandardError;

@ControllerAdvice
public class ControllerHandler {

	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> notFound(DataBaseException e, HttpServletRequest request) {
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
	}
}
