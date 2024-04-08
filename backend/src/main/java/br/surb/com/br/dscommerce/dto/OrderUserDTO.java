package br.surb.com.br.dscommerce.dto;

import java.io.Serial;
import java.io.Serializable;

public record OrderUserDTO(
        Long id,
        String name,
        String email,
        String phone
)
        implements Serializable {

    @Serial
    private static final long serialVersionUID = 4705261904340514750L;
}
