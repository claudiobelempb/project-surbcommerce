package br.surb.com.br.dscommerce.repositories;

import br.surb.com.br.dscommerce.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
