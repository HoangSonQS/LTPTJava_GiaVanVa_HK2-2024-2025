package iuh.fit.daos;

import iuh.fit.entities.CaLam;
import iuh.fit.interfaces.CaLam_interface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class CaLam_dao extends UnicastRemoteObject implements CaLam_interface {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");

    public CaLam_dao() throws RemoteException {
    }

    @Override
    public void create(CaLam caLam) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(caLam);
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public CaLam read(String maCa) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        CaLam caLam = null;
        try {
            caLam = em.find(CaLam.class, maCa);
        } finally {
            em.close();
        }
        return caLam;
    }

    @Override
    public List<CaLam> readAll() throws RemoteException {
        EntityManager em = emf.createEntityManager();
        List<CaLam> caLams = null;
        try {
            caLams = em.createQuery("SELECT c FROM CaLam c", CaLam.class).getResultList();
        } finally {
            em.close();
        }
        return caLams;
    }

    @Override
    public void update(CaLam caLam) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(caLam);
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(String maCa) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            CaLam caLam = em.find(CaLam.class, maCa);
            if (caLam != null) {
                em.remove(caLam);
            }
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}