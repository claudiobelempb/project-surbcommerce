package br.surb.com.br.dscommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -1992560563363202193L;
    private Long id;
    private String name;
//    private final Set<ProductDTO> products = new HashSet<>();
}
