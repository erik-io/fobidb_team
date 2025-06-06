package org.fobidb.subjectarea;

import jakarta.persistence.*;

@Entity
@Table(name = "subject_area") // Optional, falls DB-Tabelle "subject_area" heißen soll
public class SubjectArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    public SubjectArea() {
    }

    public SubjectArea(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SubjectArea(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "SubjectArea{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
