package com.calro.clientmanager.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.calro.clientmanager.dto.ErrorDTO;
import com.calro.clientmanager.exceptions.ClientException;
import com.calro.clientmanager.exceptions.EntityException;
import com.calro.clientmanager.exceptions.TypeException;

import lombok.extern.slf4j.Slf4j;

@Component
@RestControllerAdvice
@Slf4j
public class HttpErrorHandler {

	private ResponseEntity<ErrorDTO> format(Exception e, HttpStatus status) {
		log.error(e.getLocalizedMessage());
		e.printStackTrace();

		String message = e.getLocalizedMessage();

		Integer code = status.value();
		return ResponseEntity.status(code)
				.body(ErrorDTO.builder().code(code).message(message).time(LocalDateTime.now()).build());
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorDTO> handlerException(Exception e) {
		return format(e, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ClientException.class)
	protected ResponseEntity<ErrorDTO> handlerClientException(ClientException e) {
		return format(e, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(TypeException.class)
	protected ResponseEntity<ErrorDTO> handlerTypeException(TypeException e) {
		return format(e, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EntityException.class)
	protected ResponseEntity<ErrorDTO> handlerEntityException(EntityException e) {
		return format(e, HttpStatus.NOT_FOUND);
	}
	
	

}
