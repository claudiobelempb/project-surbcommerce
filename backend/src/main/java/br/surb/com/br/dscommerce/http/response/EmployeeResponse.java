package br.surb.com.br.dscommerce.http.response;

import java.io.Serial;
import java.io.Serializable;

public record EmployeeResponse(
        Long id,
        String name,
        String email,
        Long department
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1264370032724159623L;
}
