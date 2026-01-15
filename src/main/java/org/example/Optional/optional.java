package org.example.Optional;

import javax.management.modelmbean.InvalidTargetObjectTypeException;
import java.util.NoSuchElementException;
import java.util.Optional;

public class optional {

    public static void main(String[] args) {
        Optional<String> name = getName(2);
        //String nameToBeUsed = name.orElseThrow(() -> new NoSuchElementException());
        //String nameToBeUsed = name.orElse("NA");
        String nameToBeUsed = name.orElseGet(() -> "NA"); //give supplier function for orElseGet()
        System.out.println(nameToBeUsed);

        //we can apply methods on Optional as well like this
        Optional<String> optional = getName(1);
        Optional<String> optional1 = optional.map(x -> x.toUpperCase()); // applying map() on the value which is inside optional
        optional1.ifPresent(System.out::println); //print if value is present inside the box i.e. optional
    }

    private static Optional<String> getName(int id) {
       String name = "akash";
        return Optional.ofNullable(name);
        //return Optional.empty(); //for giving null

    }
}
