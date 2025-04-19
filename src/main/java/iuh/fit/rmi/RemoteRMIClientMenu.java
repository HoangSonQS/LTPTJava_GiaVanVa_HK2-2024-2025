package iuh.fit.rmi;

import iuh.fit.entities.*;
import iuh.fit.interfaces.*;
import iuh.fit.enums.PhuongThucThanhToan;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class RemoteRMIClientMenu {
    private static Registry registry;
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // DAO interfaces
    private static TaiKhoan_interface taiKhoanDAO;
    private static CaLam_interface caLamDAO;
    private static HoaDon_interface hoaDonDAO;
    private static SanPham_interface sanPhamDAO;
    private static KhachHang_interface khachHangDAO;
    private static PhieuNhapHang_interface phieuNhapHangDAO;
    private static ChiTietHoaDon_SanPham_interface chiTietHoaDonSanPhamDAO;
    private static ChiTietSanPham_PhieuNhap_interface chiTietSanPhamPhieuNhapDAO;

    // Thay đổi SERVER_IP thành địa chỉ IP thực của máy chủ
    private static final String SERVER_IP = "192.168.1.x"; // Thay đổi thành IP thực của máy chủ

    public static void main(String[] args) {
        try {
            // Set system properties for RMI
            System.setProperty("java.security.policy", "rmi.policy");
            
            // Get the registry
            registry = LocateRegistry.getRegistry(SERVER_IP, 9090);

            // Look up the DAO services from the registry
            taiKhoanDAO = (TaiKhoan_interface) registry.lookup("rmi://" + SERVER_IP + ":9090/taiKhoanDAO");
            caLamDAO = (CaLam_interface) registry.lookup("rmi://" + SERVER_IP + ":9090/caLamDAO");
            hoaDonDAO = (HoaDon_interface) registry.lookup("rmi://" + SERVER_IP + ":9090/hoaDonDAO");
            sanPhamDAO = (SanPham_interface) registry.lookup("rmi://" + SERVER_IP + ":9090/sanPhamDAO");
            khachHangDAO = (KhachHang_interface) registry.lookup("rmi://" + SERVER_IP + ":9090/khachHangDAO");
            phieuNhapHangDAO = (PhieuNhapHang_interface) registry.lookup("rmi://" + SERVER_IP + ":9090/phieuNhapHangDAO");
            chiTietHoaDonSanPhamDAO = (ChiTietHoaDon_SanPham_interface) registry.lookup("rmi://" + SERVER_IP + ":9090/chiTietHoaDonSanPhamDAO");
            chiTietSanPhamPhieuNhapDAO = (ChiTietSanPham_PhieuNhap_interface) registry.lookup("rmi://" + SERVER_IP + ":9090/chiTietSanPhamPhieuNhapDAO");

            System.out.println("Connected to RMI Server successfully!");
            
            // Display the main menu
            showMainMenu();
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    private static void showMainMenu() {
        int choice = 0;
        
        do {
            System.out.println("\n===== QUAN LY CUA HANG =====");
            System.out.println("1. Quan ly Tai Khoan");
            System.out.println("2. Quan ly Ca Lam");
            System.out.println("3. Quan ly Hoa Don");
            System.out.println("4. Quan ly San Pham");
            System.out.println("5. Quan ly Khach Hang");
            System.out.println("6. Quan ly Phieu Nhap Hang");
            System.out.println("7. Quan ly Chi Tiet Hoa Don - San Pham");
            System.out.println("8. Quan ly Chi Tiet San Pham - Phieu Nhap");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        manageTaiKhoan();
                        break;
                    case 2:
                        manageCaLam();
                        break;
                    case 3:
                        manageHoaDon();
                        break;
                    case 4:
                        manageSanPham();
                        break;
                    case 5:
                        manageKhachHang();
                        break;
                    case 6:
                        managePhieuNhapHang();
                        break;
                    case 7:
                        manageChiTietHoaDonSanPham();
                        break;
                    case 8:
                        manageChiTietSanPhamPhieuNhap();
                        break;
                    case 0:
                        System.out.println("Cam on ban da su dung chuong trinh!");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le. Vui long chon lai!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                choice = -1;
            } catch (Exception e) {
                System.err.println("Loi: " + e.getMessage());
                e.printStackTrace();
                choice = -1;
            }
        } while (choice != 0);
    }

    // Quan ly Tai Khoan
    private static void manageTaiKhoan() throws Exception {
        int choice = 0;
        
        do {
            System.out.println("\n===== QUAN LY TAI KHOAN =====");
            System.out.println("1. Xem danh sach tai khoan");
            System.out.println("2. Tim tai khoan theo ma");
            System.out.println("3. Them tai khoan moi");
            System.out.println("4. Cap nhat tai khoan");
            System.out.println("5. Xoa tai khoan");
            System.out.println("0. Quay lai");
            System.out.print("Chon chuc nang: ");
            
            choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    // Xem danh sach tai khoan
                    List<TaiKhoan> taiKhoans = taiKhoanDAO.readAll();
                    System.out.println("\nDanh sach tai khoan:");
                    for (TaiKhoan tk : taiKhoans) {
                        System.out.println(tk);
                    }
                    break;
                case 2:
                    // Tim tai khoan theo ma
                    System.out.print("Nhap ma tai khoan: ");
                    String maTK = scanner.nextLine();
                    TaiKhoan tk = taiKhoanDAO.read(maTK);
                    if (tk != null) {
                        System.out.println("Thong tin tai khoan: " + tk);
                    } else {
                        System.out.println("Khong tim thay tai khoan voi ma " + maTK);
                    }
                    break;
                case 0:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Chuc nang dang phat trien!");
            }
        } while (choice != 0);
    }

    // Quan ly Ca Lam
    private static void manageCaLam() throws Exception {
        int choice = 0;
        
        do {
            System.out.println("\n===== QUAN LY CA LAM =====");
            System.out.println("1. Xem danh sach ca lam");
            System.out.println("2. Tim ca lam theo ma");
            System.out.println("3. Them ca lam moi");
            System.out.println("4. Cap nhat ca lam");
            System.out.println("5. Xoa ca lam");
            System.out.println("0. Quay lai");
            System.out.print("Chon chuc nang: ");
            
            choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    // Xem danh sach ca lam
                    List<CaLam> caLams = caLamDAO.readAll();
                    System.out.println("\nDanh sach ca lam:");
                    for (CaLam cl : caLams) {
                        System.out.println(cl);
                    }
                    break;
                case 2:
                    // Tim ca lam theo ma
                    System.out.print("Nhap ma ca lam: ");
                    String maCa = scanner.nextLine();
                    CaLam cl = caLamDAO.read(maCa);
                    if (cl != null) {
                        System.out.println("Thong tin ca lam: " + cl);
                    } else {
                        System.out.println("Khong tim thay ca lam voi ma " + maCa);
                    }
                    break;
                case 0:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Chuc nang dang phat trien!");
            }
        } while (choice != 0);
    }

    // Quan ly Hoa Don
    private static void manageHoaDon() throws Exception {
        int choice = 0;
        
        do {
            System.out.println("\n===== QUAN LY HOA DON =====");
            System.out.println("1. Xem danh sach hoa don");
            System.out.println("2. Tim hoa don theo ma");
            System.out.println("0. Quay lai");
            System.out.print("Chon chuc nang: ");
            
            choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    // Xem danh sach hoa don
                    List<HoaDon> hoaDons = hoaDonDAO.readAll();
                    System.out.println("\nDanh sach hoa don:");
                    for (HoaDon hd : hoaDons) {
                        System.out.println(hd);
                    }
                    break;
                case 2:
                    // Tim hoa don theo ma
                    System.out.print("Nhap ma hoa don: ");
                    String maHD = scanner.nextLine();
                    HoaDon hd = hoaDonDAO.read(maHD);
                    if (hd != null) {
                        System.out.println("Thong tin hoa don: " + hd);
                    } else {
                        System.out.println("Khong tim thay hoa don voi ma " + maHD);
                    }
                    break;
                case 0:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Chuc nang dang phat trien!");
            }
        } while (choice != 0);
    }

    // Quan ly San Pham
    private static void manageSanPham() throws Exception {
        int choice = 0;
        
        do {
            System.out.println("\n===== QUAN LY SAN PHAM =====");
            System.out.println("1. Xem danh sach san pham");
            System.out.println("2. Tim san pham theo ma");
            System.out.println("0. Quay lai");
            System.out.print("Chon chuc nang: ");
            
            choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    // Xem danh sach san pham
                    List<SanPham> sanPhams = sanPhamDAO.readAll();
                    System.out.println("\nDanh sach san pham:");
                    for (SanPham sp : sanPhams) {
                        System.out.println(sp);
                    }
                    break;
                case 2:
                    // Tim san pham theo ma
                    System.out.print("Nhap ma san pham: ");
                    String maSP = scanner.nextLine();
                    SanPham sp = sanPhamDAO.read(maSP);
                    if (sp != null) {
                        System.out.println("Thong tin san pham: " + sp);
                    } else {
                        System.out.println("Khong tim thay san pham voi ma " + maSP);
                    }
                    break;
                case 0:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Chuc nang dang phat trien!");
            }
        } while (choice != 0);
    }

    // Quan ly Khach Hang
    private static void manageKhachHang() throws Exception {
        int choice = 0;
        
        do {
            System.out.println("\n===== QUAN LY KHACH HANG =====");
            System.out.println("1. Xem danh sach khach hang");
            System.out.println("2. Tim khach hang theo ma");
            System.out.println("0. Quay lai");
            System.out.print("Chon chuc nang: ");
            
            choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    // Xem danh sach khach hang
                    List<KhachHang> khachHangs = khachHangDAO.readAll();
                    System.out.println("\nDanh sach khach hang:");
                    for (KhachHang kh : khachHangs) {
                        System.out.println(kh);
                    }
                    break;
                case 2:
                    // Tim khach hang theo ma
                    System.out.print("Nhap ma khach hang: ");
                    String maKH = scanner.nextLine();
                    KhachHang kh = khachHangDAO.read(maKH);
                    if (kh != null) {
                        System.out.println("Thong tin khach hang: " + kh);
                    } else {
                        System.out.println("Khong tim thay khach hang voi ma " + maKH);
                    }
                    break;
                case 0:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Chuc nang dang phat trien!");
            }
        } while (choice != 0);
    }

    // Quan ly Phieu Nhap Hang
    private static void managePhieuNhapHang() throws Exception {
        int choice = 0;
        
        do {
            System.out.println("\n===== QUAN LY PHIEU NHAP HANG =====");
            System.out.println("1. Xem danh sach phieu nhap hang");
            System.out.println("2. Tim phieu nhap hang theo ma");
            System.out.println("0. Quay lai");
            System.out.print("Chon chuc nang: ");
            
            choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    // Xem danh sach phieu nhap hang
                    List<PhieuNhapHang> phieuNhapHangs = phieuNhapHangDAO.readAll();
                    System.out.println("\nDanh sach phieu nhap hang:");
                    for (PhieuNhapHang pnh : phieuNhapHangs) {
                        System.out.println(pnh);
                    }
                    break;
                case 2:
                    // Tim phieu nhap hang theo ma
                    System.out.print("Nhap ma phieu nhap hang: ");
                    String maPNH = scanner.nextLine();
                    PhieuNhapHang pnh = phieuNhapHangDAO.read(maPNH);
                    if (pnh != null) {
                        System.out.println("Thong tin phieu nhap hang: " + pnh);
                    } else {
                        System.out.println("Khong tim thay phieu nhap hang voi ma " + maPNH);
                    }
                    break;
                case 0:
                    System.out.println("Quay lai menu chinh");
                    break;
                default:
                    System.out.println("Chuc nang dang phat trien!");
            }
        } while (choice != 0);
    }

    // Quan ly Chi Tiet Hoa Don - San Pham
    private static void manageChiTietHoaDonSanPham() {
        System.out.println("\n===== QUAN LY CHI TIET HOA DON - SAN PHAM =====");
        System.out.println("Chuc nang dang phat trien!");
        pressEnterToContinue();
    }

    // Quan ly Chi Tiet San Pham - Phieu Nhap
    private static void manageChiTietSanPhamPhieuNhap() {
        System.out.println("\n===== QUAN LY CHI TIET SAN PHAM - PHIEU NHAP =====");
        System.out.println("Chuc nang dang phat trien!");
        pressEnterToContinue();
    }

    private static void pressEnterToContinue() {
        System.out.println("\nNhan Enter de tiep tuc...");
        scanner.nextLine();
    }
}
