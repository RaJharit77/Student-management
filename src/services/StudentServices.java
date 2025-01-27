package services;

import model.Student;
import repositories.StudentRepositories;

import java.sql.SQLException;
import java.util.List;

public class StudentServices {
    private final StudentRepositories repository = new StudentRepositories();

    public List<Student> getAllStudents() throws SQLException {
        return repository.getAllStudents();
    }

    public void createStudent(Student student) throws SQLException {
        repository.createStudent(student);
    }

    public void updateStudent(Student student) throws SQLException {
        repository.updateStudent(student);
    }

    public void deleteStudent(String id) throws SQLException {
        repository.deleteStudent(id);
    }
}
