package Day27_0121_Praktinis_darbas;


import Day27_0121_Praktinis_darbas.entity.Customer;
import Day27_0121_Praktinis_darbas.repository.*;
import Day27_0121_Praktinis_darbas.service.CustomerInfoService;
import Day27_0121_Praktinis_darbas.service.DataMapperService;
import Day27_0121_Praktinis_darbas.service.JsonService;


import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        CustomerRepo customerRepo = new CustomerRepo();

        JsonService jsonService = new JsonService();
        List<Customer> customersList = jsonService.fileToList();

        DataMapperService dataMapperService = new DataMapperService();
        List<Customer> mappedList = dataMapperService.mapsListFromJson(customersList);
        customerRepo.saveList(mappedList);

        Customer newCustomer = jsonService.createCustomerFromJsonFile();
        List<Customer> singleCustomer = dataMapperService.mapsListFromJson(Collections.singletonList(newCustomer));
        customerRepo.save(singleCustomer.get(0));

        List<Customer> customersFromDB = customerRepo.findAll();
        customersFromDB.get(1).setName("Martyno");
        customerRepo.update(customersFromDB.get(1));
        customerRepo.delete(customersFromDB.get(2));


        CustomerInfoService customerInfoService = new CustomerInfoService();
        System.out.println("------Customer with most projects-----");
        customerInfoService.findWithMostProjects(customersFromDB).forEach(System.out::println);
        System.out.println("------Customer with most employees-----");
        customerInfoService.findWithMostEmployees(customersFromDB).forEach(System.out::println);
        System.out.println("------Customer with most income-----");
        customerInfoService.findWithMostIncome(customersFromDB).forEach(System.out::println);
        System.out.println("------Customer with most expenses-----");
        customerInfoService.findWithMostCosts(customersFromDB).forEach(System.out::println);
        System.out.println("------Customer with most profit-----");
        customerInfoService.findMostProfitable(customersFromDB).forEach(System.out::println);
        System.out.println("------Customer with least profit-----");
        customerInfoService.findLeastProfitable(customersFromDB).forEach(System.out::println);
    }
}
