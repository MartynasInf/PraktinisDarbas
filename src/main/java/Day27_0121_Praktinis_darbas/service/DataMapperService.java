package Day27_0121_Praktinis_darbas.service;

import Day27_0121_Praktinis_darbas.entity.Address;
import Day27_0121_Praktinis_darbas.entity.Customer;
import Day27_0121_Praktinis_darbas.entity.Project;

import java.util.*;

public class DataMapperService {

    /**
     * Maps data from JSON to bidirectional join in addresses (projects) and project (customer)
     */
    public List<Customer> mapsListFromJson(List<Customer> customers) {
        if (!customers.isEmpty() && !customers.contains(null)) {
            List<Customer> newList = new ArrayList<>();
            for (Customer customer : customers) {
                for (Project project : customer.getProjects()) {
                    project.setCustomer(customer);
                    for (Address address : project.getAddresses()) {
                        address.setProject(project);
                    }
                }
                newList.add(customer);
            }
            return newList;
        }
        return new ArrayList<>();
    }
}
