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
import java.util.logging.Logger;


@WebServlet(name = "EditStudentServlet", urlPatterns = "/EditStudent")
public class EditStudentServlet extends HttpServlet {
    private Student student;
    private StudentDao studentDao;
    private static Logger log = Logger.getLogger(OperationsServlet.class.getName());
    private   int id =-2;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean status = false;

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println(name);
        student.setRoll_no(id);
        log.info(student.getRoll_no()+"this is edit servlet ");
        student.setStudentName(name);
        log.info(student.getStudentName()+"       edit from data ");

       try{
           student.setAge(Integer.parseInt(age));

       }catch (NumberFormatException e){
           request.setAttribute("message", "age is not valid   ");
           RequestDispatcher rd = getServletContext().getRequestDispatcher("/updatemessage.jsp");
           rd.forward(request, response);
           log.warning(""+e);
       }
        log.info(student.getAge()+" set the age of  student model ");

        status = studentDao.updateById(student);

        log.info("calling the update function");
        if (status) {
            request.setAttribute("message", "Data  update in database ");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/updatemessage.jsp");
            rd.forward(request, response);
        } else {

            request.setAttribute("message", "Data not matched in database ");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/updatemessage.jsp");
            rd.forward(request, response);
        }
    }//method end

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        student = new Student();
        studentDao = new StudentDao();


            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/editstudent.jsp");
            requestDispatcher.forward(request, response);
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException e) {
                log.warning(e+"");
            }


        log.info(id + "this id passed from view page");


    }

}
