package br.surb.com.br.dscommerce.response;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public record PaymentOrderDTO(
        Long id,
        Instant moment,
        Long orderId
) implements Serializable {

    @Serial
    private static final long serialVersionUID = -9127043508216003092L;
}
