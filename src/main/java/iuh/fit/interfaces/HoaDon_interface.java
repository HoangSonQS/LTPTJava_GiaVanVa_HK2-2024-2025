package iuh.fit.interfaces;

import iuh.fit.entities.HoaDon;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface HoaDon_interface extends Remote {
    void create(HoaDon hoaDon) throws RemoteException;

    HoaDon read(String maHD) throws RemoteException;

    List<HoaDon> readAll() throws RemoteException;

    void update(HoaDon hoaDon) throws RemoteException;

    void delete(String maHD) throws RemoteException;
}
