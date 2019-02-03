
package streamspractices;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InfiniteStream {
    public static void main(String[] args) {
        /*
        -->Infinite Stream does not executed until we call terminal operation.
        -->If we dont limit the iteration of execution then stream executes until we get MemoryOutOfBound Exception.
        -->Terminal operation does not perform tranversing until the stream is executed.
        */
        
        //iterate(start value, function behaviour/ lamda expression);
        Stream<Integer> iterate = Stream.iterate(40, e->e+2);
        List<Integer> collect = iterate.limit(5).collect(Collectors.toList());
        collect.forEach(System.out::println);
        
        //infinite stream we limit must else it executes until memory exception comes
        Stream.generate(()->"Hiii").limit(5).forEach(System.out::println);
    }
}
/*
Output :- 
            40
            42
            44
            46
            48
            Hiii
            Hiii
            Hiii
            Hiii
            Hiii
*/