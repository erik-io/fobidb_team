package org.fobidb.teacher;

import jakarta.persistence.*;
import org.fobidb.teacher.associations.TeacherSubjectArea;
import org.fobidb.teacher.associations.TeacherTraining;

import java.util.Set;

/**
 * Diese Klasse repräsentiert einen Anbieter (Teacher) für Trainings.
 */
@Entity  // Markiert die Klasse als JPA-Entity (Datenbanktabelle)
@Table(name = "teacher") // Optional, falls DB-Tabelle "subject_area" heißen soll
public class Teacher {

    @Id  // Primärschlüssel der Entität
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatische ID-Generierung durch die Datenbank
    private Long id;

    @Column(length = 100)
    private String surname;

    @Column(length = 100)
    private String name;

    @Column(length = 10)
    private String nameShort;

    @Column(length = 255)
    private String email;

    private int trainingTime;

    @OneToMany(mappedBy = "teacher")  // Beziehung zu TeacherTraining, bidirektional
    private Set<TeacherTraining> trainings;

    @OneToMany(mappedBy = "teacher")  // Beziehung zu TeacherSubjectArea, bidirektional
    private Set<TeacherSubjectArea> subjectAreas;

    // Standardkonstruktor (wird von JPA benötigt)
    public Teacher() {
    }

    // Konstruktor mit allen Attributen inkl. ID
    public Teacher(Long id, String surname, String name, String nameShort, String email, int trainingTime) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.nameShort = nameShort;
        this.email = email;
        this.trainingTime = trainingTime;
    }

    // Konstruktor ohne ID
    public Teacher(String surname, String name, String nameShort, String email, int trainingTime) {
        this.surname = surname;
        this.name = name;
        this.nameShort = nameShort;
        this.email = email;
        this.trainingTime = trainingTime;
    }

    // Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
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

    public void setTrainingTime(int trainingTime) {
        this.trainingTime = trainingTime;
    }

    public Set<TeacherTraining> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<TeacherTraining> trainings) {
        this.trainings = trainings;
    }

    public Set<TeacherSubjectArea> getSubjectAreas() {
        return subjectAreas;
    }

    public void setSubjectAreas(Set<TeacherSubjectArea> subjectAreas) {
        this.subjectAreas = subjectAreas;
    }

    //Gibt eine stringbasierte Darstellung des Trainingsobjekts zurück
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", nameShort='" + nameShort + '\'' +
                ", email='" + email + '\'' +
                ", trainingTime=" + trainingTime +
                '}';
    }
}
