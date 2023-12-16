package int204.prefin.jpapractice.models.repositories;

import int204.prefin.jpapractice.models.EntityManagerMaker;
import int204.prefin.jpapractice.models.entities.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class ProductRepository {
    private EntityManager em;
    public int DEFAULT_SIZE = 10;
    private EntityManager getEntityManager(){
        if(em == null || !em.isOpen()){
            em = EntityManagerMaker.getEntityManager();
        }
        return em;
    }

    public int getTotalPages(){
        EntityManager em = getEntityManager();
        return ((Number) em.createNamedQuery("PRODUCT_GETTOTALPRODUCTS").getSingleResult()).intValue();
    }
    public List<Product> getProductByPage(int page, int size){
        EntityManager em = getEntityManager();
        if(page <= 0){
            page = 1;
        }
        Query getAll = em.createNamedQuery("PRODUCT_GETALL");
        getAll.setFirstResult(((page-1) * size));
        getAll.setMaxResults(size);
        return getAll.getResultList();
    }

    public Product findProduct(String code){
        EntityManager em = getEntityManager();
        return em.find(Product.class, code);
    }
}
