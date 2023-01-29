package Day26_0114.Homework.entity;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private Integer price;
    private Integer houseArea;
    private Integer plotArea;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @ToString.Exclude
    private Owner owner;
}
