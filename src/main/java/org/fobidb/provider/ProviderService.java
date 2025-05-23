package org.fobidb.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return providerRepository.findAll();
    }

    public void addNewProvider(Provider provider) {
        providerRepository.save(provider);
    }

    public void deleteProvider(Long providerId) {
        providerRepository.deleteById(providerId);
    }
}
