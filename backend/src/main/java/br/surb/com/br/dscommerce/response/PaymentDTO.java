package br.surb.com.br.dscommerce.response;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public record PaymentDTO(
        Long id,
        Instant moment,
        Long orderId
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 4067303438813321703L;
}
