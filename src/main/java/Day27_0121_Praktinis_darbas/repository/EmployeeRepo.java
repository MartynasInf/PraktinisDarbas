package Day27_0121_Praktinis_darbas.repository;

import Day27_0121_Praktinis_darbas.entity.Employee;

import java.util.List;

import static Day27_0121_Praktinis_darbas.utility.HibernateUtilityPW.getSessionFactory;

public class EmployeeRepo extends BaseRepo<Employee> {

    @Override
    public List<Employee> findAll() {
        session = getSessionFactory().openSession();
        List<Employee> employees = session.createQuery("FROM Employee", Employee.class).list();
        return employees;
    }

    @Override
    public void saveList(List<Employee> givenList) {
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
        givenList.forEach(employee -> session.save(employee));
        transaction.commit();
        session.close();
    }
}
