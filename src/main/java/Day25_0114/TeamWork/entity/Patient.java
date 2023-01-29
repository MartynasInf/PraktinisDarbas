package Day25_0114.TeamWork.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // traktuos klase kaip duomenu bazes lentele
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id //sukurs pirmini rakta
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    private String name;
    private String email;
    private Integer age;
    private String city;
}
