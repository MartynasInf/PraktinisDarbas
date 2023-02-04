package Day27_0121_Praktinis_darbas.service;

import Day26_0114.TeamWork.entity.Teacher;
import Day27_0121_Praktinis_darbas.entity.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonService {

    public List<Customer> createsListFromFile() throws IOException {
        String file = "src/main/resources/DataProvider.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));
        ObjectMapper mapper = new ObjectMapper();
        List<Customer> customersFromFile = mapper.readValue(json, new TypeReference<>() {
        });
        return customersFromFile;
    }

    public Customer createsOneCustomerFromFile() throws IOException {
        String file = "src/main/resources/ImportNewCustomer.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));
        List<Customer> newCustomer = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            newCustomer = mapper.readValue(json, new TypeReference<>() {});
        } catch (MismatchedInputException e) {
            System.out.println("Failas yra tuscias");
        }
        if (!newCustomer.isEmpty()){
            return newCustomer.get(0);
        }
        return null;
    }

    public void addToJson(List<Customer> customers) {
        try {
            new ObjectMapper().writeValue(new File("src/main/resources/output.json"), customers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
