import entities.*;
import enums.ChucVu;
import enums.LoaiHang;
import enums.PhuongThucThanhToan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("mariadb")
                .createEntityManager();

        EntityTransaction tr = em.getTransaction();
        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            SanPham sanPham = new SanPham();
            sanPham.setMaSP(faker.idNumber().valid()); // Set the identifier
            sanPham.setTenSP(faker.commerce().productName());
            sanPham.setNhaCC(faker.company().name());
            sanPham.setSoLuongTon(faker.number().numberBetween(1, 100));
            sanPham.setGiaNhap(faker.number().randomDouble(2, 1, 1000));
            sanPham.setGiaBan(faker.number().randomDouble(2, 1, 1000));
            sanPham.setThoiGianCapNhat(LocalDateTime.now());
            sanPham.setLoaiHang(faker.options().option(LoaiHang.class));
//
//            sanPham.setTenSP(tenSP);
//            sanPham.setNhaCC(nhaCC);
//            sanPham.setSoLuongTon(soLuongTon);
//            sanPham.setGiaNhap(giaNhap);
//            sanPham.setGiaBan(giaBan);
//            sanPham.setThoiGianCapNhat(thoiGianCapNhat);
//            sanPham.setLoaiHang(loaiHang);
//
//            NhanVien nhanVien = new NhanVien();
//            String tenNV = faker.name().fullName();
//            String cccd = faker.number().digits(12);
//            String diaChi = faker.address().fullAddress();
//            String email = faker.internet().emailAddress();
//            String sdt = faker.phoneNumber().cellPhone();
//            LocalDate ngaySinh = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//            ChucVu chucVu = faker.options().option(ChucVu.class);
//
//            nhanVien.setTenNV(tenNV);
//            nhanVien.setCccd(cccd);
//            nhanVien.setDiaChi(diaChi);
//            nhanVien.setEmail(email);
//            nhanVien.setSdt(sdt);
//            nhanVien.setNgaySinh(ngaySinh);
//            nhanVien.setChucVu(chucVu);
//
//            TaiKhoan taiKhoan = new TaiKhoan();
//            String tenDangNhap = faker.name().username();
//            String matKhau = faker.internet().password();
//            LocalDateTime thoiGianDangNhap = LocalDateTime.now();
//
//            taiKhoan.setTenDangNhap(tenDangNhap);
//            taiKhoan.setMatKhau(matKhau);
//            taiKhoan.setThoiGianDangNhap(thoiGianDangNhap);
//
//            PhieuNhapHang phieuNhapHang = new PhieuNhapHang();
//
//            String maNV = nhanVien.getMaNV();
//            String tenNVPhieuNhap = nhanVien.getTenNV();
//            LocalDateTime thoiGian = LocalDateTime.now();
//            int tongSoLuongSP = faker.number().numberBetween(1, 100);
//            double thanhTien = faker.number().randomDouble(2, 1, 1000);
//
//            phieuNhapHang.setMaNV(maNV);
//            phieuNhapHang.setTenNV(tenNVPhieuNhap);
//            phieuNhapHang.setThoiGian(thoiGian);
//            phieuNhapHang.setTongSoLuongSP(tongSoLuongSP);
//            phieuNhapHang.setThanhTien(thanhTien);
//
//            ChiTietSanPham_PhieuNhap chiTietSanPhamPhieuNhap = new ChiTietSanPham_PhieuNhap();
//            int soLuong = faker.number().numberBetween(1, 100);
//            double donGia = faker.number().randomDouble(2, 1, 1000);
//
//            chiTietSanPhamPhieuNhap.setSoLuongSP(soLuong);
//            chiTietSanPhamPhieuNhap.setDonGia(donGia);
//
//            KhachHang khachHang = new KhachHang();
//            String tenKH = faker.name().fullName();
//            String sdtKH = faker.phoneNumber().cellPhone();
//
//            khachHang.setTenKH(tenKH);
//            khachHang.setSdt(sdtKH);
//
//            HoaDon hoaDon = new HoaDon();
//
//            String maKH = khachHang.getMaKH();
//            LocalDateTime thoiGianHD = LocalDateTime.now();
//            int tongSoLuongSPHD = faker.number().numberBetween(1, 100);
//            PhuongThucThanhToan phuongThucTT = faker.options().option(PhuongThucThanhToan.class);
//            double thanhTienHD = faker.number().randomDouble(2, 1, 1000);
//
//            hoaDon.setMaNV(maNV);
//            hoaDon.setMaKH(maKH);
//            hoaDon.setThoiGian(thoiGianHD);
//            hoaDon.setTongSoLuongSP(tongSoLuongSPHD);
//            hoaDon.setPhuongThucTT(phuongThucTT);
//            hoaDon.setThanhTien(thanhTienHD);
//
//            ChiTietHoaDon_SanPham chiTietHoaDonSanPham = new ChiTietHoaDon_SanPham();
//            int soLuongSP = faker.number().numberBetween(1, 100);
//            double donGiaSP = faker.number().randomDouble(2, 1, 1000);
//
//            chiTietHoaDonSanPham.setSoLuongSP(soLuongSP);
//            chiTietHoaDonSanPham.setDonGia(donGiaSP);
//
//            CaLam caLam = new CaLam();
//            LocalDateTime gioBatDau = LocalDateTime.now();
//            LocalDateTime gioKetThuc = LocalDateTime.now();
//            boolean trangThai = faker.bool().bool();
//
//            caLam.setGioBatDau(gioBatDau);
//            caLam.setGioKetThuc(gioKetThuc);
//            caLam.setTrangThai(trangThai);


            tr.begin();
            em.persist(sanPham);
//            em.persist(caLam);
//            em.persist(taiKhoan);
//            em.persist(nhanVien);
//            em.persist(khachHang);
//            em.persist(hoaDon);
//            em.persist(phieuNhapHang);
//            em.persist(chiTietHoaDonSanPham);
//            em.persist(chiTietSanPhamPhieuNhap);
            tr.commit();
        }

        em.close();

    }
}
