package Day26_0114.TeamWork.service;

import Day26_0114.TeamWork.entity.Book;
import Day26_0114.TeamWork.entity.Student;
import Day26_0114.TeamWork.entity.Teacher;

import java.util.Arrays;

public class TestDataProvider {

    public Teacher createTeacher(){
        Teacher tomas = new Teacher();

        Student migle = new Student();
        migle.setName("Migle");
        migle.setTeacher(tomas);
        Student laura = new Student();
        laura.setName("Laura");
        laura.setTeacher(tomas);
        Book harryPotter = new Book();
        Book marryPoppins = new Book();
        Book mathPath = new Book();

        harryPotter.setName("Harry Potter");
        harryPotter.setPrice(29);
        marryPoppins.setName("Marry Poppins");
        marryPoppins.setPrice(21);
        mathPath.setName("Math for starters");
        mathPath.setPrice(7);

        harryPotter.setStudent(migle);
        marryPoppins.setStudent(laura);
        mathPath.setStudent(laura);

        migle.setBooks(Arrays.asList(harryPotter));
        laura.setBooks(Arrays.asList(marryPoppins, mathPath));

        tomas.setName("Tomas");
        tomas.setSubject("Math");
        tomas.setStudents(Arrays.asList(migle, laura));
        return tomas;
    }
}
