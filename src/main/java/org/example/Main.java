package org.example;

import org.example.LambdaExpression.Employee;
import org.example.LambdaExpression.SoftwareEngineer;

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

    }
}