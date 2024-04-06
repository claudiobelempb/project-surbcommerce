package br.surb.com.br.dscommerce.services.product;

import br.surb.com.br.dscommerce.dto.product.ProductCreateRequest;
import br.surb.com.br.dscommerce.dto.product.ProductCreateResponse;
import br.surb.com.br.dscommerce.entities.Product;
import br.surb.com.br.dscommerce.mapper.ProductMapper;
import br.surb.com.br.dscommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductCreateService {
    private final ProductRepository productRepository;

    public ProductCreateService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductCreateResponse execute(ProductCreateRequest request) {
        Product response = ProductMapper.toCreateRequest(request);
        response = productRepository.save(response);
        return ProductMapper.toCreateResponse(response);
    }
}
