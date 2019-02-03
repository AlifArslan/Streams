
package streamspractices;

import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfString {
    public static void main(String[] args) {
        String s = "abcdxyz";
        /* there is no CharStream in java so when we apply chars() method on string then IntStream is used to store/
        represents the uni code values of characters    
        */
       /* IntStream streamOfChars = s.chars();
        streamOfChars.forEach(System.out::println);*/
        
        //OR just do in one line
        s.chars().forEach(System.out::println);
        
        System.out.println("-----------");
        String s2 = "Hi,How,When,What,Why";
        Stream<String> streamOfString = Pattern.compile(",").splitAsStream(s2);
        streamOfString.forEach(System.out::println);
        
        System.out.println("-------------");
        //OR JUST do in one line
        String s3 = "How are you friend ?";
        Pattern.compile(" ").splitAsStream(s3).forEach(System.out::println); 
        
        System.out.println("---------");
        
        //String[] arr = Pattern.compile(" ").split(s3);   /*split(CharSequence input); */
        //OR
        String[] arr = Pattern.compile(" ").split(s3, 3); /* split(CharSequence input, int limit); */
        for(String e : arr)
        {
            System.out.println(e);
        }  
    }
}
/*
Output :- 
            97
            98
            99
            100
            120
            121
            122
            -----------
            Hi
            How
            When
            What
            Why
            -------------
            How
            are
            you
            friend
            ?
            ---------
            How
            are
            you friend ?
*/
