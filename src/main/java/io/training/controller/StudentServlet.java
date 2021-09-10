package io.training.controller;

import io.training.dao.StudentDao;
import io.training.model.Student;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(
//    name = "StudentServlet",
//    value = "/StudentServlet",
//    urlPatterns = {"/student-list"},
//    initParams =
//    {
//        @WebInitParam(name = "saveDir", value = "D:/FileUpload"),
//        @WebInitParam(name = "allowedTypes", value = "jpg,jpeg,gif,png")
//    })
public class StudentServlet extends HttpServlet {
  @Inject private StudentDao studentDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    System.out.println("======================"+config.getInitParameter("myprop"));
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    List<Student> allStudents = studentDao.getAllStudent();
    response.getWriter().println(allStudents);
    response.getWriter().println(request.getServletContext().getInitParameter("Greetings"));
    response.getWriter().close();

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}
}
