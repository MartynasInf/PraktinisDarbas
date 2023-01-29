package Day27_0121_Praktinis_darbas.service;

import Day27_0121_Praktinis_darbas.entity.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonService {

    public List<Customer> fileToList() throws IOException {
        String file = "src/main/resources/DataProvider.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));
        ObjectMapper mapper = new ObjectMapper();
        List<Customer> customersFromFile = mapper.readValue(json, new TypeReference<>() {});
        return customersFromFile;
    }
    public Customer createCustomerFromJsonFile() throws IOException {
        String file = "src/main/resources/ImportNewCustomer.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));
        ObjectMapper mapper = new ObjectMapper();
        List<Customer> newCustomer = mapper.readValue(json, new TypeReference<>() {});
        return newCustomer.get(0);
    }
}
