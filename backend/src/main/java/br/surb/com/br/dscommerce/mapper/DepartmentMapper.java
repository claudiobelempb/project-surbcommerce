package br.surb.com.br.dscommerce.mapper;

import br.surb.com.br.dscommerce.entities.Department;
import br.surb.com.br.dscommerce.http.request.DepartmentCustomRequest;
import br.surb.com.br.dscommerce.http.request.DepartmentRequest;
import br.surb.com.br.dscommerce.http.response.DepartmentCustomResponse;
import br.surb.com.br.dscommerce.http.response.DepartmentResponse;

public final class DepartmentMapper {
    public static Department toRequest(DepartmentRequest request) {
        Department response = new Department();

        response.setId(request.id());
        response.setName(request.name());

        return response;
    }

    public static DepartmentResponse toResponse(Department entity) {
        return new DepartmentResponse(
                entity.getId(),
                entity.getName()
        );
    }

    public static Department toCustomRequest(DepartmentCustomRequest request) {
        Department response = new Department();

        response.setId(request.id());
        response.setName(request.name());

        return response;
    }

    public static DepartmentCustomResponse toCustomResponse(Department entity) {
        return new DepartmentCustomResponse(
                entity.getId(),
                entity.getName(),
                entity.getEmployees()
        );
    }
}
