package iuh.fit.interfaces;

import iuh.fit.entities.TaiKhoan;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface TaiKhoan_interface extends Remote {
    void create(TaiKhoan taiKhoan) throws RemoteException;

    TaiKhoan read(String maTaiKhoan) throws RemoteException;

    List<TaiKhoan> readAll() throws RemoteException;

    void update(TaiKhoan taiKhoan) throws RemoteException;

    void delete(String maTaiKhoan) throws RemoteException;

    public TaiKhoan findByUsernameandPassword(String username, String password) throws RemoteException;

}
