package org.fobidb.SubjectArea;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


/**
 * Die Klasse SubjectAreaConfig ist eine Konfigurationsklasse, die Teil der Application Context
 * Konfiguration in einer Spring-basierten Anwendung ist.
 * <p>
 * Typischerweise wird sie verwendet, um Einstellungen, Beans, oder andere Konfigurationen
 * zu definieren, die für den Betrieb der Anwendung erforderlich sind.
 * <p>
 * Die Annotation @Configuration kennzeichnet diese Klasse als Quelle für Bean-Definitionen und
 * fügt diese automatisch zum Spring Application Context hinzu. Dies ermöglicht eine einfache
 * und zentrale Verwaltung der Anwendungskonfiguration.
 */
@Configuration
// Diese Annotation sagt Spring, dass diese Klasse Konfigurationen für die Anwendung enthält. Spring wird diese Klasse beim Start scannen
public class SubjectAreaConfig {
    @Bean

    CommandLineRunner commandLineRunnerSubjectArea(SubjectAreaRepository subjectAreaRepository) {
        return args -> {
            if (subjectAreaRepository.count() == 0){

                SubjectArea hauswirtschaft = new SubjectArea("Hauswirtschaft");
                SubjectArea berufsvorbereitung= new SubjectArea("Berufsvorbereitung");
                SubjectArea wirtschaftUndVerwaltung = new SubjectArea("Wirtschaft und Verwaltung");
                SubjectArea technik = new SubjectArea("Technik");
                SubjectArea sonderpaedagogikUndInklusion = new SubjectArea("Sonderpaedagogik und Inklusion");
                SubjectArea allgemeinbildung = new SubjectArea("Allgemeinbildung");

                subjectAreaRepository.saveAll(List.of(hauswirtschaft,berufsvorbereitung, wirtschaftUndVerwaltung,technik,sonderpaedagogikUndInklusion,allgemeinbildung));
            }
        };
    }
}
