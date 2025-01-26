package repositories;

import config.DatabaseConnection;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositories {
    private final DatabaseConnection databaseConnection;

    public StudentRepositories(DatabaseConnection dataSource) {
        this.databaseConnection = dataSource;
    }

    public StudentRepositories() {
        this.databaseConnection = new DatabaseConnection();
    }

    public List<Student> getAllGroups() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection conn = databaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Student student = new Student(
                        rs.getString("id_student"),
                        rs.getString("name"),
                        rs.getString("sex"),
                        rs.getDate("birth_date"),
                        rs.getString("reference"),
                        null
                );
                students.add(student);
            }
        }
        return students;
    }

    public void createStudent(Student student) throws SQLException {
        String query = "INSERT INTO students (id_student, name, sex, birth_date, reference, group_name) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getSex());
            pstmt.setDate(4, new java.sql.Date(student.getBirthdate().getTime()));
            pstmt.setString(5, student.getReference());
            pstmt.setString(6, String.valueOf(student.getGroup() != null ? student.getGroup().getId() : null));
            pstmt.executeUpdate();
        }
    }

    public void updateStudent(Student student) throws SQLException {
        String query = "UPDATE students SET name = ?, sex = ?, group_name = ?, reference = ? WHERE id_student = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getSex());
            pstmt.setString(3, String.valueOf(student.getGroup() != null ? student.getGroup().getId() : null));
            pstmt.setString(4, student.getReference());
            pstmt.setString(5, student.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteStudent(String id) throws SQLException {
        String query = "DELETE FROM students WHERE id_student = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        }
    }
}
