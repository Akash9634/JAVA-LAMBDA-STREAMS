package org.example.LambdaExpression;

import java.util.Arrays;
import java.util.List;

public class MethodReference {
    public static void print(String s){
        System.out.println(s);
    }

    public static void main(String[] args){
        List<String> students = Arrays.asList("akash", "shivam", "aditya");

        //here forEach method takes a consumer means we will be writing method implementation for accept method which is a void method only takes returns nothing
        //students.forEach(x -> System.out.println(x));

        //we can do the above operation using method reference
        students.forEach(MethodReference::print); // this means go into the MethodReference class and take the reference of the print method
        //if print method was not static then we would have made the object of the class say for ex - test(object) and do this test::print


    }
}
