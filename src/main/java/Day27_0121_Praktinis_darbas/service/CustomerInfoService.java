package Day27_0121_Praktinis_darbas.service;

import Day27_0121_Praktinis_darbas.entity.Customer;
import Day27_0121_Praktinis_darbas.entity.Project;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class CustomerInfoService {

    /**
     * Mothod to find customers with most projects
     * @param customers - list of customers to check
     * @return - list of customers
     */
    public List<Customer> findWithMostProjects(List<Customer> customers) {
        OptionalInt biggestProjectsCount = customers.stream()
                .mapToInt(customer -> customer.getProjects().size())
                .max();
        return customers.stream()
                .filter(customer -> customer.getProjects().size() == biggestProjectsCount.getAsInt())
                .collect(Collectors.toList());
    }

    /**
     * Method to find customers where works most employees
     * @param customers - list of customers to check
     * @return - list of customers
     */
    public List<Customer> findWithMostEmployees(List<Customer> customers){
        int biggestEmployeeCount = customers.stream()
                .mapToInt(c -> c.getProjects().stream()
                        .mapToInt(p -> p.getEmployees().size())
                        .sum())
                .max().orElse(0);
        return customers.stream()
                .filter(c -> c.getProjects().stream()
                        .mapToInt(p -> p.getEmployees().size())
                        .sum() == biggestEmployeeCount)
                .collect(Collectors.toList());
    }

    /**
     * Method to find customers with most income
     * @param customers - list of customers to check
     * @return - list of customers
     */
    public List<Customer> findWithMostIncome(List<Customer> customers){
        int biggestIncome = customers.stream()
                .mapToInt(customer -> customer.getProjects().stream()
                        .mapToInt(Project::getProjectIncome)
                        .sum())
                .max().orElse(0);
        return customers.stream()
                .filter(customer -> customer.getProjects().stream()
                        .mapToInt(Project::getProjectIncome)
                        .sum() == biggestIncome)
                .collect(Collectors.toList());
    }

    /**
     * Method to find customers with most costs
     * @param customers - list of customers to check
     * @return - list of customers
     */
    public List<Customer> findWithMostCosts(List<Customer> customers){
        int mostCosts = customers.stream()
                .mapToInt(customer -> customer.getProjects().stream()
                        .mapToInt(Project::getProjectCosts)
                        .sum())
                .max().orElse(0);
        return customers.stream()
                .filter(customer -> customer.getProjects().stream()
                        .mapToInt(Project::getProjectCosts)
                        .sum() == mostCosts)
                .collect(Collectors.toList());
    }

    /**
     * Method to find customers generating most profit
     * @param customers - list of customers to check
     * @return - list of customers
     */
    public List<Customer> findMostProfitable(List<Customer> customers){
        int mostProfit = customers.stream()
                .mapToInt(customer -> customer.getProjects().stream()
                        .mapToInt(project -> project.getProjectIncome() - project.getProjectCosts())
                        .sum())
                .max().orElse(0);
        return customers.stream()
                .filter(customer -> customer.getProjects().stream()
                        .mapToInt(project -> project.getProjectIncome() - project.getProjectCosts())
                        .sum() == mostProfit)
                .collect(Collectors.toList());
    }

    /**
     * Method to find customers generating the least profit
     * @param customers - list of customers to check
     * @return - list of customers
     */
    public List<Customer> findLeastProfitable(List<Customer> customers){
        int minimumProfit = customers.stream()
                .mapToInt(customer -> customer.getProjects().stream()
                        .mapToInt(project -> project.getProjectIncome() - project.getProjectCosts())
                        .sum())
                .min().orElse(0);
        return customers.stream()
                .filter(customer -> customer.getProjects().stream()
                        .mapToInt(project -> project.getProjectIncome() - project.getProjectCosts())
                        .sum() == minimumProfit)
                .collect(Collectors.toList());
    }
}
