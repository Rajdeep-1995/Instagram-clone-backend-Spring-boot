package streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DAOLayer {

    public List<Customer> getCustomers() {
        return Stream.of(
                new Customer(1,"abc","abc@gmail.com",List.of("343530909","6373662878")),
                new Customer(1,"def","def@gmail.com",List.of("777678778","98988376")),
                new Customer(1,"ghi","ghi@gmail.com",List.of("989898989","54652573")),
                new Customer(1,"jkl","jkl@gmail.com",List.of("73524748","5456319930")),
                new Customer(1,"mno","mno@gmail.com",List.of("00938737848","72654423426"))
        ).collect(Collectors.toList());
    }

    public static List<Employee> getEmployees() {
        List<Employee> empList = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            empList.add(new Employee(i, "Aa"+i ,new Random().nextInt(1000*100)));
        }

        return empList;
    }

    public static List<Employee> getEmployeesGender() {
        return Stream.of(
                new Employee(1,"Raj",40000,"MALE"),
                new Employee(1,"Daniel",90000,"MALE"),
                new Employee(1,"Nidhi",10000000,"FEMALE"),
                new Employee(1,"Mansi",80000,"FEMALE"),
                new Employee(1,"Nitesh",50000,"MALE"),
                new Employee(1,"Manish",48000,"MALE")

        ).collect(Collectors.toList());
    }
}
