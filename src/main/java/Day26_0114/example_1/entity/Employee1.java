package Day26_0114.example_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne //reiskia daug arbuotoju i viena kompanija
    @JoinColumn(name = "company_id") //nurodome koks bus stulpelio pav. nurodantis kompanija
    @ToString.Exclude
    private Company company;
}
