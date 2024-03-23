package br.surb.com.br.dscommerce.dto;

import br.surb.com.br.dscommerce.entities.Product;
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
public class ProductDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 2802329782809544743L;
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
//    private final Set<CategoryDTO> categories = new HashSet<>();
//    private final Set<OrderItem> items = new HashSet<>();

    public ProductDTO(Product product){
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
    }
}
