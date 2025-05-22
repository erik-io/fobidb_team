package org.fobidb.teacher.associations;

import jakarta.persistence.*;
import org.fobidb.teacher.ids.TeacherTrainingId;
import org.fobidb.teacher.Teacher;
import org.fobidb.training.Training;

@Entity
public class TeacherTraining {


    @EmbeddedId
    private TeacherTrainingId id;

    @ManyToOne
    @MapsId("teacherId")
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @MapsId("trainingId")
    @JoinColumn(name = "training_id")
    private Training training;

    private int rating;
    private boolean isContact;
    private boolean canPresent;
    private boolean offersMicroTraining;

    public TeacherTraining() {}

    public TeacherTraining(Teacher teacher, Training training, int rating, boolean isContact, boolean canPresent, boolean offersMicroTraining) {
        this.teacher = teacher;
        this.training = training;
        this.id = new TeacherTrainingId(teacher.getId(), training.getId());
        this.rating = rating;
        this.isContact = isContact;
        this.canPresent = canPresent;
        this.offersMicroTraining = offersMicroTraining;
    }

    public TeacherTrainingId getId() { return id; }
    public void setId(TeacherTrainingId id) { this.id = id; }

    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public Training getTraining() { return training; }
    public void setTraining(Training training) { this.training = training; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public boolean isContact() { return isContact; }
    public void setContact(boolean contact) { isContact = contact; }

    public boolean isCanPresent() { return canPresent; }
    public void setCanPresent(boolean canPresent) { this.canPresent = canPresent; }

    public boolean isOffersMicroTraining() { return offersMicroTraining; }
    public void setOffersMicroTraining(boolean offersMicroTraining) { this.offersMicroTraining = offersMicroTraining; }

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
