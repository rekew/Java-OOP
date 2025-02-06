package com.example;

import com.example.domain.Employee;

public class EmployeeTest {
    public static void main(String[] args){
        Employee temp = new Employee();

        final int check = 1;

        System.out.println(check);

        temp.setId(1);
        temp.setName("Rustem Amirkhanuly");
        temp.setKey("1234");
        temp.setSalary(120000);
        temp.giveRaise(10);

        System.out.println("ID:" + temp.getId());
        System.out.println("Name:" + temp.getName());
        System.out.println("Key:" + temp.getKey());
        System.out.println("Salary:" + temp.getSalary());
    }
}
