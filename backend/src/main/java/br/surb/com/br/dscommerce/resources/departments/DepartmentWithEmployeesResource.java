package br.surb.com.br.dscommerce.resources.departments;

import br.surb.com.br.dscommerce.http.response.DepartmentResponse;
import br.surb.com.br.dscommerce.http.response.EmployeeDepartmentResponse;
import br.surb.com.br.dscommerce.http.response.EmployeeResponse;
import br.surb.com.br.dscommerce.services.department.DepartmentWithEmployeesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/v1/departments")
public class DepartmentWithEmployeesResource {
    private final DepartmentWithEmployeesService departmentWithEmployeeService;

    public DepartmentWithEmployeesResource(DepartmentWithEmployeesService departmentWithEmployeeService) {
        this.departmentWithEmployeeService = departmentWithEmployeeService;
    }

    @GetMapping(value = "/{id}/employees")
    public CompletableFuture<ResponseEntity<List<EmployeeResponse>>> handle(@PathVariable Long id) {
        return supplyAsync(() -> departmentWithEmployeeService.execute(id)).thenApply((response) -> ResponseEntity.ok().body(response));
    }
}
