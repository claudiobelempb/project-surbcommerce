package br.surb.com.br.dscommerce.services.employee;

import br.surb.com.br.dscommerce.entities.Employee;
import br.surb.com.br.dscommerce.http.response.EmployeeResponse;
import br.surb.com.br.dscommerce.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeWithDepartmentService {
    private final EmployeeRepository employeeRepository;

    public EmployeeWithDepartmentService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    public List<EmployeeResponse> execute() {
        List<Employee> employees = employeeRepository.findEmployeesWithDepartments();
        return employees.stream().map(employee -> new EmployeeResponse(employee.getId(), employee.getName(), employee.getEmail(), employee.getDepartment().getId())).collect(Collectors.toList());
    }
}
