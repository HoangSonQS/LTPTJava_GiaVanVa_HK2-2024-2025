package iuh.fit.interfaces;

import iuh.fit.entities.HoaDon;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface HoaDon_interface extends Remote {
    void create(HoaDon hoaDon) throws RemoteException;

    HoaDon read(String maHD) throws RemoteException;

    List<HoaDon> readAll() throws RemoteException;

    void update(HoaDon hoaDon) throws RemoteException;

    void delete(String maHD) throws RemoteException;

    public List<Object[]> getThongKeSanPham(String nam, String loaiThongKe, String loaiHangDisplay) throws RemoteException;

    public List<Object[]> getLoaiHangDistribution() throws RemoteException;

    public List<Object[]> getSalesDistribution() throws RemoteException;

    public List<Object[]> getDoanhThuTheoThang(int nam) throws RemoteException;

    public List<Object[]> getDoanhThuTheoQuy(int nam) throws RemoteException;

    public List<Object[]> getDoanhThuTheoNgay(LocalDateTime startDate, LocalDateTime endDate) throws RemoteException;

    public Map<Integer, Double> getDoanhThuMapTheoThang(int nam) throws RemoteException;

    public Map<Integer, Double> getDoanhThuMapTheoQuy(int nam) throws RemoteException;

    public Map<LocalDate, Double> getDoanhThuMapTheoNgay(LocalDateTime startDate, LocalDateTime endDate) throws RemoteException;;
    
}
