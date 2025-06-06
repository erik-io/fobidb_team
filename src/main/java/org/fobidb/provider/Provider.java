package org.fobidb.provider;

import jakarta.persistence.*;

/**
 * Diese Klasse repräsentiert einen Anbieter (Provider) für Trainings.
 */
@Entity
@Table(name = "provider") // Optional, nur nötig, wenn Tabellenname explizit sein soll
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String name;

    // Standardkonstruktor für JPA
    public Provider() {
    }

    // Konstruktor mit ID (z. B. für Testdaten oder DTO-Zwecke)
    public Provider(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Konstruktor ohne ID – für neue Objekte
    public Provider(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
