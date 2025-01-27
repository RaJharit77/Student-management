package test.java;

import model.Group;
import model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.GroupServices;
import services.StudentServices;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GroupStudentTest {

    private GroupServices groupServices;
    private StudentServices studentServices;

    @BeforeEach
    void setUp() {
        groupServices = new GroupServices();
        studentServices = new StudentServices();
    }

    @Test
    void testGroupCRUD() throws SQLException {
        // Create
        Group group = new Group(1, "Group A", "2023", "Promo 2023", 30, new ArrayList<>());
        groupServices.createGroup(group);

        // Read
        List<Group> groups = groupServices.getAllGroups();
        assertNotNull(groups);
        assertFalse(groups.isEmpty());
        Group foundGroup = groups.stream().filter(g -> g.getId() == 1).findFirst().orElse(null);
        assertNotNull(foundGroup);
        assertEquals("Group A", foundGroup.getGroupName());

        // Update
        group.setGroupName("Group B");
        groupServices.updateGroup(group);
        groups = groupServices.getAllGroups();
        foundGroup = groups.stream().filter(g -> g.getId() == 1).findFirst().orElse(null);
        assertNotNull(foundGroup);
        assertEquals("Group B", foundGroup.getGroupName());

        // Delete
        groupServices.deleteGroup("1");
        groups = groupServices.getAllGroups();
        foundGroup = groups.stream().filter(g -> g.getId() == 1).findFirst().orElse(null);
        assertNull(foundGroup);
    }

    @Test
    void testStudentCRUD() throws SQLException {
        // Create Group
        Group group = new Group(2, "Group C", "2023", "Promo 2023", 25, new ArrayList<>());
        groupServices.createGroup(group);

        // Create Student
        Student student = new Student("S1", "John Doe", "Male", new Date(System.currentTimeMillis()), "REF123", group);
        studentServices.createStudent(student);

        // Read
        List<Student> students = studentServices.getAllStudents();
        assertNotNull(students);
        assertFalse(students.isEmpty());
        Student foundStudent = students.stream().filter(s -> s.getId().equals("S1")).findFirst().orElse(null);
        assertNotNull(foundStudent);
        assertEquals("John Doe", foundStudent.getName());

        // Update
        student.setName("Jane Doe");
        studentServices.updateStudent(student);
        students = studentServices.getAllStudents();
        foundStudent = students.stream().filter(s -> s.getId().equals("S1")).findFirst().orElse(null);
        assertNotNull(foundStudent);
        assertEquals("Jane Doe", foundStudent.getName());

        // Delete
        studentServices.deleteStudent("S1");
        students = studentServices.getAllStudents();
        foundStudent = students.stream().filter(s -> s.getId().equals("S1")).findFirst().orElse(null);
        assertNull(foundStudent);

        // Cleanup
        groupServices.deleteGroup("2");
    }
}