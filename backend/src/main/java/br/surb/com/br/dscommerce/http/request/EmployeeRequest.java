package br.surb.com.br.dscommerce.http.request;

import br.surb.com.br.dscommerce.entities.Department;

import java.io.Serial;
import java.io.Serializable;

public record EmployeeRequest(
        Long id,
        String name,
        String email,
        Department department
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 3098490099869484699L;
}
