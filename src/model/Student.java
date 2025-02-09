package model;

import java.time.LocalDate;
import java.util.Objects;

public class Student {
    private String id;
    private String name;
    private Sex sex;
    private LocalDate birthdate;
    private String reference;
    private Group group;

    public Student(String id, String name, Sex sex, LocalDate birthdate, String reference, Group group) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthdate = birthdate;
        this.reference = reference;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthdate=" + birthdate +
                ", reference='" + reference + '\'' +
                ", group=" + group +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(sex, student.sex) && Objects.equals(birthdate, student.birthdate) && Objects.equals(reference, student.reference) && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, birthdate, reference, group);
    }
}
