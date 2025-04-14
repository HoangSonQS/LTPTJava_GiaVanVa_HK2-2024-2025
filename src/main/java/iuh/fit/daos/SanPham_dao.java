package iuh.fit.daos;

import iuh.fit.entities.SanPham;
import iuh.fit.interfaces.SanPham_interface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class SanPham_dao extends UnicastRemoteObject implements SanPham_interface {

    private transient EntityManager em;

    public SanPham_dao() throws RemoteException {
        super();
        em = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
    }

    @Override
    public void create(SanPham sanPham) throws RemoteException {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(sanPham);
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public SanPham read(String maSP) throws RemoteException {
        return em.find(SanPham.class, maSP);
    }

    @Override
    public List<SanPham> readAll() throws RemoteException {
        return em.createQuery("SELECT s FROM SanPham s", SanPham.class).getResultList();
    }

    @Override
    public void update(SanPham sanPham) throws RemoteException {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(sanPham);
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String maSP) throws RemoteException {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            SanPham sanPham = em.find(SanPham.class, maSP);
            if (sanPham != null) {
                em.remove(sanPham);
            }
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();
        }
    }
}