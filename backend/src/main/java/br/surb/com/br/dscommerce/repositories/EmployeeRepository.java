package br.surb.com.br.dscommerce.repositories;

import br.surb.com.br.dscommerce.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT obj FROM Employee obj JOIN FETCH obj.department")
    List<Employee> findEmployeesWithDepartments();
}
