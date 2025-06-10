package org.fobidb.teacher.associations;

import jakarta.persistence.*;
import org.fobidb.teacher.ids.TeacherSubjectAreaId;
import org.fobidb.subjectarea.SubjectArea;
import org.fobidb.teacher.Teacher;

/**
 * Repräsentiert die Zuordnung zwischen einem Lehrer und einem Fachbereich (N:N).
 */
@Entity
@Table(name = "teacher_subject_area") //Name der Join-Tabelle in der Datenbank
public class TeacherSubjectArea {

    // Zusammengesetzter Primärschlüssel, bestehent aus Teacher-ID und Subjectarea-ID
    @EmbeddedId
    private TeacherSubjectAreaId id;

    //Verknüpfung zur Teacher-Entität
    @ManyToOne
    @MapsId("teacherId")    // Die Annotation @MapsId verknüpft dieses Feld mit dem entsprechenden Teil im zusammengesetzten Schlüssel
    @JoinColumn(name = "teacher_id") // Name der Spalte in der Join-Tabelle
    private Teacher teacher;

    //Verknüpfung zur Sinbjectarea-Entität
    @ManyToOne
    @MapsId("subjectAreaId")    // Auch hier wird @MapsId verwendet, um die Kopplung zum zusammengesetzten Schlüssel herzustellen
    @JoinColumn(name = "subject_area_id") // Name der Spalte in der Join-Tabelle
    private SubjectArea subjectArea;

    // Standartstruktur (wird con JPA verwendet)
    public TeacherSubjectArea() {
    }

    /*
        Konstruktor zur Initialisierung mit einem Teacher und einer Subjectarea
        Dabei wird automatisch der zusammengesetzte Schlüssel erstellt
     */
    public TeacherSubjectArea(Teacher teacher, SubjectArea subjectArea) {
        this.teacher = teacher;
        this.subjectArea = subjectArea;
        this.id = new TeacherSubjectAreaId(teacher.getId(), subjectArea.getId());
    }

    // Getter und Setter
    public TeacherSubjectAreaId getId() {
        return id;
    }

    public void setId(TeacherSubjectAreaId id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public SubjectArea getSubjectArea() {
        return subjectArea;
    }

    public void setSubjectArea(SubjectArea subjectArea) {
        this.subjectArea = subjectArea;
    }

    // String-Darstellung der Zuordung
    @Override
    public String toString() {
        return "TeacherSubjectArea{teacher=" + teacher.getId() +
                ", subjectArea=" + subjectArea.getId() + "}";
    }
}