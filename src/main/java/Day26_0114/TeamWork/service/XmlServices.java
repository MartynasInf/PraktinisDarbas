package Day26_0114.TeamWork.service;

import Day26_0114.TeamWork.entity.Teacher;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;


public class XmlServices {

    public void writeXML(List<Teacher> teacher) throws JAXBException {
        File file = new File("src/main/resources/test.xml");
        for (Teacher teacher1 : teacher) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Teacher.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(teacher1, file);
        }
    }
}
