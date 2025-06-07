package org.fobidb.SubjectArea;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


/**
 * Die Klasse SujectAreaConfig ist eine Konfigurationsklasse, die Teil der Application Context
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

                SubjectArea Hauswirtschaft = new SubjectArea("Hauswirtschaft");
                SubjectArea Berufsvorbereitung= new SubjectArea("Berufsvorbereitung");
                SubjectArea Wirtschaft_und_Verwaltung = new SubjectArea("Wirtschaft_und_Verwaltung");
                SubjectArea Technik = new SubjectArea("Technik");
                SubjectArea Sonderpaedagogik_und_Inklusion = new SubjectArea("Sonderpaedagogik_und_Inklusion");
                SubjectArea Allgemeinbildung = new SubjectArea("Allgemeinbildung");

                subjectAreaRepository.saveAll(List.of(Hauswirtschaft,Berufsvorbereitung,Wirtschaft_und_Verwaltung,Technik,Sonderpaedagogik_und_Inklusion,Allgemeinbildung));
            }
        };
    }
}
