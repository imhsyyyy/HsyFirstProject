package com.fdzc.hsyfirstproject.Entity;

import java.util.List;

public class Department {
    private static int id;
    private static String dept_name;
    private static String description;
    private static String address;
    private static List<User> users;

    public Department(int id, String dept_name, String description, String address, List<User> users) {
        this.id = id;
        this.dept_name = dept_name;
        this.description = description;
        this.address = address;
        this.users = users;
    }

    public Department() {
    }

    public int getId(int i) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Department{}";
    }
}
