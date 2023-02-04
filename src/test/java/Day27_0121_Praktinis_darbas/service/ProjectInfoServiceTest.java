package Day27_0121_Praktinis_darbas.service;


import Day27_0121_Praktinis_darbas.entity.Project;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectInfoServiceTest {

    TestDataProvider testDataProvider = new TestDataProvider();
    ProjectInfoService projectInfoService = new ProjectInfoService();
    List<Project> testProjectsList = testDataProvider.providesProjectsListForTests();
    List<Project> resultList;

    @Test
    void shouldFindWithMostEmployees() {
        resultList = projectInfoService.findWithMostEmployees(testProjectsList);
        assertEquals(1, resultList.size());
        assertEquals(2, resultList.get(0).getEmployees().size());
    }

    @Test
    void shouldFindWithMostIncome() {

    }
}