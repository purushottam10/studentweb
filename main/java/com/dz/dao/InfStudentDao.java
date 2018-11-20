package com.dz.dao;

import com.dz.model.Student;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

public interface InfStudentDao {

    public boolean addstudent(Student student);
    public int setId();
    public List<Student> display();
    public boolean removeById(int id);
    public boolean updateById(Student student ) throws IOException;

}
