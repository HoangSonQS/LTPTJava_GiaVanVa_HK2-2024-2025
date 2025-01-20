package entities;

import enums.ChucVu;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "NhanVien")
public class NhanVien {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "MaNV", nullable = false)
    private String maNV;

    @Column(name = "TenNV")
    private String tenNV;
    @Column(name = "Email")
    private String email;
    @Column(name = "Sdt")
    private String sdt;
    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;
    @Column(name = "ChucVu")
    private ChucVu chucVu;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<HoaDon> hodDons = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "MaTaiKhoan", referencedColumnName = "maTaiKhoan", nullable = false)
    private TaiKhoan taiKhoan;
}
