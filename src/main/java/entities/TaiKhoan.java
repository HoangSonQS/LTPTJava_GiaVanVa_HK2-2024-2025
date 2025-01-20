package entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TaiKhoan")
public class TaiKhoan {
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "maTaiKhoan", nullable = false)
    private String maTaiKhoan;

    @OneToOne(mappedBy = "taiKhoan", cascade = CascadeType.ALL, orphanRemoval = true)
    private NhanVien nhanVien;
    @Column(name = "tenDangNhap", nullable = false)
    private String tenDangNhap;
    @Column(name = "matKhau", nullable = false)
    private String matKhau;

    @OneToMany(mappedBy = "taiKhoan", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<CaLam> caLams = new HashSet<>();
}
