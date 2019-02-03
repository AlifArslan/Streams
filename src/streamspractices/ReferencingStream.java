
package streamspractices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReferencingStream {
    public static void main(String[] args) {
        /*
        Stream basic purpose is to apply different operation on data. and data are stored some where. Stream itself does 
        not stores the data so when we one time consumed a stream means we apply a terminal function on the stream then
        that same stream re-usability is not possible. it we try to reuse a stream after consuming then we will get an
        IllegelState Exception. So Stream are for apply operation not for storing data. If we want reusablity then Stream
        provides collect method that returns us a result collection object of stream results against some operation
        and then we can use that collection object for further operations performing on that data..See example below
        */
        
        Stream<Integer> stream = Stream.of(1,2,3,14,5,66,7,88,90,101).filter(e->e>10);
        Optional<Integer> optional = stream.findAny();
        
//below consume the optional 
        System.out.println(optional.get()); // optional.get(); gives the only first matching or true result from stream.
        //stream.forEach(System.out::println);
        
        /*
        now if we want to resuse the above stream then we get exception IllegelStateException becz Streams not stores
        the data. it apply operations on data only. for applying operations on data we must need to first make 
        the data resource means first must store data in somewhere like collection class holds data like array list
        , and or store in txt files or in a String then we performs operations on data.
        
        */
        
       // stream.findFirst(); //exceptions araises here
        /*Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed*/
        
        //how to overcome this see example below
        
        System.out.println("--------------------");
        /* Stream.of(Object type) It always return same type of Stream or Collection Object here 
        which we passed in Stream.of(..) method */
        List<String> list = Stream.of("Aliff", "Aliff", "Arslan", "Arslan Shakar", "Noor Pathan", "Asif Asif").filter(e->e.contains("ff")).collect(Collectors.toList());
        Optional<String> fa = list.stream().findAny();
        System.out.println("Find Any : "+ fa.get());
        
        Optional<String> ff = list.stream().findFirst();
        
        System.out.println("Find First : "+ff.get());
        
        
        /****************************  ArrayList Example *************************************/
        
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Alif");
        arrayList.add("Arslan");
        arrayList.add("Alif");
        arrayList.add("Noor");
        arrayList.add("Noor Rehman");
        arrayList.add("Asif");
        arrayList.add("Ali");
        System.out.println("---------------------");
        
        Stream<String> convertArrayListElementToStringStream = arrayList.stream().filter(e->e.contains("oo"));
        List<String> collect = convertArrayListElementToStringStream.collect(Collectors.toList());
        //now we are able to resue the stream result in anywhere many times bcz we stored in Collection Form 
        
        Optional<String> findAny = collect.stream().findAny();
        System.out.println("Find Any : "+findAny.get());
        
        Optional<String> findFirst = collect.stream().findFirst();
        System.out.println("Find First : "+findFirst.get());
        
        System.out.println("---------------------\nAll matched Elements :- ");
        
        
        collect.forEach(System.out::println); //reuse again bcz the result of stream we stored in Collection Form
        
        //OR Just do in One Line
        //System.out.println(Stream.of(arrayList).filter(e->e.contains("Alif")).findAny().get());
    }
}

/*
    14
    --------------------
    Find Any : Aliff
    Find First : Aliff
    ---------------------
    Find Any : Noor
    Find First : Noor
    ---------------------
    All matched Elements :- 
    Noor
    Noor Rehman
*/