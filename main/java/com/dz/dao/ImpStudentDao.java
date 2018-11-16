package com.dz.dao;

import com.dz.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImpStudentDao implements  StudentDao {
    private Connection connection;
    private Statement statement;
    private ResultSet rs=null;
    private Student student;
    /**
     *
     * @return
     */
    public List<Student> display(){

        List<Student> studentList=new ArrayList<>();
        SqlConnection sqlConnection=new SqlConnection();
        connection=sqlConnection.getSqlConnection();
        try{
            statement= connection.createStatement();
            rs=statement.executeQuery("select * from student");
            while (rs.next())  {
                student =new Student();
                student.setRoll_no(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setAge(rs.getInt(3));

                studentList.add(student);

            }
            return  studentList;
        }catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return  null;
    }
}
