package iuh.fit.interfaces;

import iuh.fit.entities.ChiTietSanPham_PhieuNhap;
import iuh.fit.entities.ChiTietSanPham_PhieuNhapId;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChiTietSanPham_PhieuNhap_interface extends Remote {
    void create(ChiTietSanPham_PhieuNhap chiTiet) throws RemoteException;

    ChiTietSanPham_PhieuNhap read(ChiTietSanPham_PhieuNhapId id) throws RemoteException;

    List<ChiTietSanPham_PhieuNhap> readAll() throws RemoteException;

    void update(ChiTietSanPham_PhieuNhap chiTiet) throws RemoteException;

    void delete(ChiTietSanPham_PhieuNhapId id) throws RemoteException;
}
