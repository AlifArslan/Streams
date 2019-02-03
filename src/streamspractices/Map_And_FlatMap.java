
package streamspractices;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Cities
{
    int id;
    ArrayList<String> citiesArrayList;

    public Cities(int id, ArrayList<String> citiesArrayList) {
        this.id = id;
        this.citiesArrayList = citiesArrayList;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getCitiesArrayList() {
        return citiesArrayList;
    }

    public void setCitiesArrayList(ArrayList<String> citiesArrayList) {
        this.citiesArrayList = citiesArrayList;
    }
    
    
}

public class Map_And_FlatMap {
    
    
    public static void main(String[] args) {
        ArrayList<String> pathsList = new ArrayList<>();
        pathsList.add("C:Users/Ar/...");
        pathsList.add("C:Users/.../Desktop/abc.txt");
        pathsList.add("C:Users/Nouman/...");
        pathsList.add("C:Windows/...");
        
        System.out.println("-->Convert Path List Elements To Path Type Element :-");
        Stream<Path> mapStream = pathsList.stream().map(uri->Paths.get(uri));
        mapStream.forEach(System.out::println);
        
        System.out.println("--------------\n\n-->Convert Path List Elements To Upper Case :-");
        Stream<String> map2 = pathsList.stream().map(e->e.toUpperCase());
        map2.forEach(System.out::println);
        
        //Flat Map Demo create the stream of internal elements of another stream 
        
        ArrayList<String> pakistanCities = new ArrayList<>();
        pakistanCities.add("Lahore");
        pakistanCities.add("Karachi");
        pakistanCities.add("Islamabad");
        pakistanCities.add("Gujrat");
        
        ArrayList<String> kashmirCities = new ArrayList<>();
        kashmirCities.add("Bhimber");
        kashmirCities.add("Samahni");
        kashmirCities.add("Neelum");
        kashmirCities.add("Mirpur");
        
        Cities pak =  new Cities(111, pakistanCities);
        Cities kashmir =  new Cities(222, kashmirCities);
        
        ArrayList<Cities> al = new ArrayList<>();
        al.add(pak);
        al.add(kashmir);
        
        System.out.println("----------------\n\n-->FlatMapStream :- ");
       /*
        Stream<String> flatMapStream = al.stream().flatMap(c->c.getCitiesArrayList().stream());
        flatMapStream.forEach(System.out::println);
        */
        
        // OR Collect stream elements as List
        List<String> collect = al.stream().flatMap(c->c.getCitiesArrayList().stream()).collect(Collectors.toList());
        collect.forEach(System.out::println);
        
    }
}
/*
Output :- 
            -->Convert Path List Elements To Path Type Element :-
            C:Users\Ar\...
            C:Users\...\Desktop\abc.txt
            C:Users\Nouman\...
            C:Windows\...
            --------------

            -->Convert Path List Elements To Upper Case :-
            C:USERS/AR/...
            C:USERS/.../DESKTOP/ABC.TXT
            C:USERS/NOUMAN/...
            C:WINDOWS/...
----------------

-->FlatMapStream :- 
Lahore
Karachi
Islamabad
Gujrat
Bhimber
Samahni
Neelum
Mirpur
*/