package iuh.fit.daos;

import iuh.fit.entities.NhanVien;
import iuh.fit.interfaces.NhanVien_interface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class NhanVien_dao extends UnicastRemoteObject implements NhanVien_interface {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");

    protected NhanVien_dao() throws RemoteException {
    }

    protected NhanVien_dao(int port) throws RemoteException {
        super(port);
    }

    protected NhanVien_dao(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public void createNhanVien(NhanVien nhanVien) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(nhanVien);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public NhanVien readNhanVien(String maNV) {
        EntityManager em = emf.createEntityManager();
        NhanVien nhanVien = em.find(NhanVien.class, maNV);
        em.close();
        return nhanVien;
    }

    @Override
    public List<NhanVien> readAllNhanVien() {
        EntityManager em = emf.createEntityManager();
        List<NhanVien> nhanViens = em.createQuery("SELECT nv FROM NhanVien nv", NhanVien.class).getResultList();
        em.close();
        return nhanViens;
    }

    @Override
    public void updateNhanVien(NhanVien nhanVien) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(nhanVien);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteNhanVien(String maNV) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        NhanVien nhanVien = em.find(NhanVien.class, maNV);
        if (nhanVien != null) {
            em.remove(nhanVien);
        }
        em.getTransaction().commit();
        em.close();
    }
}