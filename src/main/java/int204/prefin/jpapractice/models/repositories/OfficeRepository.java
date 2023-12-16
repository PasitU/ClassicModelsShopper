package int204.prefin.jpapractice.models.repositories;

import int204.prefin.jpapractice.models.EntityManagerMaker;
import int204.prefin.jpapractice.models.entities.Employee;
import int204.prefin.jpapractice.models.entities.Office;
import jakarta.persistence.EntityManager;

import java.util.List;

public class OfficeRepository {
    private EntityManager em;

    private EntityManager getEntityManager() {
        if (em == null || !em.isOpen()) {
            em = EntityManagerMaker.getEntityManager();
        }
        return em;
    }

    public List<Office> getAllOffices() {
        EntityManager em = getEntityManager();
        return em.createNamedQuery("OFFICE_GETALL").getResultList();
    }

    public Office getOffice(String officeCode) {
        EntityManager em = getEntityManager();
        Office office = null;
        if (officeCode != null) {
            office = (Office) em.createNamedQuery("OFFICE_FINDBYCODE").setParameter("officeCode", officeCode).getSingleResult();
        }
        return office;
    }

    public boolean deleteOffice(String officeCode) {
        EntityManager em = getEntityManager();
        Office o = em.find(Office.class, officeCode);
        if (o != null) {
            try {
                em.getTransaction().begin();
                em.remove(o);
                em.getTransaction().commit();
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public boolean updateOffice(Office o) {
        EntityManager em = getEntityManager();
        Office toUp = em.find(Office.class, o.getOfficeCode());
        try {
            em.getTransaction().begin();
            toUp.setCity(o.getCity());
            toUp.setPhone(o.getPhone());
            toUp.setAddressLine1(o.getAddressLine1());
            toUp.setAddressLine1(o.getAddressLine2());
            toUp.setState(o.getState());
            toUp.setCountry(o.getCountry());
            toUp.setPostalCode(o.getPostalCode());
            toUp.setTerritory(o.getTerritory());
            em.merge(o);
            em.flush();
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Employee> getEmployees(String officeCode) {
        EntityManager em = getEntityManager();
        Office o = em.find(Office.class, officeCode);
        if (o != null){
            return o.getEmployeeList();
        }
        return null;
    }

    public boolean createOffice(Office o) {
        EntityManager em = getEntityManager();
        Office alreadyExist = em.find(Office.class, o.getOfficeCode());
        if(alreadyExist != null){
            return false;
        }else {
            try{
                em.getTransaction().begin();
                em.persist(o);
                em.getTransaction().commit();
                return true;
            }catch (Exception e){
                return  false;
            }
        }
    }
}
