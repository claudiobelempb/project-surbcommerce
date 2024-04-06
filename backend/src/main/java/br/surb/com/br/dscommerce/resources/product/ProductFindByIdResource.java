package br.surb.com.br.dscommerce.resources.product;

import br.surb.com.br.dscommerce.dto.product.ProductDTO;
import br.surb.com.br.dscommerce.services.product.ProductFindByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/v1/products")
public class ProductFindByIdResource {

    private final ProductFindByIdService productFindByIdService;

    public ProductFindByIdResource(ProductFindByIdService productFindByIdService) {
        this.productFindByIdService = productFindByIdService;
    }

    @GetMapping(value = "/{productId}")
    public CompletableFuture<ResponseEntity<ProductDTO>> handle(@PathVariable Long productId) {
        return supplyAsync(() -> productFindByIdService.execute(productId)).thenApply((product) -> ResponseEntity.ok().body(product));
    }
}
