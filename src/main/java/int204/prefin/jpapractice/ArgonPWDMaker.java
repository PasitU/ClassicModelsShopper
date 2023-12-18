package int204.prefin.jpapractice;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import int204.prefin.jpapractice.models.entities.Customer;
import int204.prefin.jpapractice.models.repositories.CustomerRepository;
import jakarta.persistence.EntityManager;

public class ArgonPWDMaker {
//    public static void main(String[] args) {
//        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d, 16, 16);
//        CustomerRepository cr = new CustomerRepository();
//        EntityManager em = cr.getEntityManager();
//        em.getTransaction().begin();
//        for (Customer c: cr.getAllCustomer()) {
//            c.setPassword(argon2.hash(2,16,1, c.getCustomerNumber().toCharArray()));
//            em.merge(c);
//        }
//        em.getTransaction().commit();
//    }

    public static void main(String[] args) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d, 16, 16);
        CustomerRepository cr = new CustomerRepository();
        Customer target = cr.getByName("Jean King");
        System.out.println(target.getCustomerNumber());
        String password = "112";
        System.out.println(argon2.verify(target.getPassword(), password.toCharArray()));
    }
}
