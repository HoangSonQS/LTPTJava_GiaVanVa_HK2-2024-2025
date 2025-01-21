package daos;

import entities.CaLam;
import entities.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_CaLam_dao {

    private CaLam_dao caLamDao;
    private EntityManagerFactory emf;
    private EntityManager em;
    private TaiKhoan taiKhoan;

    @BeforeAll
    public void setup() {
        caLamDao = new CaLam_dao();
        emf = Persistence.createEntityManagerFactory("mariadb");
        em = emf.createEntityManager();
        taiKhoan = new TaiKhoan();
        taiKhoan.setMaTaiKhoan("TK001");
        // Set other necessary fields for TaiKhoan

        em.getTransaction().begin();
        em.persist(taiKhoan);
        em.getTransaction().commit();
    }

    @AfterAll
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    @Order(1)
    public void testCreate() {
        CaLam caLam = new CaLam();
        caLam.setMaCa("CA001");
        caLam.setGioBatDau(LocalDateTime.now());
        caLam.setGioKetThuc(LocalDateTime.now().plusHours(8));
        caLam.setTrangThai(true);
        caLam.setTaiKhoan(taiKhoan);

        caLamDao.create(caLam);

        CaLam retrieved = caLamDao.read("CA001");
        assertNotNull(retrieved);
        assertEquals("CA001", retrieved.getMaCa());
    }

    @Test
    @Order(2)
    public void testRead() {
        CaLam caLam = caLamDao.read("CA001");
        assertNotNull(caLam);
        assertEquals("CA001", caLam.getMaCa());
    }

    @Test
    @Order(3)
    public void testReadAll() {
        List<CaLam> caLams = caLamDao.readAll();
        assertNotNull(caLams);
        assertTrue(caLams.size() > 0);
    }

    @Test
    @Order(4)
    public void testUpdate() {
        CaLam caLam = caLamDao.read("CA001");
        assertNotNull(caLam, "CaLam should not be null");
        caLam.setTrangThai(false);
        caLamDao.update(caLam);

        CaLam updated = caLamDao.read("CA001");
        assertFalse(updated.isTrangThai());
    }

    @Test
    @Order(5)
    public void testDelete() {
        caLamDao.delete("CA001");
        CaLam deleted = caLamDao.read("CA001");
        assertNull(deleted);
    }
}