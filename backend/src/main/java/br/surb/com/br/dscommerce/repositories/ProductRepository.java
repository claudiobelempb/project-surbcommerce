package br.surb.com.br.dscommerce.repositories;

import br.surb.com.br.dscommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE UPPER(p.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Product> searchByName(String name, Pageable pageable);

    @Query("SELECT p FROM Product p JOIN FETCH p.categories WHERE UPPER(p.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Product> searchProductsCategories(String name, Pageable pageable);

//    @Query("SELECT p FROM Product p JOIN FETCH p.categories WHERE p IN :products")
//    List<Product> search2ProductsCategories(List<Product> products);
}
