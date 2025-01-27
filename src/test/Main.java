package test;

import prog3.management.course.model.Group;
import prog3.management.course.controllers.GroupController;
import prog3.management.course.controllers.StudentController;
import prog3.management.course.model.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GroupController groupController = new GroupController();
        StudentController studentController = new StudentController();

        List<Student> students = new ArrayList<>();
        Group group = new Group("G001", "Group A", "2025", "Promotion 1", 0, students);
        groupController.createGroup(group);

        List<Group> groups = groupController.getAllGroups();
        if (groups != null) {
            groups.forEach(g -> System.out.println("Group: " + g.getGroupName()));
        }

        Student student = new Student("S001", "John Doe", "Male", new Date(), "REF001", group);
        studentController.createStudent(student);

        List<Student> studentsList = studentController.getAllStudents();
        if (studentsList != null) {
            studentsList.forEach(s -> System.out.println("Student: " + s.getName()));
        }
    }
}
