
package streamspractices;

import java.util.ArrayList;
import java.util.stream.Stream;

public class FilterPractice {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        arrayList.add("ddd");
        arrayList.add("eee");
        arrayList.add("fff");
        
        
        boolean isValid = arrayList.stream().allMatch(e->e.contains("b")); 
        System.out.println(isValid); // return false
        
        boolean isValidOne = arrayList.stream().noneMatch(e->e.contains("zz"));
        System.out.println(isValidOne); //return true
        
        boolean isValidTwo = arrayList.stream().anyMatch(p->p.equals("eee"));
        System.out.println(isValidTwo); //true
        
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(30);
        intList.add(50);
        intList.add(20);
        intList.add(60);
        
        Stream<Integer> filteredStream = intList.stream().filter(e->e>20);
        System.out.println("--------\nFileterd Elements :- ");
        filteredStream.forEach(System.out::println);
        
        /*how streams can be used at project level little demo example*/
        
        ArrayList<StudentModel> studentsArrayList = new ArrayList<>();
        studentsArrayList.add(new StudentModel(1, "Arslan", 22));
        studentsArrayList.add(new StudentModel(2, "Ali", 20));
        studentsArrayList.add(new StudentModel(3, "Noor", 35));
        studentsArrayList.add(new StudentModel(4, "Afridi", 30));
        studentsArrayList.add(new StudentModel(5, "Asif", 26));
        
        Stream<StudentModel> filterStudentsByAge = studentsArrayList.stream().filter(e->e.getAge()>25);
        System.out.println("--------\nFileterd Students By Age :- ");
        //notice toString method is overrided in StudentModel class
        filterStudentsByAge.forEach(System.out::println);
        
        
      /*
        // OR if toString is not overrided then print students like this
          filterStudentsByAge.forEach(e->{
            System.out.println(e.getId() + "-- "+e.getName()+" -- "+e.getAge());
    });
        */
        
        System.out.println("--------------------------\nOriginal Students ArrayList");
        
        System.out.println(studentsArrayList);
        
        System.out.println("----------------");
        
        boolean isMatchAll = studentsArrayList.stream().allMatch(e->e.getAge()>30);
        System.out.println("Is Any Student Age Greater than 30 ? allMatch(..) : "+ isMatchAll );
        
        boolean isMatchAny = studentsArrayList.stream().anyMatch(e->e.getName().equals("Arslan"));
        System.out.println("Any Student with Arslan Name in List ? anyMatch(..) : "+ isMatchAny);
        
        boolean isNoneMatch = studentsArrayList.stream().noneMatch(e->e.getAge() > 50);
        System.out.println("Is Any Student Age Greater than 50 ? noneMatch(..) : "+ isNoneMatch );
    }
}
