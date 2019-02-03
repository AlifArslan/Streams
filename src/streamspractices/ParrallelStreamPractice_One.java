package streamspractices;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ParrallelStreamPractice_One {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        arrayList.add("ddd");
        arrayList.add("eee");
        arrayList.add("fff");

        /* it provides multiple threads for preforming task just use parrallel stream instead of doing long work 
        creating threads at background. this is the samrt way to do it. 
       The output is unpredicted order. or the insertion order is not preserved. or it not maintained the insertion 
        sequence  order.
       */
        Stream<String> parrallelStream = arrayList.parallelStream();
        System.out.println("Processing Data...");
        parrallelStream.forEach(e -> doWork(e));

    }

    private static void doWork(String e) {
        System.out.println(e);
        try {

            Thread.sleep(1000);
        } catch (InterruptedException ex) {

        }
    }
}
/*
Processing Data...
ddd
fff
bbb
eee
ccc
aaa
*/