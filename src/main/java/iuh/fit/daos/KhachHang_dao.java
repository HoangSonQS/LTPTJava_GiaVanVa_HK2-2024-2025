/*
 *@ (#) KhachHang_dao.java        1.0     1/21/2025
 *Copyright (c) 2025 IUH.All rights reserved.
 */

package iuh.fit.daos;/*
 *@descripsion:
 *@author : Khai Tien
 *@date: 1/21/2025
 *@version: 1.0
 */

import iuh.fit.entities.KhachHang;
import iuh.fit.interfaces.KhachHang_interface;
import jakarta.persistence.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class KhachHang_dao extends UnicastRemoteObject implements KhachHang_interface {
    private transient EntityManager em;

    public KhachHang_dao() throws RemoteException {
        super();
        em = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
    }

    @Override
    public void create(KhachHang khachHang) throws RemoteException {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(khachHang);
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public KhachHang read(String maKH) throws RemoteException {
        return em.find(KhachHang.class, maKH);
    }

    @Override
    public List<KhachHang> readAll() throws RemoteException {
        return em.createQuery("SELECT k FROM KhachHang k", KhachHang.class).getResultList();
    }

    @Override
    public void update(KhachHang khachHang) throws RemoteException {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(khachHang);
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String maKH) throws RemoteException {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            KhachHang khachHang = em.find(KhachHang.class, maKH);
            if (khachHang != null) {
                em.remove(khachHang);
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
    public KhachHang findByPhone(String sdt) throws RemoteException {
        try {
            TypedQuery<KhachHang> query = em.createQuery(
                    "SELECT k FROM KhachHang k WHERE k.sdt = :sdt", KhachHang.class);
            query.setParameter("sdt", sdt);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Trả về null nếu không tìm thấy khách hàng
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}