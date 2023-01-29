package Day25_0114.TeamWork;

import Day25_0114.TeamWork.entity.Patient;
import Day25_0114.TeamWork.repository.PatientRepo;
import Day25_0114.TeamWork.service.SaveToJson;
import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PatientRepo patientRepo = new PatientRepo();

        Patient patient1 = new Patient();
        patient1.setName("Tomas");
        patient1.setEmail("tomas@gmail.com");
        patient1.setAge(25);
        patient1.setCity("NewYork");

        Patient patient2 = new Patient();
        patient2.setName("Jurga");
        patient2.setEmail("jurga@gmail.com");
        patient2.setAge(31);
        patient2.setCity("Berlin");

        patientRepo.save(patient1);
        patientRepo.save(patient2);
        System.out.println("------Find all----");
        patientRepo.findAll().forEach(System.out::println);
        System.out.println("------Find all----");
        System.out.println("------Find by name----");
        List<Patient> listByName = patientRepo.findByName("Tomas");
        for (Patient patient : listByName) {
            System.out.println(patient);
        }
        System.out.println("------Find by name----");
        Patient patient3 = new Patient();
        patient3.setName("Jurgita");
        patient3.setEmail("jurgita@gmail.com");
        patient3.setAge(31);
        patient3.setCity("Berlin");

        //patientRepo.updatePatient(patient3, 2);

        //patientRepo.delete(2);

        Patient patient4 = new Patient();
        patient4.setName("Mindaugas");
        patient4.setEmail("mindaugas@gmail.com");
        patient4.setAge(35);
        patient4.setCity("Klaipeda");

        Patient patient5 = new Patient();
        patient5.setName("Rasa");
        patient5.setEmail("rasa@gmail.com");
        patient5.setAge(28);
        patient5.setCity("Vilnius");

        List<Patient> newList = new ArrayList<>();
        newList.add(patient4);
        newList.add(patient5);

        patientRepo.saveAll(newList);

    }
}
