package org.example;

import org.example.LambdaExpression.Employee;
import org.example.LambdaExpression.SoftwareEngineer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Employee employee = new SoftwareEngineer();
        System.out.println(employee.getName());
    }
}