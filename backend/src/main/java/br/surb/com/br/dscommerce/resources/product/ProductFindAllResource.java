package br.surb.com.br.dscommerce.resources.product;

import br.surb.com.br.dscommerce.response.product.ProductDTO;
import br.surb.com.br.dscommerce.response.product.ProductResponse;
import br.surb.com.br.dscommerce.services.product.ProductFindAllService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/v1/products")
public class ProductFindAllResource {

    private final ProductFindAllService productFindAllService;

    public ProductFindAllResource(ProductFindAllService productFindAllService) {
        this.productFindAllService = productFindAllService;
    }

    //    @GetMapping
    //    public CompletableFuture<ResponseEntity<List<ProductDTO>>> handle() {
    //        return supplyAsync(() -> productFindAllService.execute()).thenApply((r) -> ResponseEntity.ok().body(r));
    //    }

    @GetMapping
    public CompletableFuture<ResponseEntity<Page<ProductResponse>>> handle(
            @RequestParam(name = "name", defaultValue = "") String name,
            Pageable pageable
    ) {
        return supplyAsync(() -> productFindAllService.execute(name, pageable)).thenApply((product) -> ResponseEntity.ok().body(product));
    }
}
