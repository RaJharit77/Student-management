package repositories;

import config.DatabaseConnection;
import model.Group;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupRepositories {
    public List<Group> getAllGroups() throws SQLException {
        List<Group> groups = new ArrayList<>();
        String query = "SELECT * FROM groups";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Group group = new Group(
                        rs.getInt("id"),
                        rs.getString("groupName"),
                        rs.getString("groupYear"),
                        rs.getString("promotion"),
                        rs.getInt("studentNb"),
                        new ArrayList<>()
                );
                groups.add(group);
            }
        }
        return groups;
    }

    public void createGroup(Group group) throws SQLException {
        String query = "INSERT INTO groups (id, groupName, groupYear, promotion, studentNb) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, group.getId());
            pstmt.setString(2, group.getGroupName());
            pstmt.setString(3, group.getGroupYear());
            pstmt.setString(4, group.getPromotion());
            pstmt.setInt(5, group.getStudentNb());
            pstmt.executeUpdate();
        }
    }

    public void updateGroup(Group group) throws SQLException {
        String query = "UPDATE groups SET groupName = ?, groupYear = ?, promotion = ?, studentNb = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, group.getGroupName());
            pstmt.setString(2, group.getGroupYear());
            pstmt.setString(3, group.getPromotion());
            pstmt.setInt(4, group.getStudentNb());
            pstmt.setInt(5, group.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteGroup(String id) throws SQLException {
        String query = "DELETE FROM groups WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        }
    }
}
