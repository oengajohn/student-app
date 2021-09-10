package io.training.controller;

import io.training.dao.StudentDao;
import io.training.model.Student;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(
    name = "StudentServlet",
    value = "/StudentServlet",
    urlPatterns = {"/student-list"})
public class StudentServlet extends HttpServlet {
  @Inject private StudentDao studentDao;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    List<Student> allStudents = studentDao.getAllStudent();
    PrintWriter writer = response.getWriter();
    System.out.println(allStudents);
    writer.println("Our List");
    for (var st : allStudents) {
      writer.println(st.toString());
    }
    writer.close();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}
}
