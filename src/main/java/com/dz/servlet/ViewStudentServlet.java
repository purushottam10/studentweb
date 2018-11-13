package com.dz.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.dz.dao.StudentDao;
import com.dz.model.Student;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;

import java.util.List;

@WebServlet(name = "ViewStudentServlet", urlPatterns = "/ViewStudent")
public class ViewStudentServlet extends HttpServlet {
   private  StudentDao studentDao;
   private static Logger log=Logger.getLogger(ViewStudentServlet.class);
   @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        log.trace("in do post  method  of View Student Servlet write ");

        //System.out.println("welcome to get method ");
        studentDao =new StudentDao();
        List<Student> studentList=studentDao.display();
        if(request.getParameter("show")!=null) {

            request.setAttribute("studentList", studentList);// set Attribute

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/viewstudent.jsp");
            requestDispatcher.forward(request, response);
            log.trace("servlet pass the value ");
        }
        if(request.getParameter("add").equals("add")){

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/addstudent.jsp");
            requestDispatcher.forward(request, response);

        }


    }//method end

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}//class end
