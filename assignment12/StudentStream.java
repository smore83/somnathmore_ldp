/*

Use stream api on above list of employees find

1. Print the name of all departments in the college?
2.Get the names of all students who have enrolled after 2018?
3. Get the details of all male student in the computer sci department?
4. How many male and female student are there ? (HINT:use Collectors.groupingBy() for grouping based on gender)
5.What is the average age of male and female students?
6.Get the details of highest student having highest percentage ?
7.Count the number of students in each department? (Hint :use Collectors.groupingBy())
8. What is the average percentage achieved in each department?
9. Get the details of youngest male student in the Electronic department?(Hint :Use Collectors.minBy)
10.How many male and female students are there in the computer science department?
 */
package Java_Assignment.assignment12;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class StudentStream {
    List<Student> studentList;
    public StudentStream() {
        studentList = new ArrayList<>();
        studentList.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        studentList.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        studentList.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        studentList.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80.0));
        studentList.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70.0));
        studentList.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70.0));
        studentList.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70.0));
        studentList.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80.0));
        studentList.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85.0));
        studentList.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82.0));
        studentList.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83.0));
        studentList.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        studentList.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        studentList.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        studentList.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        studentList.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        studentList.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));
    }
    public static void main(String[] args) {
        StudentStream parser = new StudentStream();
        parser.printDepartment();
        parser.printEnrollmentsAfter2018();
        parser.printAllMalesInCS();
        parser.printTotalNumberOfMaleAndFemale();
        parser.printAverageAge();
        parser.printHighestPercentage();
        parser.printNumberOfStudentsInEachDepartment();
        parser.printAveragePercentageInDepartments();
        parser.printYoungestMaleInElectronicDepartment();
        parser.printCountOfMaleAndFemaleInCS();
    }












    private void printDepartment() {
        System.out.println("1. Print the name of all departments in the college?");
        studentList.stream()
                .map(i -> i.getEngDepartment())
                .distinct()
                .forEach(System.out::println);
    }

    private void printEnrollmentsAfter2018() {
        System.out.println("2.Get the names of all students who have enrolled after 2018?");
        studentList.stream().filter(s -> s.getYearOfEnrollment() > 2018)
                .map(s -> s.getName())
                .forEach(System.out::println);
    }

    private void printAllMalesInCS() {
        System.out.println("3. Get the details of all male student in the computer sci department?");
        studentList.stream()
                .filter(s -> s.getGender().equals("Male"))
                .filter(s -> s.getEngDepartment().equals("Computer Science"))
                .forEach(s -> System.out.println("id: " + s.getId()+ ", name: " + s.getName() + ", age: " + s.getAge() + ", gender: " + s.getGender() + ", engDepartment: " + s.getEngDepartment() + ", year of enrollment: " + s.getYearOfEnrollment() + ", percentage till date: " + s.getPercentageTillDate()));
    }
    private void printTotalNumberOfMaleAndFemale() {
        System.out.println("4. How many male and female student are there ? (HINT:use Collectors.groupingBy() for grouping based on gender)");
        Map<String, Long> maleAndFemaleCount = studentList.stream().collect(Collectors.groupingBy(s -> s.getGender(), Collectors.counting()));
        System.out.println(maleAndFemaleCount);
    }
    private void printAverageAge() {
        System.out.println("5.What is the average age of male and female students?");
        Map<Object, Double> averageAgeOfEachGender = studentList.stream()
                .collect(Collectors.groupingBy(s -> s.getGender(), Collectors.averagingDouble(s -> s.getAge())));
        System.out.println(averageAgeOfEachGender);
    }
    private void printHighestPercentage() {
        System.out.println("6.Get the details of highest student having highest percentage ?");
        studentList.stream().max(Comparator.comparing(s -> s.getPercentageTillDate()))
                .ifPresent(s -> System.out.println("id: " + s.getId()+ ", name: " + s.getName() + ", age: " + s.getAge() + ", gender: " + s.getGender() + ", engDepartment: " + s.getEngDepartment() + ", year of enrollment: " + s.getYearOfEnrollment() + ", percentage till date: " + s.getPercentageTillDate()));
    }
    private void printNumberOfStudentsInEachDepartment() {
        System.out.println("7.Count the number of students in each department? (Hint :use Collectors.groupingBy())");
        Map<Object, Long> studentCountByDept = studentList.stream().collect(Collectors.groupingBy(s -> s.getEngDepartment(), Collectors.counting()));
        System.out.println(studentCountByDept);
    }

    private void printAveragePercentageInDepartments() {
        System.out.println("8. What is the average percentage achieved in each department?");
        Map<Object, Double> averageOfEachDepartment = studentList.stream()
                .collect(Collectors.groupingBy(s -> s.getEngDepartment(), Collectors.averagingDouble(s -> s.getPercentageTillDate())));
        System.out.println(averageOfEachDepartment);
    }


    private void printYoungestMaleInElectronicDepartment() {
        System.out.println("9. Get the details of youngest male student in the Electronic department?(Hint :Use Collectors.minBy)");
        studentList.stream().filter(e -> e.getGender().equals("Male") && e.getEngDepartment().equals("Electronic"))
                .min(Comparator.comparingInt(s -> s.getAge())).ifPresent(s -> System.out.println("Youngest male student in Electronic department is " + s.getName()));
    }

    private void printCountOfMaleAndFemaleInCS() {
        System.out.println("10.How many male and female students are there in the computer science department?");
        Map<String, Long> countMaleFemaleStudentsInComputerScience = studentList.stream().filter(s -> s.getEngDepartment().equals("Computer Science"))
                .collect(Collectors.groupingBy(s -> s.getGender(), Collectors.counting()));
        System.out.println(countMaleFemaleStudentsInComputerScience);
    }



}
