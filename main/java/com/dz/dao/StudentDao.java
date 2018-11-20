package com.dz.dao;


import com.dz.model.Student;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * impl StudentDao
 * Perform all database activity
 */
public class StudentDao implements InfStudentDao {


    private PreparedStatement statement = null;

    private static Logger log = Logger.getLogger(StudentDao.class.getName());

    /**
     * @param student
     * @return true if data add in database  else false
     * to add student in database
     */
    public boolean addstudent(Student student) {


        log.info(" in add dao");

        int count;

        if (student.getAge() == 0) {
            return false;
        }
        try {
            statement = new  DbConfig().getConnection().prepareStatement("insert into student (id ,name,age)values (?,?,?)");

            statement.setInt(1, student.getRoll_no());
            statement.setString(2, student.getStudentName());
            statement.setInt(3, student.getAge());
            count = statement.executeUpdate();
            log.info("data inserted successfully");
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }//method end

    /**
     * @return roll_no
     * to set increase id of student
     */
    public int setId() {

        log.info("in operation");
        try {
            statement = new DbConfig().getConnection().prepareStatement("select Max(id) from student");
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                log.info(1);
                return rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return 0;
    }//method end

    /**
     * Display record
     * @return student List
     */
    public List<Student> display() {

        Student student;
        List<Student> studentList = new ArrayList<>();
        try {
            statement =  new DbConfig().getConnection().prepareStatement("select * from student");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                student = new Student();
                student.setRoll_no(rs.getInt(1));
                student.setStudentName(rs.getString(2));
                student.setAge(rs.getInt(3));

                studentList.add(student);
            }
            return studentList;
        } catch (SQLException e) {
            // TODO: handle exception
            log.error(e.getMessage(), e);
        }
        return null;
    }//method end

    /**
     * @param id
     * @return ture if record delete from database
     */
    public boolean removeById(int id) {
        // TODO Auto-generated method stub
        try {
            statement = new DbConfig().getConnection().prepareStatement("delete from  student  where id= ?");
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException | NullPointerException e) {
            log.info("problem");
            log.error(e.getMessage(), e);
            return Boolean.FALSE;
        }
    }//method end

    /**
     * @param student
     * @return
     * @throws IOException update the record of existing student
     */
    public boolean updateById(Student student) throws IOException {
        // TODO Auto-generated method stub
        int count = 0;
        log.info("print in update method ");
        log.error(student.getRoll_no()+"inside update method");
        if (student.getAge() == 0 || student.getStudentName().equals(null)) {
            return false;
        }
        try {
            statement =  new DbConfig().getConnection().prepareStatement("update  student set name=? ,age=? where id =?");
            statement.setString(1, student.getStudentName());
            statement.setInt(2, student.getAge());
            statement.setInt(3, student.getRoll_no());
            count = statement.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        if (count > 0) {
            return true;
        }
        return false;
    }//method end
}
