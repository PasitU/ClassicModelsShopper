package int204.prefin.jpapractice.models;

import int204.prefin.jpapractice.models.entities.Office;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerMaker {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("classic-models");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


}
