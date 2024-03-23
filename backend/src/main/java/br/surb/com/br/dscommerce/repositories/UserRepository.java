package br.surb.com.br.dscommerce.repositories;

import br.surb.com.br.dscommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
