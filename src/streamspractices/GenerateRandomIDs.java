
package streamspractices;

import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerateRandomIDs {
    public static void main(String[] args) {
        
        System.out.println("Random ID's Generated Using Supplier<UUID> :- ");
        Supplier<UUID> randomUUIDs = UUID::randomUUID; 
        Stream<UUID> generate = Stream.generate(randomUUIDs);
        
        //skip(5); it basically skip first 5 ids...after that limit function work it limit 10 ids generated only 
        List<UUID> list = generate.skip(5).limit(10).collect(Collectors.toList());
        list.forEach(System.out::println);
        
        System.out.println("------------------\nCustom Generated ID's :- ");
        
        /*
        //Custom Generated ID's
         Stream<Integer> iterate = Stream.iterate(1, i->i+1);
        //first two ids skipked after that it genrates the 5 id's
        iterate.skip(2).limit(5).forEach(System.out::println);
        */
        
        //OR We can do similar work in just one line
        Stream.iterate(1, i->i+1).skip(2).limit(5).forEach(System.out::println);
    }
}
