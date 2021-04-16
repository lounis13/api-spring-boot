package fr.sport.app.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


/**
 * <h1>Client : abstract class</h1>
 * <hr/>
 * Entity (JPA)  qui  représente  les  contact  dans la  base  de  données.
 * <p>
 * <br/><br/>
 * <p>
 * {@link Data} est une annotation  Lombok. Nul  besoin d’ajouter les  getters  et
 * les setters.  La  librairie  Lombok  s’en  charge pour  nous. Très  utile  pour
 * alléger le code.
 * <br/>
 * {@link Entity} est une annotation qui indique que  la  classe correspond  à  une
 * table de la base de données.
 * <br/>
 * {@link Table} indique le nom de la table associée,  attribut <strong>name</strong>
 * pour  indiquer le nom de la table dans la base de données.
 * <br/><br/>
 * <p>
 * Annotés avec {@link Column} pour faire le lien avec le nom du champ de la table.
 * <p>
 * <hr/><br/>
 *
 * @author lounis BOULDJA
 * @version 1.0
 * @see <a href="https://docs.oracle.com/javaee/7/api/index.html">
 * javax.persistence javadoc</a>
 */

@Data
@Entity
@Table(name = "contact")
public class Contact {


    /**
     * L’attribut id correspond à la clé primaire de la table, et est donc annoté @Id.
     * D’autre part, comme l’id est auto-incrémenté, j’ai ajouté l’annotation
     * <strong>@GeneratedValue(strategy = GenerationType.IDENTITY).<strong/>
     *
     * @see Id
     * @see GeneratedValue
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "date_creation")
    private LocalDate dateCreation;
}
