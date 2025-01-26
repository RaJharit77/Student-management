package model;

import java.util.*;

public class Group {
    private int id;
    private String groupName;
    private String groupYear;
    private String promotion;
    private int studentNb;
    private List<Student> students;

    public Group(int id, String groupName, String groupYear, String promotion, int studentNb, List<Student> students) {
        this.id = id;
        this.groupName = groupName;
        this.groupYear = groupYear;
        this.promotion = promotion;
        this.studentNb = studentNb;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupYear() {
        return groupYear;
    }

    public void setGroupYear(String groupYear) {
        this.groupYear = groupYear;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public int getStudentNb() {
        return studentNb;
    }

    public void setStudentNb(int studentNb) {
        this.studentNb = studentNb;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupYear='" + groupYear + '\'' +
                ", promotion='" + promotion + '\'' +
                ", studentNb=" + studentNb +
                ", students=" + students +
                '}';
    }
}
