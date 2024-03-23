package br.surb.com.br.dscommerce.shared.exeptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
public class CustomError implements Serializable {
    @Serial
    private static final long serialVersionUID = 4425871258555747338L;

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

}