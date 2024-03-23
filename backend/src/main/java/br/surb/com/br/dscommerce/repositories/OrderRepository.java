package br.surb.com.br.dscommerce.repositories;

import br.surb.com.br.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
