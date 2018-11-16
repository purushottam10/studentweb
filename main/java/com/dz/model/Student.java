package com.dz.model;

public class Student {
    private int roll_no;
    private String name ;
    private int age ;

    /**
     *
     * @return rool_no
     */
    public int getRoll_no() {
        return roll_no;
    }

    /**
     *
     * @param roll_no
     */
    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }
}
