package Day26_0114.TeamWork.service;

import Day26_0114.TeamWork.entity.Book;
import Day26_0114.TeamWork.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ExpensesCalculatorTest {

    ExpensesCalculator expensesCalculator = new ExpensesCalculator();

    @Test
    void calculateStudentExpenses() {
        //Given
        Student marius = new Student();
        Book patarles = new Book();
        patarles.setId(1L);
        patarles.setName("patarliu knyga");
        patarles.setPrice(25);
        patarles.setStudent(marius);
        marius.setId(1L);
        marius.setBooks(Arrays.asList(patarles));
        //When
        Integer gautaSuma = expensesCalculator.calculateStudentExpenses(marius);
        //Then
        assertEquals(25, gautaSuma);
    }
}