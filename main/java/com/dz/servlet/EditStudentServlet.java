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


    private static Logger log = Logger.getLogger(OperationsServlet.class.getName());


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean status = false;
        int id = 0;
        Student student = new Student();
        StudentDao studentDao = new StudentDao();
        response.setContentType("text/plain");
        try {
            String name = request.getParameter("studentName");
            String age = request.getParameter("age");
            id = Integer.parseInt(request.getParameter("id"));
            log.info(" Data from                ajax   id  " + id + "   name  " + name + "  age  " + age);
            student.setRoll_no(id);
            log.info(student.getRoll_no() + "this is edit servlet");
            student.setStudentName(name);
            log.info(student.getStudentName() + "       edit from data ");
            student.setAge(Integer.parseInt(age));
            log.info(" set the age of  student model " + student.getAge()); // age zero set ho raha hai ? and database me uppadte bhi nhi kra rha

            status = studentDao.updateById(student);

            log.info("calling the update method ");
        } catch (NumberFormatException e) {
            request.setAttribute("message", "Incorrect data. Please recheck your input and try again");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewstudent.jsp");
            rd.forward(request, response);
            log.warning("" + e);
        }


        if (status) {
            request.setAttribute("message", "Data  update in database ");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewstudent.jsp");
            rd.forward(request, response);
        } else {

            request.setAttribute("message", "Data not matched in database ");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewstudent.jsp");
            rd.forward(request, response);
        }
    }//method end

}
