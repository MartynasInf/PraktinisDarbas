package Day25_0114.ClassWork.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity // traktuos klase kaip duomenu bazes lentele
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id //sukurs pirmini rakta
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;
    private String name;
    private BigDecimal budget;

}
