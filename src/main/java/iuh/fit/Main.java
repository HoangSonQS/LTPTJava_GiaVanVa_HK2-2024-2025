package iuh.fit;

import iuh.fit.daos.TaiKhoan_dao;
import iuh.fit.entities.TaiKhoan;

import java.rmi.RemoteException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws RemoteException {
        List<TaiKhoan> taiKhoans = new TaiKhoan_dao().readAll();
        System.out.println(taiKhoans);
    }
}
