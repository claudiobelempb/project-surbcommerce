package br.surb.com.br.dscommerce.repositories;

import br.surb.com.br.dscommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
