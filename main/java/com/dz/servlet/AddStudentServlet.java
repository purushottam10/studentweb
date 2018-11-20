package com.dz.servlet;

import com.dz.dao.StudentDao;
import com.dz.model.Student;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * this class add the student record in data base
 * use doget method

 */
@WebServlet(name = "AddStudentServlet",urlPatterns = "/AddStudent")
public class AddStudentServlet extends HttpServlet {

     private static Logger log =Logger.getLogger(AddStudentServlet.class);

     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           ///String roll_no=request.getParameter("id");

    }//method end

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String age=request.getParameter("age");
        Student student=new Student();
        StudentDao studentDao=new StudentDao();

        student.setRoll_no((studentDao.setId()));

        student.setStudentName(name);
        try{
            student.setAge(Integer.parseInt(age));
        }catch (NumberFormatException e) {
            log.error(e);
        }

       boolean status=studentDao.addstudent(student);
        log.trace(student.getRoll_no()+"  "+name+" "+age);
        if(status) {
            request.setAttribute("message", "Data  added in database ");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");

            requestDispatcher.forward(request, response);
        }
        else {
            request.setAttribute("message", "Data  not save in database ");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");

            requestDispatcher.forward(request, response);
        }
    }//method end
}
//class end