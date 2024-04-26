package br.surb.com.br.dscommerce.resources.product;

import br.surb.com.br.dscommerce.response.product.ProductCreateRequest;
import br.surb.com.br.dscommerce.response.product.ProductCreateResponse;
import br.surb.com.br.dscommerce.services.product.ProductCreateService;
import jakarta.validation.Valid;
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
    public CompletableFuture<ResponseEntity<ProductCreateResponse>> handle(@Valid @RequestBody ProductCreateRequest request) {
        ProductCreateResponse response = productCreateService.execute(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.id()).toUri();
        return supplyAsync(() -> response).thenApply((__) -> ResponseEntity.created(uri).body(response));
    }
}
