package Day27_0121_Praktinis_darbas.service;

import Day27_0121_Praktinis_darbas.entity.Project;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class ProjectInfoService {

    public List<Project> findWithMostEmployees(List<Project> projects){
        OptionalInt biggestEmployeeCount = projects.stream()
                .mapToInt(project -> project.getEmployees().size())
                .max();
        return projects.stream()
                .filter(project -> project.getEmployees().size() == biggestEmployeeCount.getAsInt())
                .collect(Collectors.toList());
    }
    public List<Project> findWithMostIncome(List<Project> projects){
        OptionalInt biggestIncome = projects.stream()
                .mapToInt(Project::getProjectIncome)
                .max();
        return projects.stream()
                .filter(project -> project.getProjectIncome() == biggestIncome.getAsInt())
                .collect(Collectors.toList());
    }
    public List<Project> findWithTheBiggestCosts(List<Project> projects){
        OptionalInt biggestCosts = projects.stream()
                .mapToInt(Project::getProjectCosts)
                .max();
        return projects.stream()
                .filter(project -> project.getProjectCosts() == biggestCosts.getAsInt())
                .collect(Collectors.toList());
    }

    public List<Project> findWithBiggestGeneratedEmployeeValue(List<Project> projects){
        OptionalInt biggestEmployeeAverage = projects.stream()
                .mapToInt(project -> project.getProjectIncome()/project.getEmployees().size())
                .max();
        return projects.stream()
                .filter(project -> project.getProjectIncome()/project.getEmployees().size() == biggestEmployeeAverage.getAsInt())
                .collect(Collectors.toList());
    }
    public List<Project> findWithMostProfit(List<Project> projects){
        OptionalInt biggestProfit = projects.stream()
                .mapToInt(project -> project.getProjectIncome() - project.getProjectCosts())
                .max();
        return projects.stream()
                .filter(project -> project.getProjectIncome() - project.getProjectCosts() == biggestProfit.getAsInt())
                .collect(Collectors.toList());
    }
    public List<Project> findLongest(List<Project> projects){
        OptionalInt longest = projects.stream()
                .mapToInt(Project::getDurationInWeeks)
                .max();
        return projects.stream()
                .filter(project -> project.getDurationInWeeks() == longest.getAsInt())
                .collect(Collectors.toList());
    }
    public List<Project> findLShortest(List<Project> projects){
        OptionalInt shortest = projects.stream()
                .mapToInt(Project::getDurationInWeeks)
                .min();
        return projects.stream()
                .filter(project -> project.getDurationInWeeks() == shortest.getAsInt())
                .collect(Collectors.toList());
    }
}
