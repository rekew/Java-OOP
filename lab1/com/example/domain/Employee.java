package com.example.domain;

public class Employee {
    public int id;       
    public String name;       
    public String key;       
    public double salary;
    
    public Employee(){
        System.out.println("success");
    }

    public int  getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getKey(){
        return key;
    }

    public double getSalary(){
        return salary;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setKey(String key){
        this.key = key;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public void giveRaise(double percent){
        if(percent > 0){
            salary += salary * (percent / 100);
            System.out.println(name + " получил повышение! Новая зарплата KZT: " + salary);
        }
        else{
            System.out.println("Ошибка! процент должен быть положительным!");
        }
    }
}
