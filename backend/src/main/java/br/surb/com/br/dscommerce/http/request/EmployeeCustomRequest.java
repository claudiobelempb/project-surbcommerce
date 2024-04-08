package br.surb.com.br.dscommerce.http.request;

import br.surb.com.br.dscommerce.entities.Department;

import java.io.Serial;
import java.io.Serializable;

public record EmployeeCustomRequest(
        Long id,
        String name,
        String email,
        Department department
) implements Serializable {


    @Serial
    private static final long serialVersionUID = 8651012614601811407L;

    public static record EmployeeRequest(
            Long id,
            String name,
            String email,
            Department department
    ) implements Serializable {

        @Serial
        private static final long serialVersionUID = 6953408142515376841L;
    }
}
