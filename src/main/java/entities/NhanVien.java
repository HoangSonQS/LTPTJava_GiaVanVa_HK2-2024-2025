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
    @Column(name = "maNV", nullable = false)
    private String maNV;

    @Column(name = "tenNV")
    private String tenNV;
    @Column(name = "email")
    private String email;
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "ngaySinh")
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
