package Day25_0114.TeamWork.repository;

import Day25_0114.TeamWork.entity.Patient;
import Day25_0114.TeamWork.service.SaveToJson;
import Day25_0114.TeamWork.utilities.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PatientRepo {

    SaveToJson saveToJson = new SaveToJson();

    public void save(Patient patient) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(patient);
        transaction.commit();
        session.close();
        saveToJson.listToJson(findAll());
    }

    public List<Patient> findAll() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        return session.createQuery("FROM Patient", Patient.class).list();
    }

    public List<Patient> findByName(String name) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        return session.createQuery(String.format("FROM Patient WHERE name='%s'", name), Patient.class).list();
    }

    public void updatePatient(Patient patient, int id) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Patient updatePatient = session.get(Patient.class, id);
        updatePatient.setName(patient.getName());
        updatePatient.setEmail(patient.getEmail());
        updatePatient.setAge(patient.getAge());
        updatePatient.setCity(patient.getCity());
        session.update(updatePatient);
        transaction.commit();
        session.close();
        saveToJson.listToJson(findAll());
    }

    public void delete(int id) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Patient deletePatient = session.get(Patient.class, id);
        session.delete(deletePatient);
        transaction.commit();
        session.close();
        saveToJson.listToJson(findAll());
    }

    public void saveAll(List<Patient> givenList) {
        for (Patient patient : givenList) {
            save(patient);
        }
    }
}
