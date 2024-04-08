package br.surb.com.br.dscommerce.http.response;

import java.io.Serial;
import java.io.Serializable;

public record DepartmentResponse(
        Long id,
        String name
) implements Serializable {

    @Serial
    private static final long serialVersionUID = -2393864564580731845L;
}
