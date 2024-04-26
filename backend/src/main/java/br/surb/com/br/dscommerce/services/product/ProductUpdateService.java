package br.surb.com.br.dscommerce.services.product;

import br.surb.com.br.dscommerce.response.product.ProductCustomRequest;
import br.surb.com.br.dscommerce.response.product.ProductCustomResponse;
import br.surb.com.br.dscommerce.entities.Category;
import br.surb.com.br.dscommerce.entities.Product;
import br.surb.com.br.dscommerce.mapper.ProductMapper;
import br.surb.com.br.dscommerce.repositories.ProductRepository;
import br.surb.com.br.dscommerce.shared.constants.ConstantException;
import br.surb.com.br.dscommerce.shared.exeptions.resource.ResourceNotFondExecption;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductUpdateService {
    private final ProductRepository productRepository;

    public ProductUpdateService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductCustomResponse execute(Long id, @Valid ProductCustomRequest request) {
        if (!productRepository.existsById(id)) throw new ResourceNotFondExecption(ConstantException.ENTITY_NOT_FOUND);

        Objects.requireNonNull(id);
        Product response = Product.builder()
                .id(productRepository.getReferenceById(id).getId())
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .imgUrl(request.imgUrl())
                .categories(request.categories().stream().map(resp -> Category.builder().id(resp.id()).name(resp.name()).build()).collect(Collectors.toSet()))
                .build();
//            response = ProductMapper.toCustomRequest(request);
        response = productRepository.save(response);
        return ProductMapper.toCustomResponse(response);

    }
}
