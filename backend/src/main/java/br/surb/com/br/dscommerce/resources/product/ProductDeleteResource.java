package br.surb.com.br.dscommerce.resources.product;

import br.surb.com.br.dscommerce.services.product.ProductDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.runAsync;

@RestController
@RequestMapping(value = "/v1/products")
public class ProductDeleteResource {
    private final ProductDeleteService productDeleteService;

    public ProductDeleteResource(ProductDeleteService productDeleteService) {
        this.productDeleteService = productDeleteService;
    }

    @DeleteMapping(value = "/{productId}")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable Long productId) {
        return runAsync(() -> productDeleteService.execute(productId))
                .thenApply((__) -> ResponseEntity.noContent().build());
    }
}
