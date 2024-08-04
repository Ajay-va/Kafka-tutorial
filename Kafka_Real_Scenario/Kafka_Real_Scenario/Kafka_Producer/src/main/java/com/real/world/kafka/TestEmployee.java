package com.real.world.kafka;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface Gender{
    public static final String MALE="Male";
    public static final String FEMALE="Female";
};
interface Department{
    public static final String PRODUCTDEVELOPMENT="Product Development";

};

public class TestEmployee {



    static List<Employee> employeeData=Employee.getAllEmployeeList();


    public static void main(String[] args) {


//How many male and female employees are there in the organization?

        Map<String,Long> noOfMaleAndFemaleEmployees=
                employeeData
                        .stream()
                        .collect(Collectors.groupingBy(Employee::getGender
                                ,Collectors.counting()));

    List<String> empNamesList=    employeeData.stream().map(Employee::getName).distinct().collect(Collectors.toList());

    System.out.println(empNamesList);

    Map<String,Double> avgAgeOfMaleAndFemales= employeeData.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));

        System.out.println(avgAgeOfMaleAndFemales);

       Optional<Employee> employeeHighestSalaryEmp= employeeData.stream().collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)));

       if(employeeHighestSalaryEmp.isPresent()){
           System.out.println(employeeHighestSalaryEmp.get());

       }


    List<String> namesOfWhoJoined2015=   employeeData.stream().filter(emp->emp.getYearOfJoining() > 2015).map(Employee::getName).collect(Collectors.toList());

        System.out.println(namesOfWhoJoined2015);


    Map<String,Long> countTheNumberOfEmployeeInEachDept=    employeeData.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));

        System.out.println(countTheNumberOfEmployeeInEachDept);

        Map<String,Double> averageSalaryOfEachDept=employeeData.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));

    Set<Map.Entry<String,Double>> avergeSalary= averageSalaryOfEachDept.entrySet();

    for(Map.Entry<String,Double> entrySalary: avergeSalary){

        System.out.println(entrySalary.getKey()+"="+entrySalary.getValue());


    }


        System.out.println(Department.PRODUCTDEVELOPMENT+"=====================");
    Optional<Employee> youngMaleEmployee=employeeData.stream().filter(e->e.getDepartment()==Department.PRODUCTDEVELOPMENT && e.getGender()==Gender.MALE)
            .min(Comparator.comparing(Employee::getAge));

        System.out.println(youngMaleEmployee.get());


        Employee secondHighestSalary=    employeeData.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).skip(1).findFirst().get();

        System.out.println(secondHighestSalary.getName()+","+secondHighestSalary.getSalary());



//        System.out.println(streamMethod());

   Map<Boolean,List<Employee>>  countEmp=employeeData.stream().collect(Collectors.partitioningBy(e->e.getAge()>2015));

   Set<Map.Entry<Boolean,List<Employee>>> empData=    countEmp.entrySet();

   for (Map.Entry<Boolean, List<Employee>> entry:empData){

       if(entry.getKey()){

           System.out.println("Less than 25");
       }else {
           System.out.println("Greter than 25");
       }


       ExecutorService executorService= Executors.newFixedThreadPool(10);

       executorService.execute(new Runnable() {
           @Override
           public void run() {

               System.out.println("Executor Service....!!!");

           }
       });

//   List<Employee> listEmp=    entry.getValue();
//       for (Employee e:listEmp){
//           System.out.println(e.getName()+"="+e.getAge());
//       }


   }


    }
    public static Stream<String> streamMethod(){

        ArrayList<String> al=new ArrayList<>();
        al.add("ajay");

        Stream.Builder<Employee[]> employeeBuilder=Stream.builder();
        employeeBuilder.accept(new Employee[]{new Employee(),new Employee(),});

        Integer[] values={1,2,3,4,5};

    List<Integer> integerList= Stream.of(values).toList();
        System.out.println();

        return al.stream();





//        return employeeData.stream().map(Employee::getName).collect(Collectors.toList());

    }






}
