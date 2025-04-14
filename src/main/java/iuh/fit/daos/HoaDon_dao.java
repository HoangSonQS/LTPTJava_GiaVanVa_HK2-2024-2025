package iuh.fit.daos;

import iuh.fit.entities.HoaDon;
import iuh.fit.interfaces.HoaDon_interface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class HoaDon_dao extends UnicastRemoteObject implements HoaDon_interface {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");

    public HoaDon_dao() throws RemoteException {
    }

    protected HoaDon_dao(int port) throws RemoteException {
        super(port);
    }

    protected HoaDon_dao(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    public void create(HoaDon hoaDon) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(hoaDon);
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

    public HoaDon read(String maHD) {
        EntityManager em = emf.createEntityManager();
        HoaDon hoaDon = em.find(HoaDon.class, maHD);
        em.close();
        return hoaDon;
    }

    public List<HoaDon> readAll() {
        EntityManager em = emf.createEntityManager();
        List<HoaDon> hoaDons = em.createQuery("SELECT h FROM HoaDon h", HoaDon.class).getResultList();
        em.close();
        return hoaDons;
    }

    public void update(HoaDon hoaDon) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(hoaDon);
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

    public void delete(String maHD) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            HoaDon hoaDon = em.find(HoaDon.class, maHD);
            if (hoaDon != null) {
                em.remove(hoaDon);
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