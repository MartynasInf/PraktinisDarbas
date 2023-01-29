package Day26_0114.TeamWork;


import Day26_0114.TeamWork.entity.Book;
import Day26_0114.TeamWork.entity.Student;
import Day26_0114.TeamWork.entity.Teacher;
import Day26_0114.TeamWork.repository.TeacherRepo;
import Day26_0114.TeamWork.service.ExpensesCalculator;
import Day26_0114.TeamWork.service.JsonService;
import Day26_0114.TeamWork.service.TestDataProvider;
import Day26_0114.TeamWork.service.XmlServices;

import javax.xml.bind.JAXBException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException {
        TestDataProvider testDataProvider = new TestDataProvider();
        JsonService jsonService = new JsonService();
        TeacherRepo teacherRepo = new TeacherRepo();
        teacherRepo.save(testDataProvider.createTeacher());
        //teacherRepo.delete(1L);
        Teacher newTeacher = new Teacher();
        newTeacher.setId(1L);
        newTeacher.setName("Maryte");
        newTeacher.setSubject("Music");

        //teacherRepo.update(newTeacher);
        teacherRepo.findAll().forEach(System.out::println);

        List<Teacher> teachersList =  teacherRepo.findAll();

        jsonService.addToJson("src/main/resources/Teacher.json", teacherRepo.findAll());

        ExpensesCalculator expensesCalculator = new ExpensesCalculator();

        expensesCalculator.calculateStudentExpenses(teachersList.get(0).getStudents().get(0));
        System.out.println(expensesCalculator.calculateAllBooksPrice(teachersList));
        XmlServices xmlServices = new XmlServices();


        Book eilerastis = new Book();
        eilerastis.setId(5L);
        eilerastis.setName("Eilerasciu knyga");
        eilerastis.setPrice(15);
        eilerastis.setStudent(null);

        Student jolita = new Student();
        jolita.setId(10L);
        jolita.setName("Jolita");
        jolita.setBooks(Arrays.asList(eilerastis));
        jolita.setTeacher(null);
        xmlServices.writeXML(teachersList);
    }
}
