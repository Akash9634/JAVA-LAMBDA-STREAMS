package org.example;

import com.sun.source.tree.Tree;
import org.example.LambdaExpression.Employee;
import org.example.LambdaExpression.MyClass;
import org.example.LambdaExpression.SoftwareEngineer;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Employee sde = () -> "Software engineer";
        System.out.println(sde.getName());
        Employee editor = () -> "Editor";
        System.out.println(editor.getName());

        //we don't need separate implementation class for editor or sde if interface has only one abstract method
        //but if class having multiple methods default methods , and we want to override them then we would need separate implementation class

        //here we are using MyClass object(class implementing runnable interface)
        //we can do this without implementation class using lambda expression
//        MyClass myClass = new MyClass();
//        Thread childThread = new Thread(myClass);
//        childThread.run();

        Runnable runnable = () -> {
            for(int i=1; i<=10; i++){
                System.out.println("hello " + i );
            }
        };
        Thread childThread = new Thread(runnable);
        childThread.run();


        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(10);
        list.add(15);
        list.add(56);
        list.add(1);

        //for descending
        Collections.sort(list, (a,b) -> b-a);
        System.out.println(list);

        Set<Integer> set = new TreeSet<>();
        set.add(22);
        set.add(13);
        set.add(10);
        System.out.println("before manual sorting: " + set);

        Set<Integer> set1 = new TreeSet<>((a,b) -> b-a);
        set1.add(22);
        set1.add(13);
        set1.add(10);
        System.out.println("after manual sorting: " + set1);

        //Predicate
        Predicate<String> predicate = x -> x.equals("akash");
        System.out.println(predicate.test("akas"));

        Predicate<Integer> isEven = x -> x%2 == 0;
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        for(Integer i : numbers){
            if(isEven.test(i)) {
                System.out.println(i);
            }
        }

        Predicate<String> startsWithV = x -> x.toLowerCase().charAt(0)=='v';
        System.out.print(startsWithV.test("vikas"));

        Student s1 = new Student("akash", 1);
        Student s2 = new Student("shivam", 2);
        List<Student> students = new ArrayList<>();

        //Function interface
        Function<String, String> function1 = x -> x.substring(0,3);

        Function<List<Student>, List<Student>> studentWithakaAsPrefix = li -> {
            List<Student> result = new ArrayList<>();
            for(Student s : li){
                if(function1.apply(s.getName()).equalsIgnoreCase("aka")){
                    result.add(s);
                }
            }
            return result;
        };
            List<Student> filteredStudents = studentWithakaAsPrefix.apply(students);
        System.out.println(filteredStudents);

        Function<String,String> newFun = x -> x.toUpperCase();
        Function<String, String> newFun1 = x -> x.substring(0,3);
        System.out.println(newFun.andThen(newFun1).apply("akash"));

        //Consumer
        Consumer<List<Integer>> listConsumer = x -> {
            for(Integer i : x){
                System.out.println(i + 100);
            }
        };
        listConsumer.accept(Arrays.asList(1 ,2 ,3 ,4));

        //Supplier
        Supplier<String> supplier = () -> "akash";
        System.out.println(supplier.get());
    }

    public static class Student{
        private String name;
        private int id;

        public Student(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}