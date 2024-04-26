package br.surb.com.br.dscommerce.services.employee;

import br.surb.com.br.dscommerce.entities.Employee;
import br.surb.com.br.dscommerce.http.response.DepartmentResponse;
import br.surb.com.br.dscommerce.http.response.EmployeeDepartmentResponse;
import br.surb.com.br.dscommerce.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeWithDepartmentFindAllService {
    private final EmployeeRepository employeeRepository;

    public EmployeeWithDepartmentFindAllService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    public List<EmployeeDepartmentResponse> execute() {
        List<Employee> result = employeeRepository.findEmployeesWithDepartments();
        return result.stream().map(x -> new EmployeeDepartmentResponse(x.getId(), x.getName(), x.getEmail(), new DepartmentResponse(x.getDepartment().getId(), x.getDepartment().getName()))).collect(Collectors.toList());
    }
}
