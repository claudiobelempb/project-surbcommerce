package br.surb.com.br.dscommerce.shared.validation;

import br.surb.com.br.dscommerce.shared.exeptions.CustomError;
import br.surb.com.br.dscommerce.shared.exeptions.FieldMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError extends CustomError implements Serializable {

    @Serial
    private static final long serialVersionUID = -6407490236434397358L;

    private final List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public void addError(String filedName, String message) {
        errors.add(new FieldMessage(filedName, message));
    }

}
