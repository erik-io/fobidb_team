package org.fobidb.provider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProviderRepository ist ein Repository-Interface, das die Datenzugriffsoperationen
 * für die Entität Provider bereitstellt. Es erweitert JpaRepository und bietet somit
 * CRUD-Operationen sowie Paging- und Sortierfunktionen.
 * <p>
 * Dieses Repository ist mit der @Repository-Annotation versehen, die Spring anweist,
 * es als eine Komponente für die Datenzugriffsschicht zu behandeln.
 * <p>
 * Die generischen Typen sind:
 * - Provider: Die Entität, auf die das Repository angewendet wird.
 * - Long: Der Typ des Primärschlüssels der Entität.
 */
@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

}
