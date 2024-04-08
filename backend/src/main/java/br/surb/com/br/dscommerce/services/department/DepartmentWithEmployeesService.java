package br.surb.com.br.dscommerce.services.department;

import br.surb.com.br.dscommerce.entities.Department;
import br.surb.com.br.dscommerce.entities.Employee;
import br.surb.com.br.dscommerce.http.response.EmployeeDepartmentResponse;
import br.surb.com.br.dscommerce.repositories.DepartmentRepository;
import br.surb.com.br.dscommerce.shared.constants.ConstantException;
import br.surb.com.br.dscommerce.shared.exeptions.resource.ResourceNotFondExecption;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DepartmentWithEmployeesService {
    private final DepartmentRepository departmentRepository;

    public DepartmentWithEmployeesService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional(readOnly = true)
    public List<EmployeeDepartmentResponse> execute(Long id) {
        Objects.requireNonNull(id);
        Department response = departmentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFondExecption(ConstantException.ENTITY_NOT_FOUND));
        List<Employee> employees = response.getEmployees();

        return employees.stream().map(x -> new EmployeeDepartmentResponse(x.getId(), x.getName(), x.getEmail())).collect(Collectors.toList());
    }
}
