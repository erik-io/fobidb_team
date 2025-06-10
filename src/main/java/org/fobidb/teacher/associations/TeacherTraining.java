package org.fobidb.teacher.associations;

import jakarta.persistence.*;
import org.fobidb.teacher.ids.TeacherTrainingId;
import org.fobidb.teacher.Teacher;
import org.fobidb.training.Training;

import java.util.Objects;

/**
 * Repräsentiert die Zuordnung zwischen einem Lehrer und dem Training.
 */
@Entity
@Table(name = "teacher_training") // Name der Join-Tabelle in der Datenbank
public class TeacherTraining {

    //Zusammengesetzter Primärschlüssel bestehend aus Teacher-ID und Training-ID
    @EmbeddedId
    private TeacherTrainingId id;

    //Verknüpfung zur Teacher-Entität
    @ManyToOne
    @MapsId("teacherId")    // Die Annotation @MapsId verknüpft dieses Feld mit dem entsprechenden Teil im zusammengesetzten Schlüssel
    @JoinColumn(name = "teacher_id")    // Name der Spalte in der Join-Tabelle
    private Teacher teacher;

    //Verknüpfung zur Teacher-Entität
    @ManyToOne
    @MapsId("trainingId")   // Auch hier wird @MapsId verwendet, um die Kopplung zum zusammengesetzten Schlüssel herzustellen
    @JoinColumn(name = "training_id")   // Name der Spalte in der Join-Tabelle
    private Training training;

    private int rating;
    private boolean isContact;
    private boolean canPresent;
    private boolean offersMicroTraining;

    // Standartstruktur (wird con JPA verwendet)
    public TeacherTraining() {
    }

    // Konstruktor zur Initialisieren aller Felder
    public TeacherTraining(Teacher teacher, Training training, int rating, boolean isContact, boolean canPresent, boolean offersMicroTraining) {
        this.teacher = teacher;
        this.training = training;
        this.id = new TeacherTrainingId(teacher.getId(), training.getId());
        this.rating = rating;
        this.isContact = isContact;
        this.canPresent = canPresent;
        this.offersMicroTraining = offersMicroTraining;
    }

    // Getter und Setter
    public TeacherTrainingId getId() {
        return id;
    }

    public void setId(TeacherTrainingId id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isContact() {
        return isContact;
    }

    public void setContact(boolean contact) {
        isContact = contact;
    }

    public boolean isCanPresent() {
        return canPresent;
    }

    public void setCanPresent(boolean canPresent) {
        this.canPresent = canPresent;
    }

    public boolean isOffersMicroTraining() {
        return offersMicroTraining;
    }

    public void setOffersMicroTraining(boolean offersMicroTraining) {
        this.offersMicroTraining = offersMicroTraining;
    }

    // String-Darstellung der Zuordung
    @Override
    public String toString() {
        return "TeacherTraining{" +
                "teacher=" + teacher.getId() +
                ", training=" + training.getId() +
                ", rating=" + rating +
                ", isContact=" + isContact +
                ", canPresent=" + canPresent +
                ", offersMicroTraining=" + offersMicroTraining +
                '}';
    }
}