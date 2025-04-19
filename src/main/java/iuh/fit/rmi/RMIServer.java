package iuh.fit.rmi;

import iuh.fit.daos.*;
import iuh.fit.interfaces.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

    public static void main(String[] args) throws Exception {
        // Set system properties for RMI
        System.setProperty("java.security.policy", "rmi.policy");
        System.setProperty("java.rmi.server.hostname", "LAPTOP-O8OOBHDK");

        // Create and initialize the registry
        Context context = new InitialContext();
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
            NhanVien_dao nhanVienDAO = new NhanVien_dao();

            // Bind the DAO instances to the registry
            registry.rebind("rmi://LAPTOP-O8OOBHDK:9090/taiKhoanDAO", taiKhoanDAO);
            registry.rebind("rmi://LAPTOP-O8OOBHDK:9090/caLamDAO", caLamDAO);
            registry.rebind("rmi://LAPTOP-O8OOBHDK:9090/hoaDonDAO", hoaDonDAO);
            registry.rebind("rmi://LAPTOP-O8OOBHDK:9090/sanPhamDAO", sanPhamDAO);
            registry.rebind("rmi://LAPTOP-O8OOBHDK:9090/khachHangDAO", khachHangDAO);
            registry.rebind("rmi://LAPTOP-O8OOBHDK:9090/phieuNhapHangDAO", phieuNhapHangDAO);
            registry.rebind("rmi://LAPTOP-O8OOBHDK:9090/chiTietHoaDonSanPhamDAO", chiTietHoaDonSanPhamDAO);
            registry.rebind("rmi://LAPTOP-O8OOBHDK:9090/chiTietSanPhamPhieuNhapDAO", chiTietSanPhamPhieuNhapDAO);
            registry.rebind("rmi://LAPTOP-O8OOBHDK:9090/nhanVienDAO", nhanVienDAO);


            System.out.println("RMI Server is ready!");
            System.out.println("All DAO services bound to registry");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
