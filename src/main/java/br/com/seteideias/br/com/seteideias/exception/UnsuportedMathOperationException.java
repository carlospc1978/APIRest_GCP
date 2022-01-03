package br.com.seteideias.br.com.seteideias.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;


/**
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationException extends RuntimeException {

    private static final long serialVersionUID = 1l;

    private Date timeStamp;




}
