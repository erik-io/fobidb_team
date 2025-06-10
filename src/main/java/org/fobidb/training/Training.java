package org.fobidb.training;

import jakarta.persistence.*;
import org.fobidb.provider.Provider;

import java.util.Date;

/**
 * Diese Klasse repräsentiert einen Anbieter (Training) für Trainings.
 */
@Entity // Markiert die Klasse als JPA-Entity (Datenbanktabelle)
@Table(name = "Training") // Optional, falls DB-Tabelle "subject_area" heißen soll
public class Training {

    @Id // Primärschlüssel der Entität
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatische ID-Generierung durch die Datenbank
    private int id;

    @Column(length = 255)
    private String title;

    @Temporal(TemporalType.DATE)
    private Date date;

    private int duration;

    @Column(length = 255)
    private String location;

    // Verknüpfung zum Provider
    @ManyToOne
    @JoinColumn(name = "provider_id") // Fremdschlüssel in der Datenbank
    private Provider provider;

    // Standardkonstruktor (wird von JPA benötigt)
    public Training() {
    }

    // Konstruktor mit allen Feldern
    public Training(int id, String title, Date date, int duration, String location, Provider provider) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.duration = duration;
        this.location = location;
        this.provider = provider;
    }

    // Konstruktor ohne ID
    public Training(String title, Date date, int duration, String location, Provider provider) {
        this.title = title;
        this.date = date;
        this.duration = duration;
        this.location = location;
        this.provider = provider;
    }

    // Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    //Gibt eine stringbasierte Darstellung des Trainingsobjekts zurück
    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", duration=" + duration +
                ", location='" + location + '\'' +
                ", provider=" + provider +
                '}';
    }

}