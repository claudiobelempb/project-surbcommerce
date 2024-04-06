package br.surb.com.br.dscommerce.resources.product;

import br.surb.com.br.dscommerce.dto.product.ProductCustomRequest;
import br.surb.com.br.dscommerce.dto.product.ProductCustomResponse;
import br.surb.com.br.dscommerce.dto.product.ProductDTO;
import br.surb.com.br.dscommerce.services.product.ProductUpdateService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/v1/products")
public class ProductUpdateResource {
    private final ProductUpdateService productUpdateService;

    public ProductUpdateResource(ProductUpdateService productUpdateService) {
        this.productUpdateService = productUpdateService;
    }

    @PutMapping(value = "/{productId}")
    public CompletableFuture<ResponseEntity<ProductCustomResponse>> handle(@PathVariable Long productId, @Valid @RequestBody ProductCustomRequest request) {
        return supplyAsync(() -> productUpdateService.execute(productId, request)).thenApply((product) -> ResponseEntity.ok().body(product));
    }

}
