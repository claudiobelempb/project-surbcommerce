package br.surb.com.br.dscommerce.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_employee")
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = -1992693496559066115L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(){}

    public Employee(Long id, String name, String email, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employeer = (Employee) object;
        return Objects.equals(id, employeer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
