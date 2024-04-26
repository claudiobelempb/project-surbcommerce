package br.surb.com.br.dscommerce.response;

import br.surb.com.br.dscommerce.shared.enums.OrderEnum;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public record OrderDTO(
        Long id,
        OrderEnum status,
        Instant moment,
        OrderUserDTO client
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 3234956992420328927L;

}
