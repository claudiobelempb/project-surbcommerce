package br.surb.com.br.dscommerce.resources.order;

import br.surb.com.br.dscommerce.dto.OrderDTO;
import br.surb.com.br.dscommerce.services.order.OrderCreateService;
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
@RequestMapping(value = "/v1/orders")
public class OrderCreateResource {

    private final OrderCreateService orderCreateService;

    public OrderCreateResource(OrderCreateService orderCreateService) {
        this.orderCreateService = orderCreateService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<OrderDTO>> handle(@Valid @RequestBody OrderDTO dto) {
        OrderDTO obj = orderCreateService.execute(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{orderId}").buildAndExpand(obj.id()).toUri();
        return supplyAsync(() -> obj).thenApply((__) -> ResponseEntity.created(uri).body(obj));
    }
}
