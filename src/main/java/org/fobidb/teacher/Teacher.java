package org.fobidb.teacher;

import jakarta.persistence.*;
import org.fobidb.teacher_subject_area.TeacherSubjectArea;
import org.fobidb.teacher_training.TeacherTraining;

import java.util.Set;

@Entity
public class Teacher {
    @Id
    public int id;

    @Column(length = 100)
    public String surname;

    @Column(length = 100)
    public String name;

    @Column(length = 10)
    public String name_short;

    @Column(length = 255)
    public String email;

    public int training_time;

    @OneToMany(mappedBy = "teacher")
    private Set<TeacherTraining> trainings;

    @OneToMany(mappedBy = "teacher")
    private Set<TeacherSubjectArea> subject_areas;

    public Teacher() {
    }

    public Teacher(int id, String surname, String name, String name_short, String email, int training_time) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.name_short = name_short;
        this.email = email;
        this.training_time = training_time;
    }

    public Teacher(String surname, String name, String name_short, String email, int training_time) {
        this.surname = surname;
        this.name = name;
        this.name_short = name_short;
        this.email = email;
        this.training_time = training_time;
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

    public String getName_short() {
        return name_short;
    }

    public void setName_short(String name_short) {
        this.name_short = name_short;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTraining_time() {
        return training_time;
    }

    public void setTraining_time(int training_time) {
        this.training_time = training_time;
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
                ", name_short='" + name_short + '\'' +
                ", email='" + email + '\'' +
                ", training_time=" + training_time +
                '}';
    }
}
