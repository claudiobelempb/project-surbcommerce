package br.surb.com.br.dscommerce.services.employee;

import br.surb.com.br.dscommerce.entities.Employee;
import br.surb.com.br.dscommerce.http.response.EmployeeResponse;
import br.surb.com.br.dscommerce.mapper.EmployeeMapper;
import br.surb.com.br.dscommerce.repositories.EmployeeRepository;
import br.surb.com.br.dscommerce.shared.constants.ConstantException;
import br.surb.com.br.dscommerce.shared.exeptions.resource.ResourceNotFondExecption;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class EmployeeFindByIdService {
    private final EmployeeRepository employeeRepository;

    public EmployeeFindByIdService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    public EmployeeResponse execute(Long id) {
        Objects.requireNonNull(id);
        Employee response = employeeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFondExecption(ConstantException.ENTITY_NOT_FOUND));
        return EmployeeMapper.toResponse(response);
    }
}
