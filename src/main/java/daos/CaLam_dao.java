package daos;

import entities.CaLam;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class CaLam_dao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");

    public void create(CaLam caLam) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(caLam);
        em.getTransaction().commit();
        em.close();
    }

    public CaLam read(String maCa) {
        EntityManager em = emf.createEntityManager();
        CaLam caLam = em.find(CaLam.class, maCa);
        em.close();
        return caLam;
    }

    public List<CaLam> readAll() {
        EntityManager em = emf.createEntityManager();
        List<CaLam> caLams = em.createQuery("SELECT c FROM CaLam c", CaLam.class).getResultList();
        em.close();
        return caLams;
    }

    public void update(CaLam caLam) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(caLam);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(String maCa) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CaLam caLam = em.find(CaLam.class, maCa);
        if (caLam != null) {
            em.remove(caLam);
        }
        em.getTransaction().commit();
        em.close();
    }
}