
package daos;

import entities.ChiTietSanPham_PhieuNhap;
import entities.PhieuNhapHang;
import entities.SanPham;
import entities.ChiTietSanPham_PhieuNhapId;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_ChiTietSanPham_PhieuNhap_dao {

    private ChiTietSanPham_PhieuNhap_dao chiTietDao;
    private SanPham_dao sanPhamDao;
    private PhieuNhapHang_dao phieuNhapHangDao;

    @BeforeAll
    public void setup() {
        chiTietDao = new ChiTietSanPham_PhieuNhap_dao();
        sanPhamDao = new SanPham_dao();
        phieuNhapHangDao = new PhieuNhapHang_dao();
    }

    @Test
    @Order(1)
    public void testCreate() {
        SanPham sanPham = new SanPham();
        sanPham.setMaSP("SP001");
        sanPham.setTenSP("San Pham 1");
        sanPham.setNhaCC("Nha Cung Cap 1");
        sanPham.setSoLuongTon(100);
        sanPham.setGiaNhap(1000.0);
        sanPham.setGiaBan(1500.0);
        sanPham.setNgaySX(LocalDateTime.now());
        sanPham.setHanSD(LocalDateTime.now().plusDays(365));
        sanPham.setThoiGianCapNhat(LocalDateTime.now());
        sanPhamDao.create(sanPham);

        PhieuNhapHang phieuNhapHang = new PhieuNhapHang();
        phieuNhapHang.setMaPNH("PNH001");
        phieuNhapHang.setMaNV("NV001");
        phieuNhapHang.setTenNV("Nguyen Van A");
        phieuNhapHang.setThoiGian(LocalDateTime.now());
        phieuNhapHang.setTongSoLuongSP(100);
        phieuNhapHang.setThanhTien(100000.0);
        phieuNhapHangDao.create(phieuNhapHang);

        ChiTietSanPham_PhieuNhap chiTiet = new ChiTietSanPham_PhieuNhap();
        ChiTietSanPham_PhieuNhapId id = new ChiTietSanPham_PhieuNhapId();
        id.setMaPNH("PNH001");
        id.setMaSP("SP001");
        chiTiet.setId(id);
        chiTiet.setSanPham(sanPham);
        chiTiet.setPhieuNhapHang(phieuNhapHang);
        chiTiet.setSoLuongSP(50);
        chiTiet.setDonGia(1000.0);
        chiTietDao.create(chiTiet);

        ChiTietSanPham_PhieuNhap retrieved = chiTietDao.read(chiTiet.getId());
        assertNotNull(retrieved, "ChiTietSanPham_PhieuNhap should not be null");
        assertEquals(50, retrieved.getSoLuongSP());
    }

    @Test
    @Order(2)
    public void testRead() {
        ChiTietSanPham_PhieuNhapId id = new ChiTietSanPham_PhieuNhapId();
        id.setMaPNH("PNH001");
        id.setMaSP("SP001");
        ChiTietSanPham_PhieuNhap chiTiet = chiTietDao.read(id);
        assertNotNull(chiTiet, "ChiTietSanPham_PhieuNhap should not be null");
        assertEquals(id, chiTiet.getId());
    }

    @Test
    @Order(3)
    public void testReadAll() {
        List<ChiTietSanPham_PhieuNhap> chiTiets = chiTietDao.readAll();
        assertNotNull(chiTiets, "ChiTietSanPham_PhieuNhap list should not be null");
        assertTrue(chiTiets.size() > 0, "ChiTietSanPham_PhieuNhap list should not be empty");
    }

    @Test
    @Order(4)
    public void testUpdate() {
        ChiTietSanPham_PhieuNhapId id = new ChiTietSanPham_PhieuNhapId();
        id.setMaPNH("PNH001");
        id.setMaSP("SP001");
        ChiTietSanPham_PhieuNhap chiTiet = chiTietDao.read(id);
        assertNotNull(chiTiet, "ChiTietSanPham_PhieuNhap should not be null");
        chiTiet.setSoLuongSP(60);
        chiTietDao.update(chiTiet);

        ChiTietSanPham_PhieuNhap updated = chiTietDao.read(id);
        assertEquals(60, updated.getSoLuongSP());
    }

    @Test
    @Order(5)
    public void testDelete() {
        ChiTietSanPham_PhieuNhapId id = new ChiTietSanPham_PhieuNhapId();
        id.setMaPNH("PNH001");
        id.setMaSP("SP001");
        chiTietDao.delete(id);
        ChiTietSanPham_PhieuNhap deleted = chiTietDao.read(id);
        assertNull(deleted, "ChiTietSanPham_PhieuNhap should be null after deletion");
    }
}