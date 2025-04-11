package org.fobidb.subject_area;

import jakarta.persistence.*;

@Entity
@Table
public class Subject_Area {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    public int id;
    public String name;

    public Subject_Area() {
    }

    public Subject_Area(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Subject_Area(String name) {
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

    @java.lang.Override
    public java.lang.String toString() {
        return "Subject_Area{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}