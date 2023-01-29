package Day25_0114.ClassWork;

import Day25_0114.ClassWork.entity.Department;
import Day25_0114.ClassWork.repository.DepartmentRepository;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        DepartmentRepository depRepo = new DepartmentRepository();

        Department itDepartment = new Department();
        itDepartment.setName("IT Gurus");
        itDepartment.setBudget(new BigDecimal(150000));

        Department transportDept = new Department();
        transportDept.setName("UAB FastWheels");
        transportDept.setBudget(new BigDecimal(352000));

        depRepo.save(itDepartment);
        depRepo.save(transportDept);

//        depRepo.delete(itDepartment);

//        for (Department depos : depRepo.findAll()) {
//            System.out.println(depos);
//        }
        depRepo.findAll().forEach(System.out::println);


    }
}
