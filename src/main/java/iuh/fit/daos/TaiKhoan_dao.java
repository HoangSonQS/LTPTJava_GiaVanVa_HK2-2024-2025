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

    @Override
    public void create(TaiKhoan taiKhoan) throws RemoteException {
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

    @Override
    public TaiKhoan read(String maTaiKhoan) throws RemoteException {
        return em.find(TaiKhoan.class, maTaiKhoan);
    }

    @Override
    public List<TaiKhoan> readAll() throws RemoteException {
        return em.createQuery("SELECT t FROM TaiKhoan t", TaiKhoan.class).getResultList();
    }

    @Override
    public void update(TaiKhoan taiKhoan) throws RemoteException {
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

    @Override
    public void delete(String maTaiKhoan) throws RemoteException {
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
    @Override
    public TaiKhoan findByUsernameandPassword(String username, String password) throws RemoteException {
        try {
            return em.createQuery("SELECT t FROM TaiKhoan t WHERE t.tenDangNhap = :username AND t.matKhau = :password", TaiKhoan.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}