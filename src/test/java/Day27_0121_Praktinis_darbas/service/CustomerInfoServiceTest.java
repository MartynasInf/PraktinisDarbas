package Day27_0121_Praktinis_darbas.service;

import Day27_0121_Praktinis_darbas.entity.Address;
import Day27_0121_Praktinis_darbas.entity.Customer;
import Day27_0121_Praktinis_darbas.entity.Employee;
import Day27_0121_Praktinis_darbas.entity.Project;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CustomerInfoServiceTest {

    TestDataProvider testDataProvider = new TestDataProvider();
    CustomerInfoService customerInfoService = new CustomerInfoService();
    List<Customer> testCustomerList = testDataProvider.providesDataForTest();
    List<Customer> resultList;

    @Test
    void findWithMostProjects() {
        resultList = customerInfoService.findWithMostProjects(testCustomerList);
        assertEquals(2, resultList.size());
        assertEquals(1, resultList.get(0).getProjects().size());
    }


    @Test
    void testFindWithMostEmployees() {
        resultList = customerInfoService.findWithMostEmployees(testCustomerList);
        assertEquals(1, resultList.size());
        assertEquals(2, resultList.get(0).getProjects().stream()
                .mapToInt(project -> project.getEmployees().size())
                .sum());
    }

    @Test
    void findWithMostIncome() {
        resultList = customerInfoService.findWithMostIncome(testCustomerList);
        assertEquals(1, resultList.size());
        assertEquals("Emma Watson", resultList.get(0).getName());
        assertEquals(150000, resultList.get(0).getProjects().stream()
                .mapToInt(Project::getProjectIncome)
                .sum());
    }

    @Test
    void findWithMostCosts() {
        resultList = customerInfoService.findWithMostCosts(testCustomerList);
        assertEquals(1, resultList.size());
        assertEquals("Project B", resultList.get(0).getProjects().get(0).getName());
        assertEquals(120000, resultList.get(0).getProjects().stream().mapToInt(Project::getProjectCosts).sum());
    }

    @Test
    void findMostProfitable() {
        resultList = customerInfoService.findMostProfitable(testCustomerList);
        assertEquals(1, resultList.size());
        assertEquals(50000, resultList.get(0).getProjects().stream()
                .mapToInt(project -> project.getProjectIncome() - project.getProjectCosts())
                .sum());
    }

    @Test
    void findLeastProfitable() {
        resultList = customerInfoService.findLeastProfitable(testCustomerList);
        assertEquals(1, resultList.size());
        assertEquals(30000, resultList.get(0).getProjects().stream()
                .mapToInt(project -> project.getProjectIncome() - project.getProjectCosts())
                .sum());
    }
}