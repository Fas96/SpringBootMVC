package com.fas.SpringBootMVC.model;

import org.springframework.stereotype.Component;

@Component("Dept")
public class Department {
    private int Did;
    private String dName;

    public int getDid() {
        return Did;
    }

    public void setDid(int did) {
        Did = did;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "Did=" + Did +
                ", dName='" + dName + '\'' +
                '}';
    }

    public void compile(){
        System.out.println("This department is working...");
    }
}
