package fr.sport.app.repository;

import fr.sport.app.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * <h1>Contact: interface</h1>
 * <hr/>
 * <p>
 * L’interface {@link ContactRepository} permet d’implémenter le code qui
 * déclenche les actions pour communiquer avec  la base de données. Bien évidemment,
 * ce code se servira de notre classe {@link Contact}.
 * Et faire des  requêtes à la base de données, et le résultat nous est retourné
 * sous forme d’instances de l’objet Contact.
 * <br/>
 * Spring Data JPA ! Il nous permet d’exécuter des requêtes SQL.
 * <br/><br/>
 *
 * {@link CrudRepository} est une interface fournie par Spring. Elle fournit des
 * méthodes pour manipuler votre entité. Elle utilise la généricité pour que son
 * code soit applicable à n’importe quelle entité, d’où la syntaxe
 * “CrudRepository<ClientArchive, Long>”.
 * <br/><br/>
 *
 * {@link Repository} est une annotation Spring pour indiquer que la  classe est
 * un bean, et que son rôle est  de  communiquer  avec  une  source  de  données
 * (en l'occurrence la base de données).
 * </p>
 * <hr/>
 *
 * @see Contact
 * @see CrudRepository
 * @see Repository
 *
 * @author lounis BOULDJA
 * @version 1.0
 */

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
}
