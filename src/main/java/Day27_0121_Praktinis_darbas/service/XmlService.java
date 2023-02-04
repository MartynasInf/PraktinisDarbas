package Day27_0121_Praktinis_darbas.service;

import Day27_0121_Praktinis_darbas.entity.Customer;
import Day27_0121_Praktinis_darbas.entity.Customers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.File;
import java.util.List;

public class XmlService {
    public void writeXML(List<Customer> customers) throws JAXBException {
        File file = new File("src/main/resources/PraktinisDarbas.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Customers.class);
        Marshaller marshaller = jaxbContext.createMarshaller();

        QName qName = new QName("customers");
        JAXBElement<Customers> root = new JAXBElement<>(qName, Customers.class, new Customers(customers));

        marshaller.marshal(root, file);
    }
}
