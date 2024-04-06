package br.surb.com.br.dscommerce.services.product;

import br.surb.com.br.dscommerce.dto.product.ProductDTO;
import br.surb.com.br.dscommerce.entities.Product;
import br.surb.com.br.dscommerce.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductFindAllService {
    private final ProductRepository productRepository;

    public ProductFindAllService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @Transactional(readOnly = true)
//    public List<ProductDTO> execute(){
//        List<Product> result = productRepository.findAll();
//        return result.stream().map(product -> new ProductDTO(product)).collect(Collectors.toList());
//    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> execute(Pageable pageable) {
        Page<Product> result = productRepository.findAll(pageable);
        return result.map(entity -> new ProductDTO(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getImgUrl()));
    }
}
