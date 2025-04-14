package iuh.fit.interfaces;

import iuh.fit.entities.NhanVien;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface NhanVien_interface extends Remote {
    void createNhanVien(NhanVien nhanVien) throws RemoteException;

    NhanVien readNhanVien(String maNV) throws RemoteException;

    List<NhanVien> readAllNhanVien() throws RemoteException;

    void updateNhanVien(NhanVien nhanVien) throws RemoteException;

    void deleteNhanVien(String maNV) throws RemoteException;
}
