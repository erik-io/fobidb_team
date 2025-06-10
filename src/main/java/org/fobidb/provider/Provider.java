package org.fobidb.provider;

import jakarta.persistence.*;

/**
 * Diese Klasse repräsentiert einen Anbieter (Provider) für Trainings.
 */
@Entity // Markiert die Klasse als JPA-Entity (Datenbanktabelle)
@Table(name = "provider") // Optional, falls DB-Tabelle "subject_area" heißen soll
public class Provider {

    @Id // Primärschlüssel der Entität
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatisches erstellen der ID durch die Datenbank
    private Long id;

    @Column(length = 255)
    private String name;

    // Standardkonstruktor für JPA
    public Provider() {
    }

    // Konstruktor mit allen Feldern
    public Provider(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Konstruktor ohne ID
    public Provider(String name) {
        this.name = name;
    }

    // Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { // Kürzer schreiben
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Gibt eine stringbasierte Darstellung des Trainingsobjekts zurück
    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
