package services;

import model.Student;
import repositories.StudentRepositories;

import java.sql.SQLException;
import java.util.List;

public class StudentServices {
    private final StudentRepositories repository = new StudentRepositories();

    public List<Student> getAllGroups() throws SQLException {
        return repository.getAllGroups();
    }

    public void createStudent(Student student) throws SQLException {
        repository.createStudent(student);
    }

    public void updateGroup(Student student) throws SQLException {
        repository.updateStudent(student);
    }

    public void deleteGroup(String id) throws SQLException {
        repository.deleteStudent(id);
    }
}
