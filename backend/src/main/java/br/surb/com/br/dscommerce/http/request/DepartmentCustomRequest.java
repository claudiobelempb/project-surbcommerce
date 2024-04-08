package br.surb.com.br.dscommerce.http.request;

import br.surb.com.br.dscommerce.entities.Employee;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record DepartmentCustomRequest(
        Long id,
        String name,
        List<Employee> employees
) implements Serializable {

    @Serial
    private static final long serialVersionUID = -649716451055622703L;

}
