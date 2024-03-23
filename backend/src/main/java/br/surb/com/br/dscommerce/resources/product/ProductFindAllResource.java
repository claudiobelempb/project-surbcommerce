package br.surb.com.br.dscommerce.resources.product;

import br.surb.com.br.dscommerce.dto.ProductDTO;
import br.surb.com.br.dscommerce.services.product.ProductFindAllService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public CompletableFuture<ResponseEntity<Page<ProductDTO>>> handle(Pageable pageable) {
        return supplyAsync(() -> productFindAllService.execute(pageable)).thenApply((product) -> ResponseEntity.ok().body(product));
    }
}
