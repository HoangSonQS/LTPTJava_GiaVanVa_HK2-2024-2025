package iuh.fit.daos;

import iuh.fit.entities.PhieuNhapHang;
import iuh.fit.interfaces.PhieuNhapHang_interface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class PhieuNhapHang_dao extends UnicastRemoteObject implements PhieuNhapHang_interface {

    private transient EntityManager em;

    public PhieuNhapHang_dao() throws RemoteException {
        super();
        em = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
    }

    @Override
    public void create(PhieuNhapHang phieuNhapHang) throws RemoteException {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(phieuNhapHang);
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public PhieuNhapHang read(String maPNH) throws RemoteException {
        return em.find(PhieuNhapHang.class, maPNH);
    }

    @Override
    public List<PhieuNhapHang> readAll() throws RemoteException {
        return em.createQuery("SELECT p FROM PhieuNhapHang p", PhieuNhapHang.class).getResultList();
    }

    @Override
    public void update(PhieuNhapHang phieuNhapHang) throws RemoteException {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(phieuNhapHang);
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String maPNH) throws RemoteException {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            PhieuNhapHang phieuNhapHang = em.find(PhieuNhapHang.class, maPNH);
            if (phieuNhapHang != null) {
                em.remove(phieuNhapHang);
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