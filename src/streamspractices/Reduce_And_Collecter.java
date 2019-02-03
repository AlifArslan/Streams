
package streamspractices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce_And_Collecter {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(100);
        arrayList.add(-50);
        
        //reduce
        Integer result = arrayList.stream().reduce(0,(a, b)->a+b);
        System.out.println("Result is : "+result);
        
        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add(100);
        al2.add(50);
        al2.add(50);
        al2.add(50);
        
        Integer sum = al2.stream().reduce(1000, (x, y)->x+y);
        System.out.println("Sum : "+sum);
        
        //create list from stream using collect method.
        ArrayList<String> al3 = new ArrayList<>();
        al3.add("aaa");
        al3.add("bbb");
        al3.add("ccc");
        al3.add("ddd");
        
        System.out.println("Convert ArrayList Elements to UpperCase and Store in new List :- ");
        List<String> al4 = al3.stream().map(e->e.toUpperCase()).collect(Collectors.toList());
        al4.forEach(System.out::println);
        
    }
}
/*
Result is : 50
Sum : 1250
Convert ArrayList Elements to UpperCase and Store in new List :- 
AAA
BBB
CCC
DDD
*/