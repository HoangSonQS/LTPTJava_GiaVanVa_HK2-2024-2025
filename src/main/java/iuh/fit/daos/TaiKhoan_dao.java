package iuh.fit.daos;

import iuh.fit.entities.TaiKhoan;
import iuh.fit.interfaces.TaiKhoan_interface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class TaiKhoan_dao extends UnicastRemoteObject implements TaiKhoan_interface {

    private EntityManager em;

    public TaiKhoan_dao() throws RemoteException {
        super();
        em = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
    }

    public void create(TaiKhoan taiKhoan) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(taiKhoan);
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();
        }
    }

    public TaiKhoan read(String maTaiKhoan) {
        return em.find(TaiKhoan.class, maTaiKhoan);
    }

    public List<TaiKhoan> readAll() {
        return em.createQuery("SELECT t FROM TaiKhoan t", TaiKhoan.class).getResultList();
    }

    public void update(TaiKhoan taiKhoan) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(taiKhoan);
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(String maTaiKhoan) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            TaiKhoan taiKhoan = em.find(TaiKhoan.class, maTaiKhoan);
            if (taiKhoan != null) {
                em.remove(taiKhoan);
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