package Day26_0114.example_1;

import Day26_0114.example_1.entity.Company;
import Day26_0114.example_1.entity.Employee1;
import Day26_0114.example_1.util.HibernateUtility2;
import org.hibernate.Session;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtility2.getSessionFactory().openSession();

        session.beginTransaction();
        Company tesla = new Company();
        tesla.setName("Tesla Corp");


        Employee1 elon = new Employee1();
        elon.setName("Elon Musk");
        elon.setCompany(tesla);

        Employee1 vitalijus = new Employee1();
        vitalijus.setName("Vitalijus");
        vitalijus.setCompany(tesla);

        tesla.setEmployee1s(Arrays.asList(elon, vitalijus));

        session.save(tesla);
        session.getTransaction().commit();

        Company company = session.find(Company.class, 1L);
        System.out.println(company);

        session.beginTransaction();
        session.delete(company);
        session.getTransaction().commit();

    }
}
