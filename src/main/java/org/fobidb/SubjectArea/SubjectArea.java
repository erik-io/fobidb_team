package org.fobidb.SubjectArea;

import jakarta.persistence.*;
/**
 * Die Klasse SubjectArea repräsentiert eine Entität, die als Tabelle in der Datenbank gespeichert werden kann.
 * Sie enthält grundlegende Informationen über den Fachbereich, wie eine eindeutige ID und einen Namen.
 * <p>
 * Die Klasse verwendet JPA-Annotationen, um die Verbindung zu einer Datenbank zu definieren.
 * Die ID wird automatisch generiert und dient als Primärschlüssel für die Entität.
 */
@Entity
// Diese Annotation kennzeichnet die Provider-Klasse als eine JPA-Entität. Das bedeutet, dass Instanzen dieser Klasse in einer Datenbanktabelle gespeichert werden können.
@Table
// Diese Annotation ist optional. Mit @Table kann man explizit den Tabellennamen festlegen
public class SubjectArea {
    @Id
    // Die Annotation kennzeichnet das id-Feld als den Primärschlüssel der Entität.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Diese Annotation gibt an, dass der Wert des Primärschlüssels (id) automatisch von der Datenbank generiert wird.
    private Long id; // Long ist der Standard-Datentyp für IDs in Spring Data JPA
    private String name;


    public SubjectArea() { // Parameterloser Konstruktor, für JPA notwendig, damit es die Entitäten instanziieren kann.
    }

    public SubjectArea(String name) {
        this.name = name;
    }

    public SubjectArea(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
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