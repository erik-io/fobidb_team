package org.fobidb.teacher.ids;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class TeacherSubjectAreaId implements Serializable {

    private Long teacherId;
    private Long subjectAreaId;

    public TeacherSubjectAreaId() {}

    public TeacherSubjectAreaId(Long teacherId, Long subjectAreaId) {
        this.teacherId = teacherId;
        this.subjectAreaId = subjectAreaId;
    }

    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }

    public Long getSubjectAreaId() { return subjectAreaId; }
    public void setSubjectAreaId(Long subjectAreaId) { this.subjectAreaId = subjectAreaId; }

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
