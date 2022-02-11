package com.greaziel.adocao.exceptions.handle;

import com.greaziel.adocao.exceptions.TamanhoNaoValidoExeption;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.UnexpectedTypeException;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(TamanhoNaoValidoExeption.class)
    public ResponseEntity<DefaultException> hande(TamanhoNaoValidoExeption e){
        DefaultException defaultException = new DefaultException();
        defaultException.setMensagem(e.getMessage());
        defaultException.setDataHora(LocalDateTime.now());
        defaultException.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultException> hande(MethodArgumentNotValidException e){
        DefaultException defaultException = new DefaultException();
        defaultException.setMensagem("Não validou o campo");
        defaultException.setDataHora(LocalDateTime.now());
        defaultException.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<DefaultException> hande(UnexpectedTypeException e){
        DefaultException defaultException = new DefaultException();
        defaultException.setMensagem("Campos obrigatorios não preenchidos");
        defaultException.setDataHora(LocalDateTime.now());
        defaultException.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<DefaultException> hande(DataIntegrityViolationException e){
        DefaultException defaultException = new DefaultException();
        defaultException.setMensagem("Classe sendo utilizada por outra");
        defaultException.setDataHora(LocalDateTime.now());
        defaultException.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<DefaultException> hande(HttpMessageNotReadableException e){
        DefaultException defaultException = new DefaultException();
        defaultException.setMensagem("Não suportado");
        defaultException.setDataHora(LocalDateTime.now());
        defaultException.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);
    }

}
