package br.surb.com.br.dscommerce.mapper;

import br.surb.com.br.dscommerce.entities.Employee;
import br.surb.com.br.dscommerce.http.request.EmployeeCustomRequest;
import br.surb.com.br.dscommerce.http.request.EmployeeRequest;
import br.surb.com.br.dscommerce.http.response.EmployeeDepartmentResponse;
import br.surb.com.br.dscommerce.http.response.EmployeeResponse;

public class EmployeeMapper {
    public static Employee toRequest(EmployeeRequest request) {
        Employee response = new Employee();

        response.setId(request.id());
        response.setName(request.name());

        return response;
    }

    public static EmployeeResponse toResponse(Employee entity) {
        return new EmployeeResponse(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getDepartment().getId()
        );
    }

    public static Employee toCustomRequest(EmployeeCustomRequest request) {
        Employee response = new Employee();

        response.setId(request.id());
        response.setName(request.name());
        response.setEmail(request.email());
        response.setDepartment(request.department());

        return response;
    }

    public static EmployeeDepartmentResponse toCustomResponse(Employee entity) {
        return new EmployeeDepartmentResponse(
                entity.getId(),
                entity.getName(),
                entity.getEmail()
        );
    }
}
