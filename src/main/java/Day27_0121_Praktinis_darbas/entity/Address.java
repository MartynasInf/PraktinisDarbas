package Day27_0121_Praktinis_darbas.entity;

import Day27_0121_Praktinis_darbas.interfaces.Persistable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Persistable, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String city;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @ToString.Exclude
    private Project project;
}
