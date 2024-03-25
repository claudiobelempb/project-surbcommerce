package br.surb.com.br.dscommerce.services.product;

import br.surb.com.br.dscommerce.repositories.ProductRepository;
import br.surb.com.br.dscommerce.shared.constants.ConstantException;
import br.surb.com.br.dscommerce.shared.exeptions.resource.ResourceNotFondExecption;
import br.surb.com.br.dscommerce.shared.exeptions.service.ServiceDataIntegrityViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductDeleteService {
    private final ProductRepository productRepository;

    public ProductDeleteService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void execute(Long productId){

        if(!productRepository.existsById(productId)) throw new ResourceNotFondExecption(ConstantException.ENTITY_NOT_FOUND);

        try {
            productRepository.deleteById(productId);
        }catch (DataIntegrityViolationException e){
            throw new ServiceDataIntegrityViolationException(ConstantException.DATA_INTEGRITY_VIOLATION);
        }

    }
}
