package br.surb.com.br.dscommerce.shared.exeptions;

import br.surb.com.br.dscommerce.shared.exeptions.CustomError;
import br.surb.com.br.dscommerce.shared.exeptions.resource.ResourceNotFondExecption;
import br.surb.com.br.dscommerce.shared.exeptions.service.ServiceDataIntegrityViolationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceAdviceExceptionHandler {

    @ExceptionHandler(ResourceNotFondExecption.class)
    public ResponseEntity<CustomError> resourceNotFond(ResourceNotFondExecption e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ServiceDataIntegrityViolationException.class)
    public ResponseEntity<CustomError> serviceDataIntegrityViolation(ServiceDataIntegrityViolationException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
