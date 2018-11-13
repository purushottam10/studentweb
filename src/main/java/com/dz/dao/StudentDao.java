package com.dz.dao;


import com.dz.model.Student;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDao implements InfStudentDao {

    private DbConfig dbConfig;
    private PreparedStatement statement = null;

    private static Logger log = Logger.getLogger(StudentDao.class.getName());
    public boolean addstudent(Student student) {

        dbConfig = new DbConfig();
        Connection connection = dbConfig.getConnection();

      log.info(" in add dao");

        int count;

        if (student.getAge() == 0) {
            return false;
        }

        try {
            statement = connection.prepareStatement("insert into student (id ,name,age)values (?,?,?)");

            statement.setInt(1, student.getRoll_no());
            statement.setString(2, student.getStudentName());
            statement.setInt(3, student.getAge());
            count = statement.executeUpdate();
            // System.out.println("data inserted successfully");
            if (count > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    /*   finally {
            connection.close();
        }*/

        return false;

    }//method end

    /**
     * @return roll_no
     */
    public int setId() {
        dbConfig = new DbConfig();
        Connection connection = dbConfig.getConnection();
       log.info("in operation");
        try {

            statement = connection.prepareStatement("select Max(id) from student");
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
              log.info(1);
                return rs.getInt(1) + 1;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Display record
     */
    public List<Student> display() {
        dbConfig = new DbConfig();
        Connection connection = dbConfig.getConnection();
        Student student;
        List<Student> studentList = new ArrayList<>();
        try {
            statement = connection.prepareStatement("select * from student");
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
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param id
     * @return
     */

    public boolean removeById(int id) {
        // TODO Auto-generated method stub
        int count = 0;
        dbConfig = new DbConfig();
        Connection connection = dbConfig.getConnection();
        try {
            statement = connection.prepareStatement("delete from  student  where id= ?");
            statement.setInt(1, id);
            count = statement.executeUpdate();

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("problem");
            e.printStackTrace();

        }
        if (count > 0) {
            return true;
        }

        return false;
    }//method end

    /**
     * @param student
     * @return
     * @throws IOException
     */
    public boolean updateById(Student student) throws IOException {
        // TODO Auto-generated method stub
        dbConfig = new DbConfig();
        Connection connection = dbConfig.getConnection();
        int count = 0;
        log.info("print in update method ");
      //  System.out.println(student.getRoll_no()+"inside update method");
        if (student.getAge() == 0 || student.getStudentName().equals(null)) {
            return false;
        }
        try {

            statement = connection.prepareStatement("update  student set name=? ,age=? where id =?");

            statement.setString(1, student.getStudentName());
            statement.setInt(2, student.getAge());
            statement.setInt(3, student.getRoll_no());
            count = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (count > 0) {
            return true;
        }
        return false;
    }//method end
}
