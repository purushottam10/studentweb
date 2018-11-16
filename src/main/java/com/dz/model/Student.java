package com.dz.model;


/**
 * model class
 */


public class Student {

    private int roll_no;
    private String studentName;
    private int age;

    /**
     *
     * @return roll_no
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
     * @return studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     *
     * @param studentName
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     *
     * @return age
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

    @Override
    public String  toString(){
        return roll_no+"  "+studentName+"  "+age;
    }
}
//class end