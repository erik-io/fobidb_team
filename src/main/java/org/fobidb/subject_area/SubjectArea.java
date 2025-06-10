package org.fobidb.subjectarea;

import jakarta.persistence.*;

/**
 * Diese Klasse repräsentiert einen Anbieter (Subjectarea) für Trainings.
 */
@Entity // Markiert die Klasse als JPA-Entity (Datenbanktabelle)
@Table(name = "subject_area") // Optional, falls DB-Tabelle "subject_area" heißen soll
public class SubjectArea {

    @Id // Primärschlüssel der Entität
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatische ID-Generierung durch die Datenbank
    private Long id;

    @Column(length = 100)
    private String name;

    // Standart Konstruktor (wird von JPA benötigt)
    public SubjectArea() {
    }

    // Konstruktor mit allen Feldern
    public SubjectArea(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Konstruktor ohne ID
    public SubjectArea(String name) {
        this.name = name;
    }

    //Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {  // <-- Kein java.lang.String nötig
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Gibt eine stringbasierte Darstellung des Trainingsobjekts zurück
    @Override
    public String toString() {
        return "SubjectArea{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
