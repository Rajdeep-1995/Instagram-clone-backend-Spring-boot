package streamAPI;


import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    There are mainly 4 types of functional interface in Java 8 with stream API
    1)Consumer -> return type void and takes T type as an argument (stream forEach)
    2)Predicate -> return type boolean and takes T type as an argument (stream filter)
    3)Supplier -> return type T with no arguments (while filtering out using stream, if nothing matches, we can use .orElseGet(Supplier)
    4)Function -> return type R and argument type T (map, flatMap) (this is data transformation, no filtering)
 */
public class StreamConcepts {

    public static void main(String[] args) {
        DAOLayer daoLayer = new DAOLayer();
        List<Customer> listOfCustomers = daoLayer.getCustomers();
        List<Employee> employeeList = DAOLayer.getEmployeesGender();

        // sorting using functional interface
        //listOfCustomers.sort(((o1, o2) -> o2.getName().compareTo(o1.getName())));

        // Consumer ex.
        //listOfCustomers.forEach(System.out::println);

        // sorting using stream sorted
        //listOfCustomers.stream().sorted(Comparator.comparing(Customer::getName).reversed()).forEach(System.out::println);

        // Predicate ex.
        //listOfCustomers.stream().filter(ls -> ls.getName().contains("a")).forEach(System.out::println);

        // Supplier ex.
        System.out.println(listOfCustomers.stream().filter(ls -> ls.getName().startsWith("z")).findAny().orElseGet(()->new Customer(100,"default cx","default@gmail.com", Arrays.asList("12334","45673"))));

        // Function ex. Transforming Customer object to only list of emails
        List<String> emails = listOfCustomers.stream().map(Customer::getEmail).collect(Collectors.toList());
        //emails.forEach(System.out::println);

        // Function ex. with map
        List<List<String>> phoneNumbersNonFlatterd = listOfCustomers.stream().map(Customer::getPhoneNumbers).collect(Collectors.toList());
        //phoneNumbersNonFlatterd.forEach(System.out::println);

        // Function ex. FlatMap
        List<String> phoneNumbers = listOfCustomers.stream().flatMap(cx -> cx.getPhoneNumbers().stream()).collect(Collectors.toList());
        //phoneNumbers.forEach(System.out::println);

        // reduce - get sum of salary No.
        long start = 0;
        long end = 0;

        start = System.currentTimeMillis();
       int sumOfSalary = DAOLayer.getEmployees().stream().map(Employee::getSalary).mapToInt(i->i).reduce(0, Integer::sum);
       end = System.currentTimeMillis();

        System.out.println("The sum of salary is "+ sumOfSalary + " and the time taken is "+ (end-start));


         //reduce parallel stream - get sum of salary No.

//        start = System.currentTimeMillis();
//        int sumOfSalaryParallel = DAOLayer.getEmployees().stream().parallel().map(Employee::getSalary).mapToInt(i->i).reduce(0, Integer::sum);
//        end = System.currentTimeMillis();
//
//        System.out.println("The sum of salary is "+ sumOfSalaryParallel + " and the time taken is "+ (end-start));

        List<Integer> numsList = List.of(1,3,2,7,9,3,2,1);
        List<Integer> numList2 = List.of(3,4,6,7,5,3,6,7);



        System.out.println(Arrays.toString(
                Stream.of(numsList, numList2)
                        .flatMap(Collection::stream)
                        .sorted(Comparator.reverseOrder())
                        .mapToInt(Integer::intValue)
                        .toArray())
        );

        List<String> strings = Arrays.asList("hello", "world", "java", "stream");

        List<String> result = strings.stream()
                .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
                .collect(Collectors.toList());

        System.out.println(result);

        Map<String, Long> collection =
                employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(collection);


        System.out.println("----------------------------------------------------------");
        Map<Integer,String> map1 = new HashMap<>();
        Map<Integer,String> map2 = new HashMap<>();

        map1.put(1,"Hello");
        map1.put(2,"world");
        map2.put(4,"I am ");
        map2.put(7,"good, how are you?");


        System.out.println("----------------------------------------------------------");
        System.out.println(Stream.of(map1,map2).flatMap(m->m.values().stream()).collect(Collectors.toList()));

        System.out.println(Stream.of(map1,map2).flatMap(m->m.entrySet().stream()).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue)));



    }

}
