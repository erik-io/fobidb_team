package org.fobidb.id;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class TeacherSubjectAreaId implements Serializable {

    private int teacherId;
    private int subjectAreaId;

    public TeacherSubjectAreaId() {}

    public TeacherSubjectAreaId(int teacherId, int subjectAreaId) {
        this.teacherId = teacherId;
        this.subjectAreaId = subjectAreaId;
    }

    public int getTeacherId() { return teacherId; }
    public void setTeacherId(int teacherId) { this.teacherId = teacherId; }

    public int getSubjectAreaId() { return subjectAreaId; }
    public void setSubjectAreaId(int subjectAreaId) { this.subjectAreaId = subjectAreaId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherSubjectAreaId)) return false;
        TeacherSubjectAreaId that = (TeacherSubjectAreaId) o;
        return teacherId == that.teacherId && subjectAreaId == that.subjectAreaId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, subjectAreaId);
    }
}
