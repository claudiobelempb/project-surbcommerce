package br.surb.com.br.dscommerce.resources.product;

import br.surb.com.br.dscommerce.dto.ProductDTO;
import br.surb.com.br.dscommerce.services.product.ProductUpdateService;
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
    public CompletableFuture<ResponseEntity<ProductDTO>> handle(@PathVariable Long productId, @RequestBody ProductDTO dto) {
        return supplyAsync(() -> productUpdateService.execute(productId, dto)).thenApply((product) -> ResponseEntity.ok().body(product));
    }

}
