
package streamspractices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesStreamOfString {
    public static void main(String[] args) {
        //abc.txt file placed in project folder
        Path path = Paths.get("abc.txt");
        try {
           /*
            //lines() method read line by line and save line in a stream then move next line...
             Stream<String> fileStreamOfString = Files.lines(path);
            fileStreamOfString.forEach(System.out::println);
            */
            
            //or do in one line 
            Files.lines(path).forEach(System.out::println);
        } catch (IOException ex) { }
    }
}
/*
    Methods Types  -- DONE
    Instance Block -- DONE
    Static Block   -- DONE
    Constructors   -- DONE
    Inner Classes  -- DONE
    Type Casting   -- DONE
    Arrays         -- DONE
    Referance type -- DONE
    Inheritance	   -- DONE
    Abstruct Class -- DONE
    Interfaces	   -- DONE
    PolyMorphism   -- DONE
    Overrding	   -- DONE
    Overloading	   -- DONE
    MultiThreading -- DONE
    Enumeration    -- DONE
*/