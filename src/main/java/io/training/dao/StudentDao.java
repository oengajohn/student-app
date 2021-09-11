package io.training.dao;

import io.training.model.Student;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;

public class StudentDao {
  List<Student> studentList = new ArrayList<>();

  @PostConstruct
  public void setupStudents() {
    System.out.println("Initializing our students");
    studentList.add(new Student(1, "001", "Nancy", LocalDate.of(2021, Month.JUNE, 1)));
    studentList.add(new Student(2, "002", "Kevin", LocalDate.of(2021, Month.JUNE, 1)));
    studentList.add(new Student(3, "003", "Victor", LocalDate.of(2021, Month.JUNE, 1)));
    studentList.add(new Student(4, "004", "RoseAnn", LocalDate.of(2021, Month.JUNE, 1)));
  }

  public void createStudent(Student student) {
    studentList.add(student);


  }

  public Student getStudentWithGivenStudentId(long studentId) {
    Optional<Student> any = studentList.stream()
        .filter(student -> student.getStudentId() == studentId)
        .findAny();
    return any.orElse(null);

  }

  public Student getStudentWithGivenRegNo(String regNo) {
    Optional<Student> any = studentList.stream()
        .filter(student -> student.getRegNo() .equals(regNo))
        .findAny();
    return any.orElse(null);
  }

  public List<Student> getAllStudent() {
    return studentList;
  }

  public void deleteStudent(long studentId) {
    studentList.removeIf(student -> student.getStudentId()==studentId);
  }
}
