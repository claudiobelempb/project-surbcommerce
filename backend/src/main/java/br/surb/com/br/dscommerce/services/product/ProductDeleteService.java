package br.surb.com.br.dscommerce.services.product;

import br.surb.com.br.dscommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductDeleteService {
    private final ProductRepository productRepository;

    public ProductDeleteService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void execute(Long productId){
        productRepository.deleteById(productId);
    }
}
