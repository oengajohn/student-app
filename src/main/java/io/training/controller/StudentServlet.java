package io.training.controller;

import io.training.dao.StudentDao;
import io.training.model.Student;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
    name = "StudentServlet",
    value = "/StudentServlet",
    urlPatterns = {"/student-list","/aging"},
    initParams =
    {
        @WebInitParam(name = "saveDir", value = "D:/FileUpload"),
        @WebInitParam(name = "allowedTypes", value = "jpg,jpeg,gif,png")
    })
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
    HttpSession session = request.getSession(true);
    session.setAttribute("studentList",allStudents);
    request.getRequestDispatcher("/student-list").forward(request,response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    int studentId = Integer.parseInt(request.getParameter("studentId"));
    String name = request.getParameter("name");
    String regNo = request.getParameter("regNo");
    String registrationDate = request.getParameter("registrationDate");
   LocalDate registrationDate2 = LocalDate.parse(registrationDate, DateTimeFormatter.ISO_LOCAL_DATE);
    System.out.println(registrationDate2);
    Student student = new Student(studentId, name, regNo, registrationDate2);
    studentDao.createStudent(student);
    studentDao.getAllStudent().forEach(System.out::println);


  }
}
