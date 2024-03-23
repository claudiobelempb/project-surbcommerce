package br.surb.com.br.dscommerce.services.product;

import br.surb.com.br.dscommerce.dto.ProductDTO;
import br.surb.com.br.dscommerce.entities.Product;
import br.surb.com.br.dscommerce.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
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
                .orElseThrow(() -> new EntityNotFoundException("Entity not found" + productId));
        return new ProductDTO(product);
    }
}
