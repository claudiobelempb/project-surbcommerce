package br.surb.com.br.dscommerce.mapper;

import br.surb.com.br.dscommerce.entities.Department;
import br.surb.com.br.dscommerce.http.request.DepartmentRequest;
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

}
