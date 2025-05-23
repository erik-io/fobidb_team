package org.fobidb.provider;

import jakarta.persistence.*;

/**
 * Die Klasse Provider repräsentiert eine Entität, die als Tabelle in der Datenbank gespeichert werden kann.
 * Sie enthält grundlegende Informationen über den Anbieter, wie eine eindeutige ID und einen Namen.
 * <p>
 * Die Klasse verwendet JPA-Annotationen, um die Verbindung zu einer Datenbank zu definieren.
 * Die ID wird automatisch generiert und dient als Primärschlüssel für die Entität.
 */
@Entity
// Diese Annotation kennzeichnet die Provider-Klasse als eine JPA-Entität. Das bedeutet, dass Instanzen dieser Klasse in einer Datenbanktabelle gespeichert werden können.
@Table // Diese Annotation ist optional. Mit @Table kann man explizit den Tabellennamen festlegen
public class Provider {
    @Id // Die Annotation kennzeichnet das id-Feld als den Primärschlüssel der Entität.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Diese Annotation gibt an, dass der Wert des Primärschlüssels (id) automatisch von der Datenbank generiert wird.
    private Long id; // Long ist der Standard-Datentyp für IDs in Spring Data JPA
    private String name;

    public Provider() { // Parameterloser Konstruktor, für JPA notwendig, damit es die Entitäten instanziieren kann.
    }

    public Provider(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gibt eine String-Darstellung des Objekts zurück, die die Werte der Felder `id` und `name`
     * im Format `Provider{id=Wert, name='Wert'}` enthält. Sie ist sehr nützlich für das Debugging.
     *
     * @return die String-Darstellung des Provider-Objekts
     */
    @Override
    // Diese Annotation zeigt an, dass die folgende Methode eine Methode einer übergeordneten Klasse oder eines Interfaces überschreibt.
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
