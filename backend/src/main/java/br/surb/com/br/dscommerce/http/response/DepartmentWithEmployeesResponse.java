package br.surb.com.br.dscommerce.http.response;



import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record DepartmentWithEmployeesResponse(
        Long id,
        String name,
        List<EmployeeResponse> employees
) implements Serializable {

    @Serial
    private static final long serialVersionUID = -2393864564580731845L;
}
