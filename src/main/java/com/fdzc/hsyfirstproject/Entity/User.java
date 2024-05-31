package com.fdzc.hsyfirstproject.Entity;

public class User {
    private int id;
    private String user_name;
    private String password;
    private int gender;
    private int birthday;
    private int dept_id;

    public User() {
    }

    public User(int id, String user_name, String password, int gender, int birthday, int dept_id) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.dept_id = dept_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", dept_id=" + dept_id +
                '}';
    }
}
