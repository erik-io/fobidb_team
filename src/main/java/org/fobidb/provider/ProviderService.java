package org.fobidb.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Die Klasse ProviderService stellt die Geschäftslogik für die Verarbeitung und Verwaltung
 * von Provider-Daten zur Verfügung. Sie ist eine Spring-Service-Komponente, die von der
 * Service-Schicht der Anwendung verwendet wird, um Operationen im Zusammenhang mit der
 * Provider-Entität auszuführen.
 * <p>
 * Typische Verantwortlichkeiten dieser Klasse umfassen:
 * - Interagieren mit dem ProviderRepository, um Datenbankoperationen auszuführen.
 * - Bereitstellung von Methoden zur Verarbeitung von Geschäftsanfragen im Zusammenhang mit Anbietern.
 * - Berechnung oder Transformation von Daten für die Präsentationsschicht.
 * <p>
 * Diese Serviceklasse nutzt die Dependency-Injection von Spring, um Repositorys oder
 * andere benötigte Abhängigkeiten bereitzustellen.
 */
@Service // Kennzeichnet diese Klasse als Spring Service, der Geschäftslogik enthält
public class ProviderService {
    private final ProviderRepository providerRepository; // Final sorgt dafür, dass die Referenz nach ihrer Initialisierung nicht mehr verändert werden kann

    @Autowired // Springs Mechanismus für die Dependency Injection
    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<Provider> getProviders() {
        return providerRepository.findAll(); // Ruft alle Anbieter aus der Datenbank ab.
    }

    public void addNewProvider(Provider provider) {
        // Validierung: Prüfen, ob ein Anbieter mit dem gleichen Namen bereits existiert.
        Optional<Provider> providerOptional = providerRepository.findByName(provider.getName()); // Methode aus dem ProviderRepository
        if (providerOptional.isPresent()) { // Wir prüfen, ob das Optional einen Wert enthält
            throw new IllegalStateException("Provider with name " + provider.getName() + " already exists");
        }
        providerRepository.save(provider);
    }

    public void deleteProvider(Long providerId) {
        // Prüfen, ob der Anbieter mit der gegebenen ID existiert, bevor er gelöscht wird
        boolean exists = providerRepository.existsById(providerId);
        if (!exists) {
            throw new IllegalStateException("Provider with ID " + providerId + " does not exist");
        }
        providerRepository.deleteById(providerId);
    }
}
