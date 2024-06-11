package hibernate;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ContactHelper {

    private static Session openSession() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        return sessionFactory.openSession();
    }

    public static void printContactList() {

       Session session = openSession();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Contact> criteriaQuery = criteriaBuilder.createQuery(Contact.class);
            Root<Contact> root = criteriaQuery.from(Contact.class);
            criteriaQuery.select(root);

        Query query = session.createQuery(criteriaQuery);

        List<Contact> contacts = query.getResultList();
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public static Contact addContact() {
        Contact contact;
        try (Session session = openSession()) {
            session.getTransaction().begin();
            contact = new Contact();
            contact.setFirstName("Sasha");
            contact.setLastName("Brick");
            contact.setEmail("sasha.brick@gmail.com");
            contact.setPassword("blabla03");
            session.persist(contact);
            session.getTransaction().commit();
        }
        return contact;
    }

    public static void deleteContact(Contact contact) {
        try (Session session = openSession()) {
            session.beginTransaction();
            session.remove(contact);
            session.getTransaction().commit();
        }
    }

    public static void deleteContact(int id) {
        try (Session session = openSession()) {
            session.beginTransaction();
            session.remove(session.get(Contact.class, id ));
            session.getTransaction().commit();
        }
    }

    public static void updateContact(int id) {
        try (Session session = openSession()) {
            session.getTransaction().begin();
            Contact contactToUpdate = session.get(Contact.class, id );
            contactToUpdate.setFirstName("Sam");
            contactToUpdate.setLastName("Brom");
            contactToUpdate.setEmail("sam.brom@gmail.com");
            contactToUpdate.setPassword("blabla04");
            session.persist(contactToUpdate);
            session.getTransaction().commit();
        }
    }
}
