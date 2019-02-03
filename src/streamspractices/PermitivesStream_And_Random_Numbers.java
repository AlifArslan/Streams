
package streamspractices;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;


public class PermitivesStream_And_Random_Numbers {
    public static void main(String[] args) {
        
        /*
        Java 1.8 offers three types of permitivies streams
        1)IntStream (it also have range and rangeClosed methods)
        2)LongStrean (it also have range and rangeClosed methods)
        2)DoubleStream (Does Not support or have range and rangeClosed methods)
        */
        
        System.out.println("\nrange(1, 4) :- ");
        //range(start inclusive, end exclusive);
        IntStream ins = IntStream.range(1, 4); //range 1 to 3 .. 4 is excluded in range method
        ins.forEach(System.out::println);
        
        System.out.println("-----------\nrangeClosed(1, 3) :- ");
        //rangeClosed(start inclusive, end inclusive);  both start and end are included
        IntStream i2 = IntStream.rangeClosed(1, 3); //range 1 to 3 .. 3 is included in rangeClosed method
        i2.forEach(System.out::println);
        
        
        //create Random object
        Random random = new Random();
        
        //generate random number
        System.out.println("----------\nGenerate Long Type Random Numbers :- ");
        LongStream longStream = random.longs(2);
        longStream.forEach(System.out::println);
        
        
        System.out.println("----------\nGenerate int Type Random Numbers :-");
        //ints(long streamSize);
        //IntStream is2 = random.ints(2);
        
        //ints(long streamSize, int randomNumberOrigin,int randomNumberBound)
        //IntStream is2 = random.ints(5, 10, 50);
        
        ////ints(int randomNumberOrigin,int randomNumberBound) 
        IntStream is2 = random.ints(10, 50).limit(2);   //intil if we limit the execution
        is2.forEach(System.out::println);
        
        //Generate random number of double data type
        System.out.println("----------\nGenerate double Type Random Numbers :- ");
        /*
        DoubleStream d3 = random.doubles(3);
        d3.forEach(System.out::println);
        */
        //OR
        /*   oubles(double randomNumberOrigin, double randomNumberBound)   */
        random.doubles(1, 5).limit(4).forEach(System.out::println); //infinite execution until we limit
        System.out.println("-----------------------");
        /*   doubles(long streamSize, double randomNumberOrigin,double randomNumberBound)  */
        random.doubles(3, 1.5, 5.8).forEach(System.out::println);
        
    }
}

/*
Output :- 
        range(1, 4) :- 
        1
        2
        3
        -----------
        rangeClosed(1, 3) :- 
        1
        2
        3
        ----------
        Generate Long Type Random Numbers :- 
        3778200043661581093
        5313258731521882682
        ----------
        Generate int Type Random Numbers :-
        36
        35
        ----------
        Generate double Type Random Numbers :- 
        3.88948851402497
        1.4427506146324522
        3.6173696159371107
        4.912495420876846
        -----------------------
        3.5233091315510165
        4.972411959029769
        4.0492186994454835
*/
