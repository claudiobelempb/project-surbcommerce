package br.surb.com.br.dscommerce.resources.employees;

import br.surb.com.br.dscommerce.http.response.EmployeeDepartmentResponse;
import br.surb.com.br.dscommerce.services.employee.EmployeeWithDepartmentFindAllService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/v1/employees")
public class EmployeeWithDepartmentFindAllResource {
    private final EmployeeWithDepartmentFindAllService employeeWithDepartmentsService;

    public EmployeeWithDepartmentFindAllResource(EmployeeWithDepartmentFindAllService employeeWithDepartmentsService) {
        this.employeeWithDepartmentsService = employeeWithDepartmentsService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDepartmentResponse>> handle() {
        List<EmployeeDepartmentResponse> list = employeeWithDepartmentsService.execute();
        return ResponseEntity.ok(list);
    }
}
