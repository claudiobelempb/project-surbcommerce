package br.surb.com.br.dscommerce.services.department;

import br.surb.com.br.dscommerce.entities.Department;
import br.surb.com.br.dscommerce.http.response.DepartmentResponse;
import br.surb.com.br.dscommerce.mapper.DepartmentMapper;
import br.surb.com.br.dscommerce.repositories.DepartmentRepository;
import br.surb.com.br.dscommerce.shared.constants.ConstantException;
import br.surb.com.br.dscommerce.shared.exeptions.resource.ResourceNotFondExecption;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class DepartmentFindByIdCustomService {
    private final DepartmentRepository departmentRepository;

    public DepartmentFindByIdCustomService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional(readOnly = true)
    public DepartmentResponse execute(Long id) {
        Objects.requireNonNull(id);
        Department response = departmentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFondExecption(ConstantException.ENTITY_NOT_FOUND));
        return DepartmentMapper.toResponse(response);
    }
}
