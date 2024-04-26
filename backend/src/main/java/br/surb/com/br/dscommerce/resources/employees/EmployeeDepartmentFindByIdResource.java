package br.surb.com.br.dscommerce.resources.employees;

import br.surb.com.br.dscommerce.http.response.EmployeeDepartmentResponse;
import br.surb.com.br.dscommerce.services.employee.EmployeeDepartmentFindByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/v1/employees")
public class EmployeeDepartmentFindByIdResource {
    private final EmployeeDepartmentFindByIdService employeeFindByIdCustomService;

    public EmployeeDepartmentFindByIdResource(EmployeeDepartmentFindByIdService employeeFindByIdCustomService) {
        this.employeeFindByIdCustomService = employeeFindByIdCustomService;
    }


    @GetMapping(value = "/{id}/department")
    public CompletableFuture<ResponseEntity<EmployeeDepartmentResponse>> handle(@PathVariable Long id) {
        return supplyAsync(() -> employeeFindByIdCustomService.execute(id)).thenApply((response) -> ResponseEntity.ok().body(response));
    }
}
