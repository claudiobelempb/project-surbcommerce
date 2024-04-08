package br.surb.com.br.dscommerce.http.response;

import br.surb.com.br.dscommerce.entities.Employee;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record DepartmentCustomResponse(
        Long id,
        String name,
        List<Employee> employees
) implements Serializable {


    @Serial
    private static final long serialVersionUID = -2048181129951359238L;
}
