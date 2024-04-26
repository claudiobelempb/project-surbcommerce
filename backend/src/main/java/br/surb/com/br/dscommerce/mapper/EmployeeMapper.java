package br.surb.com.br.dscommerce.mapper;

import br.surb.com.br.dscommerce.entities.Department;
import br.surb.com.br.dscommerce.entities.Employee;
import br.surb.com.br.dscommerce.http.request.EmployeeRequest;
import br.surb.com.br.dscommerce.http.response.DepartmentResponse;
import br.surb.com.br.dscommerce.http.response.EmployeeDepartmentResponse;
import br.surb.com.br.dscommerce.http.response.EmployeeResponse;

import java.util.List;
import java.util.stream.Collectors;

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
                entity.getEmail()
        );
    }

    public static EmployeeDepartmentResponse toEmployeeDepartmentResponse1(Employee entity) {
        return new EmployeeDepartmentResponse(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
               new DepartmentResponse(entity.getDepartment().getId(),  entity.getDepartment().getName())
        );
    }

    public static List<EmployeeResponse> toEmployeeDepartmentResponse(Department response) {
        return response.getEmployees().stream()
                .map(x -> new EmployeeResponse(
                        x.getId(),
                        x.getName(),
                        x.getEmail())
                ).collect(Collectors.toList());
    }
}
