package br.surb.com.br.dscommerce.services.product;

import br.surb.com.br.dscommerce.dto.ProductDTO;
import br.surb.com.br.dscommerce.entities.Product;
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
    public ProductDTO execute(ProductDTO dto) {
        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        entity = productRepository.save(entity);
        return new ProductDTO(entity);
    }

    private void copyDtoToEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
    }
}
