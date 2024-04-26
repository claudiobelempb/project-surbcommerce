package br.surb.com.br.dscommerce.resources.payment;

import br.surb.com.br.dscommerce.response.PaymentDTO;
import br.surb.com.br.dscommerce.services.payment.PaymentCreateService;
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
@RequestMapping(value = "/v1/payments")
public class PaymentCreateResource {

    private final PaymentCreateService paymentCreateService;

    public PaymentCreateResource(PaymentCreateService paymentCreateService) {
        this.paymentCreateService = paymentCreateService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<PaymentDTO>> handle(@Valid @RequestBody PaymentDTO dto) {
        PaymentDTO obj = paymentCreateService.execute(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{paymentId}").buildAndExpand(obj.id()).toUri();
        return supplyAsync(() -> obj).thenApply((__) -> ResponseEntity.created(uri).body(obj));
    }
}
