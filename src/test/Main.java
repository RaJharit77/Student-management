package test;

import model.Group;
import controllers.GroupController;
import controllers.StudentController;
import model.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GroupController groupController = new GroupController();
        StudentController studentController = new StudentController();

        List<Student> students = new ArrayList<>();
        Group group = new Group(1, "Group J2", "2023", "Promotion 3", 50, students);
        groupController.createGroup(group);

        List<Group> groups = groupController.getAllGroups();
        if (groups != null) {
            groups.forEach(g -> System.out.println("Group: " + g.getGroupName()));
        }

        Student student = new Student("STD001", "John Doe", "Male", new Date(), "STD25001", group);
        studentController.createStudent(student);

        List<Student> studentsList = studentController.getAllStudents();
        if (studentsList != null) {
            studentsList.forEach(s -> System.out.println("Student: " + s.getName()));
        }
    }
}
