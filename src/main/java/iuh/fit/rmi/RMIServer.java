package iuh.fit.rmi;

import iuh.fit.daos.*;
import iuh.fit.interfaces.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

    public static void main(String[] args) throws Exception {
        // Set system properties for RMI
        System.setProperty("java.security.policy", "rmi.policy");
        System.setProperty("java.rmi.server.hostname", "localhost");

        // Create and initialize the registry
        Registry registry = LocateRegistry.createRegistry(9090);

        try {
            // Create DAO instances
            TaiKhoan_dao taiKhoanDAO = new TaiKhoan_dao();
            CaLam_dao caLamDAO = new CaLam_dao();
            HoaDon_dao hoaDonDAO = new HoaDon_dao();
            SanPham_dao sanPhamDAO = new SanPham_dao();
            KhachHang_dao khachHangDAO = new KhachHang_dao();
            PhieuNhapHang_dao phieuNhapHangDAO = new PhieuNhapHang_dao();
            ChiTietHoaDon_SanPham_dao chiTietHoaDonSanPhamDAO = new ChiTietHoaDon_SanPham_dao();
            ChiTietSanPham_PhieuNhap_dao chiTietSanPhamPhieuNhapDAO = new ChiTietSanPham_PhieuNhap_dao();

            // Bind the DAO instances to the registry
            registry.rebind("taiKhoanDAO", taiKhoanDAO);
            registry.rebind("caLamDAO", caLamDAO);
            registry.rebind("hoaDonDAO", hoaDonDAO);
            registry.rebind("sanPhamDAO", sanPhamDAO);
            registry.rebind("khachHangDAO", khachHangDAO);
            registry.rebind("phieuNhapHangDAO", phieuNhapHangDAO);
            registry.rebind("chiTietHoaDonSanPhamDAO", chiTietHoaDonSanPhamDAO);
            registry.rebind("chiTietSanPhamPhieuNhapDAO", chiTietSanPhamPhieuNhapDAO);

            System.out.println("RMI Server is ready!");
            System.out.println("All DAO services bound to registry");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
