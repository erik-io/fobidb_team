package org.fobidb.SubjectArea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Die Klasse SubjectAreaController stellt die API-Endpunkte für die Verwaltung von Fachbereichen bereit.
 * Sie ist mit der Annotation @RestController versehen, um anzuzeigen, dass sie eine RESTful Webservice-Komponente ist.
 * <p>
 * Der Basis-Pfad für alle Endpunkte in dieser Klasse ist "api/v1/subjectArea",
 * wie durch die Annotation @RequestMapping definiert.
 * <p>
 * Typische Aufgaben und Verantwortlichkeiten dieser Klasse:
 * - Handhaben von HTTP-Anfragen wie GET, POST, PUT und DELETE.
 * - Kommunizieren mit der Geschäftslogik, die in der SubjectAreaService-Klasse implementiert ist.
 * - Rückgabe von Antworten an die Clients im JSON-Format.
 * <p>
 * Durch die Nutzung von Spring Boot und dessen REST-Controller-Mechanismen wird diese Klasse
 * automatisch als REST-Endpunkt registriert und ist nach dem Start der Anwendung verfügbar.
 */

@RestController // Definiert diese Klasse als REST-Controller
@RequestMapping(path = "api/v1/subjectArea") // Basis-URL-Pfad für alle Anfragen an diesen Controller
public class SubjectAreaController {
    private final SubjectAreaService subjectAreaService;

    @Autowired
    public SubjectAreaController(SubjectAreaService subjectAreaService) {
        this.subjectAreaService = subjectAreaService;
    }
    /**
     * Behandelt GET-Anfragen an /api/v1/provider.
     * Ruft alle Anbieter ab.
     *
     * @return eine Liste von {@code Provider}-Objekten, die alle Anbieter repräsentieren
     */
    @GetMapping
    public List<SubjectArea> getSubjectAreas() {
        return subjectAreaService.getSubjectAreas();
    }

    /**
     * Behandelt POST-Anfragen an /api/v1/subjectArea.
     * Der neue Fachbereich wird an den entsprechenden Service weitergeleitet,
     * um in der Datenbank gespeichert zu werden.
     *
     * @param subjectArea Das {@code SubjectArea}-Objekt, das die Details des neuen Fachbereichs enthält
     */
    @PostMapping
    public void addNewSubjectArea(@RequestBody SubjectArea subjectArea) {// @RequestBody weist Spring an, den Inhalt (Body) der HTTP POST-Anfrage zu nehmen und ihn automatisch in ein SubjectArea-Objekt umzuwandeln
        subjectAreaService.addNewSubjectArea(subjectArea);
    }

    /**
     * Behandelt DELETE-Anfragen an /api/v1/subjectArea.
     * Löscht einen Fachbereich basierend auf der angegebenen ID.
     *
     * @param subjectAreaId Die ID des Fachbereichs, der gelöscht werden soll
     */
    @DeleteMapping(path = "{subjectAreaId}")
    // Wir setzen "providerId" als Pfadvariable, damit die ID der zu löschenden Ressource in der URL enthalten ist, da DELETE-Anfragen in der Regel keinen Request Body nutzen.

    public void deleteSubjectArea(@PathVariable("subjectAreaId") Long subjectAreaId) {
        subjectAreaService.deleteSubjectArea(subjectAreaId);
    }

}

