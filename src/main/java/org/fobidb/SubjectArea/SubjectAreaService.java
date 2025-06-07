package org.fobidb.SubjectArea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Die Klasse SubjectAreaService stellt die Geschäftslogik für die Verarbeitung und Verwaltung
 * von SubjectArea-Daten zur Verfügung. Sie ist eine Spring-Service-Komponente, die von der
 * Service-Schicht der Anwendung verwendet wird, um Operationen im Zusammenhang mit der
 * SubjectArea-Entität auszuführen.
 * <p>
 * Typische Verantwortlichkeiten dieser Klasse umfassen:
 * - Interagieren mit dem SubjectAreaRepository, um Datenbankoperationen auszuführen.
 * - Bereitstellung von Methoden zur Verarbeitung von Geschäftsanfragen im Zusammenhang mit Fachbereichen.
 * - Berechnung oder Transformation von Daten für die Präsentationsschicht.
 * <p>
 * Diese Serviceklasse nutzt die Dependency-Injection von Spring, um Repositorys oder
 * andere benötigte Abhängigkeiten bereitzustellen.
 */

@Service    // Kennzeichnet diese Klasse als Spring Service, der Geschäftslogik enthält
public class SubjectAreaService {
    private final SubjectAreaRepository subjectAreaRepository;

    @Autowired  // Springs Mechanismus für die Dependency Injection
    public SubjectAreaService(SubjectAreaRepository subjectAreaRepository) {
        this.subjectAreaRepository = subjectAreaRepository;
    }

    public List<SubjectArea> getSubjectAreas() {    // Ruft alle Fachbereiche aus der Datenbank ab.
        return subjectAreaRepository.findAll();
    }

    public void addNewSubjectArea(SubjectArea subjectArea) {
        // Validierung: Prüfen, ob ein Fachbereich mit dem gleichen Namen bereits existiert.
        Optional<SubjectArea> optionalSubjectArea = subjectAreaRepository.findByName(subjectArea.getName()); // Methode aus dem SubjectAreaRepository
        if (optionalSubjectArea.isPresent()) {  // Wir prüfen, ob das Optional einen Wert enthält
            throw new IllegalStateException("SubjectArea with Name: " + subjectArea.getName() + " already exists");
        }
        subjectAreaRepository.save(subjectArea);
    }

    public void deleteSubjectArea(Long subjectAreaId) {
        // Prüfen, ob der Fachbereich mit der gegebenen ID existiert, bevor er gelöscht wird
        boolean exists = subjectAreaRepository.existsById(subjectAreaId);
        if (!exists) {
            throw new IllegalStateException("SubjectArea with Id: " + subjectAreaId + " does not exist");
        }
        subjectAreaRepository.deleteById(subjectAreaId);
    }
}
