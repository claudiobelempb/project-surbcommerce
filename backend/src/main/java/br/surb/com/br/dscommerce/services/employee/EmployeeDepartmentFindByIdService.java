package br.surb.com.br.dscommerce.services.employee;

import br.surb.com.br.dscommerce.entities.Employee;
import br.surb.com.br.dscommerce.http.response.DepartmentResponse;
import br.surb.com.br.dscommerce.http.response.EmployeeDepartmentResponse;
import br.surb.com.br.dscommerce.repositories.EmployeeRepository;
import br.surb.com.br.dscommerce.shared.constants.ConstantException;
import br.surb.com.br.dscommerce.shared.exeptions.resource.ResourceNotFondExecption;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class EmployeeDepartmentFindByIdService {
    private final EmployeeRepository employeeRepository;

    public EmployeeDepartmentFindByIdService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    public EmployeeDepartmentResponse execute(Long id) {
        Objects.requireNonNull(id);
        Employee response = employeeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFondExecption(ConstantException.ENTITY_NOT_FOUND));
        return new EmployeeDepartmentResponse(
                response.getId(),
                response.getName(),
                response.getEmail(),
                new DepartmentResponse(response.getDepartment().getId(), response.getDepartment().getName())
        );
    }
}
