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

@WebServlet(name = "ViewStudent", urlPatterns = "/ViewStudent")
public class ViewStudentServlet extends HttpServlet {

    private static Logger log = Logger.getLogger(ViewStudentServlet.class);

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        log.trace("in do post  method  of View Student Servlet write ");


        StudentDao studentDao = new StudentDao();
        List<Student> studentList = studentDao.display();
        try {
            if (request.getParameter("add").equals(null)) {
                request.setAttribute("studentList", studentList);// set Attribute

                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/viewstudent.jsp");
                requestDispatcher.forward(request, response);
            }
                log.info("servlet pass the value ");
                if (request.getParameter("add").equals("add")) {
                    RequestDispatcher requestDispatcher1 = getServletContext().getRequestDispatcher("/addstudent.jsp");
                    requestDispatcher1.forward(request, response);

                }

        } catch (NullPointerException e) {
            log.error(e.getMessage(), e);
            RequestDispatcher requestDispatcher1 = getServletContext().getRequestDispatcher("/index.jsp");
            requestDispatcher1.forward(request, response);
        }




    }//method end

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StudentDao studentDao = new StudentDao();
        List<Student> studentList = studentDao.display();


            request.setAttribute("studentList", studentList);// set Attribute

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/viewstudent.jsp");
            requestDispatcher.forward(request, response);



    }
}