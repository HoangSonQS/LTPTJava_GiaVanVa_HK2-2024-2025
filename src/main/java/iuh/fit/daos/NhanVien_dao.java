package iuh.fit.daos;

import iuh.fit.entities.NhanVien;
import iuh.fit.interfaces.NhanVien_interface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class NhanVien_dao extends UnicastRemoteObject implements NhanVien_interface {
    private transient EntityManager em;

    public NhanVien_dao() throws RemoteException {
        super();
        em = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
    }

    @Override
    public void createNhanVien(NhanVien nhanVien) throws RemoteException {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(nhanVien);
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public NhanVien readNhanVien(String maNV) throws RemoteException {
        return em.find(NhanVien.class, maNV);
    }

    @Override
    public List<NhanVien> readAllNhanVien() throws RemoteException {
        return em.createQuery("SELECT nv FROM NhanVien nv", NhanVien.class).getResultList();
    }

    @Override
    public void updateNhanVien(NhanVien nhanVien) throws RemoteException {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(nhanVien);
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteNhanVien(String maNV) throws RemoteException {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            NhanVien nhanVien = em.find(NhanVien.class, maNV);
            if (nhanVien != null) {
                em.remove(nhanVien);
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