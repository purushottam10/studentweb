package com.dz.servlet;

import com.dz.dao.StudentDao;
import com.dz.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.log4j.Logger;

@WebServlet(name = "EditStudentServlet",urlPatterns = "/EditStudent")
public class EditStudentServlet extends HttpServlet {
    private Student student;
    private StudentDao studentDao;
    private static Logger log = Logger.getLogger(OperationsServlet.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }//method end

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String age=request.getParameter("age");
        student=new Student();
        studentDao=new StudentDao();
        student.setRoll_no(Integer.parseInt(id));
        student.setStudentName(name);
        student.setAge(Integer.parseInt(age));
        boolean status=studentDao.updateById(student);
        log.trace("calling the update function");
        if(status){
            request.setAttribute("message","Data  update in database ");
        RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/updatemessage.jsp");
        requestDispatcher.forward(request,response);}
        else{
            request.setAttribute("message","Data not matched in database ");
            RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/updatemessage.jsp");
            requestDispatcher.forward(request,response);
        }

    }
}
