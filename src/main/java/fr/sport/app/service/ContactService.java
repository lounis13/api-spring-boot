package fr.sport.app.service;

import fr.sport.app.exception.ResourceNotFoundException;
import fr.sport.app.model.Contact;
import fr.sport.app.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * <h1>ContactService: class</h1>
 * <hr/>
 * <p>
 * La couche “service” est dédiée au “métier”. C’est-à-dire appliquer des traitements
 * dictés par les règles fonctionnelles de l’application. Et également un pont entre
 * {@link fr.sport.app.controller.ContactController}  et {@link ContactRepository}.Intérêt que chaque méthode a
 * pour unique objectif d’appeler une méthode de {@link ContactRepository}
 * <br/>
 * <p>
 * {@link Service}  tout comme l’annotation @Repository, c’est une spécialisation
 * de @Component. Son rôle est donc le même, mais son nom a une valeur sémantique
 * pour ceux qui lisent le code.
 * <p>
 * <hr/>
 *
 * @author lounis BOULDJA
 * @version 1.0
 * @see ContactRepository
 * @see Service
 */

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact getContactById(Long id) {
        return this.contactRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("pas de client avec id : " + id));
    }

    public Iterable<Contact> getContacts() {
        return this.contactRepository.findAll();
    }

    public Contact createContact(Contact contact) {
        return this.contactRepository.save(contact);
    }

    public ResponseEntity<Map<String, Boolean>> deleteContact(Long id) {
        Contact contact = this.contactRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("pas de client avec un id : " + id));
        this.contactRepository.delete(contact);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Contact> updateCotact(Long id, Contact contactUpdate) {
        Contact contact = this.contactRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("il existe pas un client avec un id : " + id));

        contact.setNom(contactUpdate.getNom());
        contact.setEmail(contactUpdate.getEmail());
        contact.setTelephone(contactUpdate.getTelephone());
        contact.setDateCreation(contactUpdate.getDateCreation());

        Contact contactUpdated = this.contactRepository.save(contact);
        return ResponseEntity.ok(contactUpdated);
    }

}
