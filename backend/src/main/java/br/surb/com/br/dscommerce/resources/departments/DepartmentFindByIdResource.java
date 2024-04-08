package br.surb.com.br.dscommerce.resources.departments;

import br.surb.com.br.dscommerce.http.response.DepartmentResponse;
import br.surb.com.br.dscommerce.services.department.DepartmentFindByIdCustomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/v1/departments")
public class DepartmentFindByIdResource {
    private final DepartmentFindByIdCustomService departmentFindByIdCustomService;

    public DepartmentFindByIdResource(DepartmentFindByIdCustomService departmentFindByIdCustomService) {
        this.departmentFindByIdCustomService = departmentFindByIdCustomService;
    }

    @GetMapping(value = "/{id}")
    public CompletableFuture<ResponseEntity<DepartmentResponse>> handle(@PathVariable Long id) {
        return supplyAsync(() -> departmentFindByIdCustomService.execute(id)).thenApply((response) -> ResponseEntity.ok().body(response));
    }
}
