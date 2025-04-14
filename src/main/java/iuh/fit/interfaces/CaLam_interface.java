package iuh.fit.interfaces;

import iuh.fit.entities.CaLam;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CaLam_interface extends Remote {
    void create(CaLam caLam) throws RemoteException;

    CaLam read(String maCa) throws RemoteException;

    List<CaLam> readAll() throws RemoteException;

    void update(CaLam caLam) throws RemoteException;

    void delete(String maCa) throws RemoteException;
}
