package br.surb.com.br.dscommerce.response.product;

import br.surb.com.br.dscommerce.response.category.CategoryResponse;
import br.surb.com.br.dscommerce.shared.constants.ConstantValidator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

public record ProductCreateDTO(
        Long id,
        @Size(min = 5, max = 60, message = ConstantValidator.REQUIRED_SIZE_MESSAGE)
        @NotBlank(message = ConstantValidator.REQUIRED_FIELD)
        String name,
        @Size(min = 5, message = ConstantValidator.REQUIRED_SIZE_MIN)
        @NotBlank(message = ConstantValidator.REQUIRED_FIELD)
        String description,
        @Positive(message = ConstantValidator.REQUIRED_PRICE_POSITIVO)
        Double price,
        String imgUrl,
        Set<CategoryResponse> categories
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 2802329782809544743L;

//    private final Set<CategoryDTO> categories = new HashSet<>();
//    private final Set<OrderItem> items = new HashSet<>();

}
