package iuh.fit.interfaces;

import iuh.fit.entities.KhachHang;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface KhachHang_interface extends Remote {
    void create(KhachHang khachHang) throws RemoteException;

    KhachHang read(String maKH) throws RemoteException;

    List<KhachHang> readAll() throws RemoteException;

    void update(KhachHang khachHang) throws RemoteException;

    void delete(String maKH) throws RemoteException;
}
