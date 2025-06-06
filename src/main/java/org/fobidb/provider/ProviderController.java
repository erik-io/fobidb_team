package org.fobidb.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Die Klasse ProviderController stellt die API-Endpunkte für die Verwaltung von Anbietern bereit.
 * Sie ist mit der Annotation @RestController versehen, um anzuzeigen, dass sie eine RESTful Webservice-Komponente ist.
 * <p>
 * Der Basis-Pfad für alle Endpunkte in dieser Klasse ist "api/v1/provider",
 * wie durch die Annotation @RequestMapping definiert.
 * <p>
 * Typische Aufgaben und Verantwortlichkeiten dieser Klasse:
 * - Handhaben von HTTP-Anfragen wie GET, POST, PUT und DELETE.
 * - Kommunizieren mit der Geschäftslogik, die in der ProviderService-Klasse implementiert ist.
 * - Rückgabe von Antworten an die Clients im JSON-Format.
 * <p>
 * Durch die Nutzung von Spring Boot und dessen REST-Controller-Mechanismen wird diese Klasse
 * automatisch als REST-Endpunkt registriert und ist nach dem Start der Anwendung verfügbar.
 */
@RestController // Definiert diese Klasse als REST-Controller
@RequestMapping(path = "api/v1/provider") // Basis-URL-Pfad für alle Anfragen an diesen Controller
public class ProviderController {
    private final ProviderService providerService; // Abhängigkeit zum ProviderService

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    /**
     * Behandelt GET-Anfragen an /api/v1/provider.
     * Ruft alle Anbieter ab.
     *
     * @return eine Liste von {@code Provider}-Objekten, die alle Anbieter repräsentieren
     */
    @GetMapping
    public List<Provider> getProviders() {
        return providerService.getProviders();
    }


    /**
     * Behandelt POST-Anfragen an /api/v1/provider.
     * Der neue Anbieter wird an den entsprechenden Service weitergeleitet,
     * um in der Datenbank gespeichert zu werden.
     *
     * @param provider Das {@code Provider}-Objekt, das die Details des neuen Anbieters enthält
     */
    @PostMapping
    public void addNewProvider(@RequestBody Provider provider) { // @RequestBody weist Spring an, den Inhalt (Body) der HTTP POST-Anfrage zu nehmen und ihn automatisch in ein Provider-Objekt umzuwandeln
        providerService.addNewProvider(provider);
    }

    /**
     * Behandelt DELETE-Anfragen an /api/v1/provider.
     * Löscht einen Anbieter basierend auf der angegebenen ID.
     *
     * @param providerId Die ID des Anbieters, der gelöscht werden soll
     */
    @DeleteMapping(path = "{providerId}")
    // Wir setzen "providerId" als Pfadvariable, damit die ID der zu löschenden Ressource in der URL enthalten ist, da DELETE-Anfragen in der Regel keinen Request Body nutzen.

    public void deleteProvider(@PathVariable("providerId") Long providerId) {
        providerService.deleteProvider(providerId);
    }
}
