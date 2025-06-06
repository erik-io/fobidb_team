package org.fobidb.teacher.ids;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TeacherTrainingId implements Serializable {

    private Long teacherId;
    private int trainingId;

    public TeacherTrainingId() {}

    public TeacherTrainingId(Long teacherId, int trainingId) {
        this.teacherId = teacherId;
        this.trainingId = trainingId;
    }

    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }

    public int getTrainingId() { return trainingId; }
    public void setTrainingId(int trainingId) { this.trainingId = trainingId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherTrainingId)) return false;
        TeacherTrainingId that = (TeacherTrainingId) o;
        return teacherId == that.teacherId && trainingId == that.trainingId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, trainingId);
    }
}
