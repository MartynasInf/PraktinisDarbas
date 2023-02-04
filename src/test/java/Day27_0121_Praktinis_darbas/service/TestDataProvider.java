package Day27_0121_Praktinis_darbas.service;

import Day27_0121_Praktinis_darbas.entity.Address;
import Day27_0121_Praktinis_darbas.entity.Customer;
import Day27_0121_Praktinis_darbas.entity.Employee;
import Day27_0121_Praktinis_darbas.entity.Project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestDataProvider {

    public List<Customer> providesCustomersForTest(){
        List<Customer> customers = new ArrayList<>();
// Customer 1
        Customer customer1 = new Customer();
        customer1.setName("John Smith");
        customer1.setCountry("USA");

        Project project1 = new Project();
        project1.setName("Project A");
        project1.setDurationInWeeks(12);
        project1.setProjectIncome(100000);
        project1.setProjectCosts(50000);


        Employee employee1 = new Employee();
        employee1.setFirstName("Jane");
        employee1.setLastName("Doe");

        Set<Employee> employees1 = new HashSet<>();
        employees1.add(employee1);
        project1.setEmployees(employees1);

        Address address1 = new Address();
        address1.setCountry("USA");
        address1.setCity("New York");

        List<Address> addresses1 = new ArrayList<>();
        addresses1.add(address1);
        project1.setAddresses(addresses1);

        List<Project> projects1 = new ArrayList<>();
        projects1.add(project1);
        customer1.setProjects(projects1);

        customers.add(customer1);

// Customer 2
        Customer customer2 = new Customer();
        customer2.setName("Emma Watson");
        customer2.setCountry("UK");

        Project project2 = new Project();
        project2.setName("Project B");
        project2.setDurationInWeeks(20);
        project2.setProjectIncome(150000);
        project2.setProjectCosts(120000);

        Employee employee2 = new Employee();
        employee2.setFirstName("John");
        employee2.setLastName("Doe");

        Employee employee3 = new Employee();
        employee3.setLastName("Kohas");
        employee3.setFirstName("Igoris");

        Set<Employee> employees2 = new HashSet<>();
        employees2.add(employee2);
        employees2.add(employee3);
        project2.setEmployees(employees2);

        Address address2 = new Address();
        address2.setCountry("UK");
        address2.setCity("London");

        List<Address> addresses2 = new ArrayList<>();
        addresses2.add(address2);
        project2.setAddresses(addresses2);

        List<Project> projects2 = new ArrayList<>();
        projects2.add(project2);
        customer2.setProjects(projects2);

        customers.add(customer2);
        return customers;
    }
    public List<Project> providesProjectsForTests(){
        List<Customer> customerList = providesCustomersForTest();
        List<Project> projects = new ArrayList<>();
        for (Customer customer : customerList) {
            projects.addAll(customer.getProjects());
        }
        return projects;
    }
}
