package br.surb.com.br.dscommerce.resources.product;

import br.surb.com.br.dscommerce.dto.ProductDTO;
import br.surb.com.br.dscommerce.services.product.ProductCreateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/v1/products")
public class ProductCreateResource {
    private final ProductCreateService productCreateService;

    public ProductCreateResource(ProductCreateService productCreateService) {
        this.productCreateService = productCreateService;
    }

//    @PostMapping
//    public ProductDTO handle(@RequestBody  ProductDTO dto){
//        return  productCreateService.execute(dto);
//    }

    @PostMapping
    public CompletableFuture<ResponseEntity<ProductDTO>> handle(@RequestBody ProductDTO dto) {
        ProductDTO obj = productCreateService.execute(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{productId}").buildAndExpand(obj.getId()).toUri();
        return supplyAsync(() -> obj).thenApply((__) -> ResponseEntity.created(uri).body(obj));
    }
}
