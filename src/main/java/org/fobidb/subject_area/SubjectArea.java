package org.fobidb.subject_area;

import jakarta.persistence.*;

@Entity
public class SubjectArea {

    @Id
    public int id;

    @Column(length = 100)
    public String name;

    public SubjectArea() {
    }

    public SubjectArea(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public SubjectArea(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject_Area{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}