package org.fobidb.teacher.ids;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Diese Klasse repräsentiert den zusammengesetzten Primärschlüssel für die Entität "TeacherTraining".
 * Sie wird als eingebetteter Schlüssel (Embeddable) verwendet.
 */
@Embeddable  // Macht die Klasse als eingebetteten Schlüssel nutzbar (für zusammengesetzte IDs)
public class TeacherTrainingId implements Serializable {

    // Fremdschlüsselreferenz zur Teacher-Entität
    private Long teacherId;

    // Fremdschlüsselreferenz zur Training-Entität
    private int trainingId;

    // Standardkonstruktor (wird von JPA benötigt)
    public TeacherTrainingId() {}

    // Konstruktor zur Initialisierung beider Schlüsselwerte
    public TeacherTrainingId(Long teacherId, int trainingId) {
        this.teacherId = teacherId;
        this.trainingId = trainingId;
    }

    // Getter und Setter
    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }

    public int getTrainingId() { return trainingId; }
    public void setTrainingId(int trainingId) { this.trainingId = trainingId; }

    /**
     * Zwei Schlüssel gelten als gleich, wenn beide Komponenten (teacherId und trainingId) gleich sind.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // gleiche Referenz
        if (!(o instanceof TeacherTrainingId)) return false;  // anderer Typ -> nicht gleich
        TeacherTrainingId that = (TeacherTrainingId) o;
        return teacherId == that.teacherId && trainingId == that.trainingId;
    }

    /**
     * Hashcode auf Basis beider Schlüssel-Felder – notwendig für den Einsatz in Hash-basierten Collections.
     */
    @Override
    public int hashCode() {
        return Objects.hash(teacherId, trainingId);
    }
}
