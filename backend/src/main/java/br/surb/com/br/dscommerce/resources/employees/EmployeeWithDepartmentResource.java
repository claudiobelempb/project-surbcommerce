package br.surb.com.br.dscommerce.resources.employees;

import br.surb.com.br.dscommerce.http.response.EmployeeResponse;
import br.surb.com.br.dscommerce.services.employee.EmployeeWithDepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/v1/employees")
public class EmployeeWithDepartmentResource {
    private final EmployeeWithDepartmentService employeeWithDepartmentsService;

    public EmployeeWithDepartmentResource(EmployeeWithDepartmentService employeeWithDepartmentsService) {
        this.employeeWithDepartmentsService = employeeWithDepartmentsService;
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<List<EmployeeResponse>>> handle() {
        List<EmployeeResponse> entity = employeeWithDepartmentsService.execute();
        return supplyAsync(() -> entity).thenApply((response) -> ResponseEntity.ok().body(response));
    }
}
