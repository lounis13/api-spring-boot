package fr.sport.app.controller;

import fr.sport.app.model.Contact;
import fr.sport.app.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * <h1>ContraController : class</h1>
 * <hr/>
 * Contrat Controller permet de communiquer avec front end react. Pour accéder
 * à notre API on utilise des endpoints associé à une URL,  Lorsqu'on appelle
 * cette URL, on reçoit une réponse, et cet échange se fait en HTTP. et grâce
 * à Spring-Boot-starter-web nous  fournit  tout  le nécessaire pour créer un
 * endpoint.
 * <br/><br/>
 * <ul>
 *     <li>
 *          {@link RestController} : Comme @Component, elle permet d’indiquer à Spring
 *          que cette classe est un bean, et aussi   indiqué  à  Spring  d’insérer  le
 *          retour  de  la méthode  au  format  JSON  dans le corps de la réponse HTTP.
 *          Grâce à  ça , les applications qui  vont communiquer avec l’API accéderont
 *          au résultat de leur requête en parsant la réponse HTTP. <br/>
 *     </li>
 *     <li>
 *         {@link CrossOrigin} : Annotation  pour  autoriser  les  requêtes d'origine
 *         croisée  sur  des  classes  de  gestionnaire  et  /  ou  des  méthodes  de
 *         gestionnaire spécifiques. Traité si un HandlerMapping approprié est configuré.
 *     </li>
 * </ul>
 * <hr/>
 *
 * @author Lounis BOULDJA
 * @version 1.0
 * @see ContactService
 * @see RestController
 * @see CrossOrigin
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

    /**
     * Cela permettra d’appeler les méthodes pour communiquer avec la base de données.
     *
     * @see Contact
     **/
    @Autowired
    private ContactService contactService;

    /**
     *<h2>Recuperer la list de Contact de la base de données.</h2>
     *
     * {@link GetMapping} Cela signifie que les requêtes  HTTP de  type  GET à l’URL /clients
     * exécuteront le code de cette méthode. Et ce code est tout simple : il s’agit d’appeler
     * la méthode  getClients()  du  {@link ContactService},  ce  dernier appellera la méthode
     * findAll()  du  {@link fr.sport.app.repository.ContactRepository}
     * et nous obtiendrons ainsi tous les clients enregistrés  en  base de données.
     *
     * @return <strong>la liste des Contact enregistrés  en  base de données.<strong/>
     * @see GetMapping
     */
    @GetMapping("/api/contacts")
    public Iterable<Contact> getContacts () {
        return this.contactService.getContacts();
    }

    @GetMapping("/api/contacts/{id}")
    public Contact getContactById (@PathVariable Long id) {
        return this.contactService.getContactById(id);
    }

    @PostMapping("/api/contacts/add")
    public Contact createContact (@RequestBody Contact contact) {
        return this.contactService.createContact(contact);
    }

    @DeleteMapping("/api/contacts/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCotact (@PathVariable Long id) {
        return this.contactService.deleteContact(id);
    }

    @PutMapping("/api/contacts/update/{id}")
    public ResponseEntity<Contact> updateContact (@RequestBody Contact contact, @PathVariable Long id) {
        return this.contactService.updateCotact(id, contact);
    }
}
