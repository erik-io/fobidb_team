package org.fobidb.teacher.ids;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Diese Klasse repräsentiert den zusammengesetzten Primärschlüssel für die Entität "TeacherSubjectArea".
 * Sie wird als eingebetteter Schlüssel (Embeddable) verwendet.
 */
@Embeddable // Macht die Klasse als eingebetteten Schlüssel nutzbar (für zusammengesetzte IDs)
public class TeacherSubjectAreaId implements Serializable {

    // Fremdschlüsselreferenz zur Teacher-Entität
    private Long teacherId;

    // Fremdschlüsselreferenz zur Subjectarea-Entität
    private Long subjectAreaId;

    // Standardkonstruktor (wird von JPA benötigt)
    public TeacherSubjectAreaId() {}

    // Konstruktor zur Initialisierung beider Schlüsselwerte
    public TeacherSubjectAreaId(Long teacherId, Long subjectAreaId) {
        this.teacherId = teacherId;
        this.subjectAreaId = subjectAreaId;
    }

    // Getter und Setter
    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }

    public Long getSubjectAreaId() { return subjectAreaId; }
    public void setSubjectAreaId(Long subjectAreaId) { this.subjectAreaId = subjectAreaId; }

    /**
     * Zwei Schlüssel gelten als gleich, wenn beide Komponenten (teacherId und subjectareaId) gleich sind.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherSubjectAreaId)) return false;
        TeacherSubjectAreaId that = (TeacherSubjectAreaId) o;
        return teacherId == that.teacherId && subjectAreaId == that.subjectAreaId;
    }

    /**
     * Hashcode auf Basis beider Schlüssel-Felder – notwendig für den Einsatz in Hash-basierten Collections.
     */
    @Override
    public int hashCode() {
        return Objects.hash(teacherId, subjectAreaId);
    }
}
