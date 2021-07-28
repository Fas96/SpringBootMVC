package com.fas.SpringBootMVC.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
    @Id
    private int pid;
    private String name;
    private int age;

    public Person() {
        this.pid =0;
        this.name = "Person does not exit";
        this.age = 0;
    }


    public int getPid() {
        return pid;
    }


    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
