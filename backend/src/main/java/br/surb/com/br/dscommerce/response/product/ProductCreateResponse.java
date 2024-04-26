package br.surb.com.br.dscommerce.response.product;

import br.surb.com.br.dscommerce.response.category.CategoryResponse;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

public record ProductCreateResponse(
        Long id,
        String name,
        String description,
        Double price,
        String imgUrl,
        Set<CategoryResponse> categories
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 2802329782809544743L;

//    private final Set<CategoryDTO> categories = new HashSet<>();
//    private final Set<OrderItem> items = new HashSet<>();

}
