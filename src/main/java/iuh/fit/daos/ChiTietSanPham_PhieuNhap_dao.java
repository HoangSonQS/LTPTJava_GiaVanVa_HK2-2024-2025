// src/main/java/iuh.fit.daos/ChiTietSanPham_PhieuNhap_dao.java
package iuh.fit.daos;

import iuh.fit.entities.ChiTietSanPham_PhieuNhap;
import iuh.fit.entities.ChiTietSanPham_PhieuNhapId;
import iuh.fit.interfaces.ChiTietSanPham_PhieuNhap_interface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Logger;

public class ChiTietSanPham_PhieuNhap_dao extends UnicastRemoteObject implements ChiTietSanPham_PhieuNhap_interface {
    private transient EntityManagerFactory emf;
    private static final Logger logger = Logger.getLogger(ChiTietSanPham_PhieuNhap_dao.class.getName());

    public ChiTietSanPham_PhieuNhap_dao() throws RemoteException {
        super();
        emf = Persistence.createEntityManagerFactory("mariadb");
    }

    @Override
    public void create(ChiTietSanPham_PhieuNhap chiTiet) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(chiTiet); // Sử dụng merge thay vì persist
            tr.commit();
            logger.info("Created ChiTietSanPham_PhieuNhap: " + chiTiet);
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
    public ChiTietSanPham_PhieuNhap read(ChiTietSanPham_PhieuNhapId id) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        ChiTietSanPham_PhieuNhap chiTiet = em.find(ChiTietSanPham_PhieuNhap.class, id);
        logger.info("Read ChiTietSanPham_PhieuNhap: " + chiTiet);
        em.close();
        return chiTiet;
    }

    @Override
    public List<ChiTietSanPham_PhieuNhap> readAll() throws RemoteException {
        EntityManager em = emf.createEntityManager();
        List<ChiTietSanPham_PhieuNhap> chiTiets = em.createQuery("SELECT c FROM ChiTietSanPham_PhieuNhap c", ChiTietSanPham_PhieuNhap.class).getResultList();
        em.close();
        return chiTiets;
    }

    @Override
    public void update(ChiTietSanPham_PhieuNhap chiTiet) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(chiTiet);
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
    public void delete(ChiTietSanPham_PhieuNhapId id) throws RemoteException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            ChiTietSanPham_PhieuNhap chiTiet = em.find(ChiTietSanPham_PhieuNhap.class, id);
            if (chiTiet != null) {
                em.remove(chiTiet);
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