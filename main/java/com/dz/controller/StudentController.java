package com.dz.controller;

import com.dz.dao.ImpStudentDao;
import com.dz.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class StudentController {



    private ImpStudentDao studentDao;
    @RequestMapping("/first.jsp")
    public ModelAndView welcomeController() {

        List<Student> studentList=studentDao.display();
        for(Student stu:studentList){
            System.out.println(stu.getAge());
        }
        return new ModelAndView("first.jsp","studentList",studentList);
    }//method end
}