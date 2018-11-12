package com.dz.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.log4j.Logger;


@WebServlet(name = "OperationsServlet",urlPatterns ="/OperationsServlet" )
public class OperationsServlet extends HttpServlet {
    private static  Logger log = Logger.getLogger(OperationsServlet.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          AddStudentServlet addStudentServlet=new AddStudentServlet();
          ViewStudentServlet viewStudentServlet=new ViewStudentServlet();
          EditStudentServlet editStudentServlet=new EditStudentServlet();
          DeleteStudentServlet deleteStudentServlet=new DeleteStudentServlet();

          String opp=request.getParameter("Operation");
          log.trace(opp+" Menu me  print ho rha hai add servlet me ");

        if(opp.equals("add")){
            RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/addstudent.jsp");
            requestDispatcher.forward(request,response);
            addStudentServlet.doPost(request, response);
        }
    else   if(opp.equals("view")) {

          RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/viewstudent.jsp");
          requestDispatcher.forward(request,response);
            viewStudentServlet.doPost(request,response);
        }
    else if(opp.equals("edit")){
            RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/editstudent.jsp");
            requestDispatcher.forward(request,response);
            editStudentServlet.doPost(request,response);
        }
        else if(opp.equals("delete")){
            RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/deletestudent.jsp");
            requestDispatcher.forward(request,response);
           deleteStudentServlet.doPost(request,response);
        }
        else {
            RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request,response);

        }
    }//method end

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




       if(request.getParameter("update")!=null){
           RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/addstudent.jsp");
           requestDispatcher.forward(request,response);
       }

       else if(request.getParameter("index")!=null){
            RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request,response);

        }
        else if(request.getParameter("delete")!=null){

           RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/index.jsp");
           requestDispatcher.forward(request,response);
       }
    }//method end
}
