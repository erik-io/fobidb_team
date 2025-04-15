package org.fobidb.training;

import jakarta.persistence.*;
import org.fobidb.provider.Provider;

import java.util.Date;

@Entity
//@Table
public class Training {
//    @GeneratedValue(
//            strategy = GenerationType.IDENTITY
//    )
    @Id
    public int id;

    @Column(length = 255)
    public String title;

    @Temporal(TemporalType.DATE)
    public Date date;

    public int duration;

    @Column(length = 255)
    public String location;


    @ManyToOne
    @JoinColumn(name = "provider_id")
    public Provider provider;


    public Training() {
    }

    public Training(int id, String title, Date date, int duration, String location, Provider provider) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.duration = duration;
        this.location = location;
        this.provider = provider;
    }

    public Training(String title, Date date, int duration, String location, Provider provider) {
        this.title = title;
        this.date = date;
        this.duration = duration;
        this.location = location;
        this.provider = provider;
    }

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