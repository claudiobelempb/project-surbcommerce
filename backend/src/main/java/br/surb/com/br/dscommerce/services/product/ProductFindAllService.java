package br.surb.com.br.dscommerce.services.product;

import br.surb.com.br.dscommerce.entities.Product;
import br.surb.com.br.dscommerce.mapper.ProductMapper;
import br.surb.com.br.dscommerce.repositories.ProductRepository;
import br.surb.com.br.dscommerce.response.category.CategoryResponse;
import br.surb.com.br.dscommerce.response.product.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

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
    public Page<ProductResponse> execute(String name, Pageable pageable) {
        Page<Product> products = productRepository.searchProductsCategories(name, pageable);
//        productRepository.search2ProductsCategories(name, products.stream().collect(Collectors.toList()));
        return products.map(product -> ProductMapper.toResponse(product));
    }
}
