package org.fobidb.training;

import jakarta.persistence.*;

@Entity
@Table
public class Training {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    public int id;
    public int provider_id;
    public String title;
    public Date date;
    public int duration;
    public String location;

    public Training() {
    }

    public Training(int id, String location, int provider_id, Date date, String title, int duration) {
        this.id = id;
        this.location = location;
        this.provider_id = provider_id;
        this.date = date;
        this.title = title;
        this.duration = duration;
    }

    public Training(int provider_id, String title, int duration, Date date, String location) {
        this.provider_id = provider_id;
        this.title = title;
        this.duration = duration;
        this.date = date;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getLocation() {
        return location;
    }

    public void setLocation(java.lang.String location) {
        this.location = location;
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

    public java.lang.String getTitle() {
        return title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Training{" +
                "id=" + id +
                ", provider_id=" + provider_id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", duration=" + duration +
                ", location='" + location + '\'' +
                '}';
    }
}