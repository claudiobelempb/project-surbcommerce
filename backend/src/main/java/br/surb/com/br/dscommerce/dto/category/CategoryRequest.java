package br.surb.com.br.dscommerce.dto.category;

import java.io.Serial;
import java.io.Serializable;

public record CategoryRequest(
        Long id,
        String name
) implements Serializable {

    @Serial
    private static final long serialVersionUID = -1992560563363202193L;
}
