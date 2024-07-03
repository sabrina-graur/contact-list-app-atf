package hibernate;

import org.hibernate.Session;

public class Start {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ContactHelper.printContactList();
        Contact sasha = ContactHelper.addContact();
        ContactHelper.deleteContact(sasha);
        ContactHelper.updateContact(2);
        ContactHelper.printContactList();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
}
