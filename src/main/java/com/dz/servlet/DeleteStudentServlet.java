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
import java.util.List;


@WebServlet(name = "DeleteStudentServlet", urlPatterns = "/DeleteStudent")
public class DeleteStudentServlet extends HttpServlet {
    private StudentDao studentDao;
    private Logger log = Logger.getLogger(DeleteStudentServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        studentDao = new StudentDao();
        boolean status = false;

        if (request.getParameter("id") != null) {
            status = studentDao.removeById(Integer.parseInt(request.getParameter("id")));
            if (status) {
                request.setAttribute("message", "Data  removed from  database ");
                List<Student> studentList = studentDao.display();
                request.setAttribute("studentList", studentList);// set Attribute

                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/viewstudent.jsp");
                requestDispatcher.forward(request, response);
            } else {
                request.setAttribute("message", "Data  not found in database ");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/deletemessage.jsp");
                requestDispatcher.forward(request, response);

            }
        }


    }
}
