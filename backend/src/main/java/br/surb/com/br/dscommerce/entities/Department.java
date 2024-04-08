package br.surb.com.br.dscommerce.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_department")
public class Department implements Serializable {

    @Serial
    private static final long serialVersionUID = 5890566827882159118L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "department")
    List<Employee> employees = new ArrayList<>();

    public Department() {
    }

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Department that = (Department) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
