
package streamspractices;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamsPractices {


    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        arrayList.add("ddd");
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("abc");
        arrayList.add("cba");
        
        /*
        Stream<String> st = arrayList.stream();
        Stream<String> distinct = st.distinct();
        long count = distinct.count();
        System.out.println("Count Distinct : "+count);
        */
        
       //OR 
       /*
         Stream st = arrayList.stream();
        long count = st.distinct().count();
        System.out.println(count);
        */
        
        //OR Just do in one line
       
        long count = arrayList.stream().distinct().count();
        System.out.println("Total Distinct Elements : "+count);
        
        //other example 
        boolean isMatch = arrayList.stream().anyMatch(e->e.contains("ab5"));
        System.out.println(isMatch);
        
        boolean isMatchAny = arrayList.stream().anyMatch(e->e.contains("bc"));
        System.out.println(isMatchAny);
        
        boolean isEquals = arrayList.stream().anyMatch(e->e.equals("aaa"));
        System.out.println(isEquals);
        
        System.out.println("\nPrint Arraylist Elements :- ");
        /*
        arrayList.stream().forEach((e) -> {
            System.out.print(e+" -- ");
        });
        
        */
        //OR
        arrayList.stream().forEach(System.out::println);
        System.out.println("---------------------");
        
    }
    
}
