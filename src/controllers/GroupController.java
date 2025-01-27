package controllers;

import model.Group;
import services.GroupServices;

import java.sql.SQLException;
import java.util.List;

public class GroupController {
    private final GroupServices groupServices = new GroupServices();

    public List<Group> getAllGroups() {
        try {
            return groupServices.getAllGroups();
        } catch (SQLException e) {
            System.err.println("Error fetching groups: " + e.getMessage());
            return null;
        }
    }

    public void createGroup(Group group) {
        try {
            groupServices.createGroup(group);
        } catch (SQLException e) {
            System.err.println("Error creating group: " + e.getMessage());
        }
    }

    public void updateGroup(Group group) {
        try {
            groupServices.updateGroup(group);
        } catch (SQLException e) {
            System.err.println("Error updating group: " + e.getMessage());
        }
    }

    public void deleteGroup(String id) {
        try {
            groupServices.deleteGroup(id);
        } catch (SQLException e) {
            System.err.println("Error deleting group: " + e.getMessage());
        }
    }
}

