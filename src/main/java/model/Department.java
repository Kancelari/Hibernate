package model;

import lombok.*;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int departmentId;
    @Column(name = "name")
    private String departmentName;
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    Set<Employee> employees = new HashSet<>();

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentname='" + departmentName + '\'' +
                '}';
    }
}