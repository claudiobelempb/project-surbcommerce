package br.surb.com.br.dscommerce.services.product;

import br.surb.com.br.dscommerce.dto.ProductDTO;
import br.surb.com.br.dscommerce.entities.Product;
import br.surb.com.br.dscommerce.repositories.ProductRepository;
import br.surb.com.br.dscommerce.shared.constants.constantException;
import br.surb.com.br.dscommerce.shared.exeptions.resource.ResourceNotFondExecption;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class ProductFindByIdService {
    private final ProductRepository productRepository;

    public ProductFindByIdService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public ProductDTO execute(Long productId) {
        Objects.requireNonNull(productId);
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ResourceNotFondExecption(constantException.ENTITY_NOT_FOUND));
        return new ProductDTO(product);
    }
}
