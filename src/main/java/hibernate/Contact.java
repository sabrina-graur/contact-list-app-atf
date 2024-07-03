package hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "contact", schema = "contact.list.project") //schema optional
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
    private int idContact;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Override
    public String toString() {
        return "\nContact {" +
                "id= " + idContact +
                ", first name= '" + firstName + '\'' +
                ", last name= '" + lastName + '\'' +
                ", email= '" + email + '\'' +
                ", password= '" + password + '\'' +
                '}';
    }
}
