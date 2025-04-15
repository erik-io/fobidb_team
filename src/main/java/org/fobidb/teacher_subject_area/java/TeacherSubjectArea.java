package org.fobidb.teacher_subject_area;

import jakarta.persistence.*;
import org.fobidb.id.TeacherSubjectAreaId;
import org.fobidb.subject_area.SubjectArea;
import org.fobidb.teacher.Teacher;

@Entity
public class TeacherSubjectArea {

    @EmbeddedId
    private TeacherSubjectAreaId id;

    @ManyToOne
    @MapsId("teacherId")
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @MapsId("subjectAreaId")
    @JoinColumn(name = "subject_area_id")
    private SubjectArea subjectArea;

    public TeacherSubjectArea() {}

    public TeacherSubjectArea(Teacher teacher, SubjectArea subjectArea) {
        this.teacher = teacher;
        this.subjectArea = subjectArea;
        this.id = new TeacherSubjectAreaId(teacher.getId(), subjectArea.getId());
    }

    public TeacherSubjectAreaId getId() { return id; }
    public void setId(TeacherSubjectAreaId id) { this.id = id; }

    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public SubjectArea getSubjectArea() { return subjectArea; }
    public void setSubjectArea(SubjectArea subjectArea) { this.subjectArea = subjectArea; }

    @Override
    public String toString() {
        return "TeacherSubjectArea{teacher=" + teacher.getId() + ", subjectArea=" + subjectArea.getId() + "}";
    }
}
