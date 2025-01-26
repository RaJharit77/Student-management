package prog3.management.course.controllers;

import prog3.management.course.model.Student;
import prog3.management.course.services.StudentServices;

import java.sql.SQLException;
import java.util.List;

public class StudentController {
    private final StudentServices studentServices = new StudentServices();

    public List<Student> getAllStudents() {
        try {
            return studentServices.getAllGroups();
        } catch (SQLException e) {
            System.err.println("Error fetching students: " + e.getMessage());
            return null;
        }
    }

    public void createStudent(Student student) {
        try {
            studentServices.createStudent(student);
        } catch (SQLException e) {
            System.err.println("Error creating student: " + e.getMessage());
        }
    }

    public void updateStudent(Student student) {
        try {
            studentServices.updateGroup(student);
        } catch (SQLException e) {
            System.err.println("Error updating student: " + e.getMessage());
        }
    }

    public void deleteStudent(String id) {
        try {
            studentServices.deleteGroup(id);
        } catch (SQLException e) {
            System.err.println("Error deleting student: " + e.getMessage());
        }
    }
}
