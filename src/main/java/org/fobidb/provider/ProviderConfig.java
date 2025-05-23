package org.fobidb.provider;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Die Klasse ProviderConfig ist eine Konfigurationsklasse, die Teil der Application Context
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
public class ProviderConfig {
    @Bean
        // Diese Annotation sagt Spring, dass das Objekt, das diese Methode zurückgibt, ein "Bean" ist, also ein Objekt, das von Spring verwaltet werden soll.
    CommandLineRunner commandLineRunner(ProviderRepository providerRepository) { // Spezielles Interface von Spring Boot, wenn ein Bean vom Typ CommandLineRunner definiert wird, wird dessen run-Method automatisch ausgeführt, nachdem die Anwendung vollständig gestartet wurde
        return args -> {
            if (providerRepository.count() == 0) {
                Provider fortbildungBerlin = new Provider(
                        "Fortbildung Berlin"
                );

                Provider foBizz = new Provider(
                        "FoBizz"
                );

                Provider zas = new Provider(
                        "ZAS"
                );

                Provider lisum = new Provider(
                        "LISUM"
                );

                providerRepository.saveAll(List.of(fortbildungBerlin, foBizz, zas, lisum));
            }
        };
    }
}
