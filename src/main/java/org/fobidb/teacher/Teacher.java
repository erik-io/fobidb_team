package org.fobidb.teacher;

import jakarta.persistence.*;
import org.fobidb.teacher.associations.TeacherSubjectArea;
import org.fobidb.teacher.associations.TeacherTraining;

import java.util.Set;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 100)
    private String surname;

    @Column(length = 100)
    private String name;

    @Column(length = 10)
    private String nameShort;

    @Column(length = 255)
    private String email;

    private int trainingTime;

    @OneToMany(mappedBy = "teacher")
    private Set<TeacherTraining> trainings;

    @OneToMany(mappedBy = "teacher")
    private Set<TeacherSubjectArea> subject_areas;

    public Teacher() {
    }

    public Teacher(int id, String surname, String name, String nameShort, String email, int trainingTime) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.nameShort = nameShort;
        this.email = email;
        this.trainingTime = trainingTime;
    }

    public Teacher(String surname, String name, String nameShort, String email, int trainingTime) {
        this.surname = surname;
        this.name = name;
        this.nameShort = nameShort;
        this.email = email;
        this.trainingTime = trainingTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String name_short) {
        this.nameShort = name_short;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(int training_time) {
        this.trainingTime = training_time;
    }

    public Set<TeacherTraining> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<TeacherTraining> trainings) {
        this.trainings = trainings;
    }

    public Set<TeacherSubjectArea> getSubject_areas() {
        return subject_areas;
    }

    public void setSubject_areas(Set<TeacherSubjectArea> subject_areas) {
        this.subject_areas = subject_areas;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", name_short='" + nameShort + '\'' +
                ", email='" + email + '\'' +
                ", training_time=" + trainingTime +
                '}';
    }
}
