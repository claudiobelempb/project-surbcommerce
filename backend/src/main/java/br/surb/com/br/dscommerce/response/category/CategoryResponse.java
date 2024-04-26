package br.surb.com.br.dscommerce.response.category;

import java.io.Serial;
import java.io.Serializable;

public record CategoryResponse(
        Long id,
        String name
) implements Serializable {

    @Serial
    private static final long serialVersionUID = -1992560563363202193L;
}
