package org.example;

@FunctionalInterface //it restricts the interface to be functional interface
public interface ChildInterface extends MyInterface{
    //public void sayBye(); // parent already has one abstract method now they will become two so this will throw error

    //default and static methods can be multiple
    default void sayBye(){
        System.out.print("Bye");
    }

    //we can write main method inside interface as well but in java 8 and after
    public static void main(String[] args){
        System.out.print("hello from interface");
    }

}
