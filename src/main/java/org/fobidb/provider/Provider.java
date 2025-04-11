package org.fobidb.provider;

import jakarta.persistence.*;

@Entity
@Table

public class provider{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    public int id;
    public String name;

    public provider() {
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

    @java.lang.Override
    public java.lang.String toString() {
        return "Provider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
