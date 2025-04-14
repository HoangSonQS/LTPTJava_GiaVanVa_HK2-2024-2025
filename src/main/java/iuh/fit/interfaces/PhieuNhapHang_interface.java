package iuh.fit.interfaces;

import iuh.fit.entities.PhieuNhapHang;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface PhieuNhapHang_interface extends Remote {
    void create(PhieuNhapHang phieuNhapHang) throws RemoteException;

    PhieuNhapHang read(String maPNH) throws RemoteException;

    List<PhieuNhapHang> readAll() throws RemoteException;

    void update(PhieuNhapHang phieuNhapHang) throws RemoteException;

    void delete(String maPNH) throws RemoteException;

}
