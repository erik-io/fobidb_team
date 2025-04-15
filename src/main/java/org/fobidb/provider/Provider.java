package org.fobidb.provider;

import jakarta.persistence.*;

@Entity
//@Table

public class Provider {

//    @GeneratedValue(
//            strategy = GenerationType.IDENTITY
//    )
    @Id
    public int id;

    @Column(length = 255)
    public String name;


    public Provider() {
    }

    public Provider(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Provider(String name) {
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
        return "Provider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
