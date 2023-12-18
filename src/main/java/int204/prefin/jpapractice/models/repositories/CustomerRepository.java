package int204.prefin.jpapractice.models.repositories;

import int204.prefin.jpapractice.models.EntityManagerMaker;
import int204.prefin.jpapractice.models.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class CustomerRepository {
    private EntityManager em;

    public EntityManager getEntityManager(){
        if(em == null || !em.isOpen()){
            em = EntityManagerMaker.getEntityManager();
        }
        return em;
    }

    public Customer find(String id){
        EntityManager em = getEntityManager();
        return em.find(Customer.class, id);
    }

    public List<Customer> getAllCustomer(){
        EntityManager emn = getEntityManager();
        Query findAll = emn.createNamedQuery("CUSTOMER_GETALL");
        return findAll.getResultList();
    }

    public Customer getByName(String fullname){
        EntityManager emn = getEntityManager();
        Customer c;
        try {
            c = (Customer) emn.createNamedQuery("CUSTOMER_GETBYFULLNAME").setParameter("fullname", fullname).getSingleResult();
            return c;
        }catch (Exception e){
            return null;
        }
    }
}
