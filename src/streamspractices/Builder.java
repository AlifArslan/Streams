
package streamspractices;

import java.util.stream.Stream;

public class Builder {
    public static void main(String[] args) {
        /*  
        if we dont mention Stream Type then by default it is Object type of Stream..internally it is like 
        Stream<Object> buildObjectTypeStream = Stream.<Object>builder().add("AAA").add("BBB").add(1111).build();
        */
        System.out.println("Normal Version of Stream :- ");
        Stream buildObjectTypeStream = Stream.builder().add("AAA").add("BBB").add(1111).build();
        buildObjectTypeStream.forEach(System.out::println);
        
        System.out.println("----------\nGeneric Version of Stream String Type:- ");
        Stream<String> s1 = Stream.<String>builder().add("ZZZ").add("YYY").build();
        s1.forEach(System.out::println);
        
        System.out.println("----------\nGeneric Version of Stream Integer Type:- ");
        Stream.<Integer>builder().add(1111).add(2222).build().forEach(System.out::println);
        
    }
}
