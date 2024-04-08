package br.surb.com.br.dscommerce.resources.employees;

import br.surb.com.br.dscommerce.http.response.EmployeeResponse;
import br.surb.com.br.dscommerce.services.employee.EmployeeFindByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/v1/employees")
public class EmployeeFindByIdResource {
    private final EmployeeFindByIdService employeeFindByIdService;

    public EmployeeFindByIdResource(EmployeeFindByIdService employeeFindByIdService) {
        this.employeeFindByIdService = employeeFindByIdService;
    }

    @GetMapping(value = "/{id}")
    public CompletableFuture<ResponseEntity<EmployeeResponse>> handle(@PathVariable Long id) {
        return supplyAsync(() -> employeeFindByIdService.execute(id)).thenApply((response) -> ResponseEntity.ok().body(response));
    }
}
