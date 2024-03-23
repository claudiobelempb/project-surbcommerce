package br.surb.com.br.dscommerce.repositories;

import br.surb.com.br.dscommerce.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
