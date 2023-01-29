package Day26_0114.TeamWork.service;

import Day26_0114.TeamWork.entity.Book;
import Day26_0114.TeamWork.entity.Student;
import Day26_0114.TeamWork.entity.Teacher;
import Day26_0114.TeamWork.util.HibernateUtility3;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.List;

public class ExpensesCalculator {

    public Integer calculateStudentExpenses (Student givenStudent){
        Integer suma = 0;
        for (Book book : givenStudent.getBooks()) {
            suma += book.getPrice();
        }
        System.out.println(givenStudent + "books total price is " + suma);
        return suma;
    }

    public Integer calculateAllBooksPrice (List<Teacher> teacherList){
        return teacherList.stream()
                .map(Teacher::getStudents)
                .flatMap(Collection::stream)
                .map(Student::getBooks)
                .flatMap(Collection::stream)
                .mapToInt(Book::getPrice)
                .sum();
    }
}
