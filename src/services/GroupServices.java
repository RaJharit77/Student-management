package services;

import model.Group;
import repositories.GroupRepositories;

import java.sql.SQLException;
import java.util.List;

public class GroupServices {
    private final GroupRepositories repository = new GroupRepositories();

    public List<Group> getAllGroups() throws SQLException {
        return repository.getAllGroups();
    }

    public void createGroup(Group group) throws SQLException {
        repository.createGroup(group);
    }

    public void updateGroup(Group group) throws SQLException {
        repository.updateGroup(group);
    }

    public void deleteGroup(String id) throws SQLException {
        repository.deleteGroup(id);
    }
}
