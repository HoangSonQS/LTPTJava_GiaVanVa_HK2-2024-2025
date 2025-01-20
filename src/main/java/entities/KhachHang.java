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
@Table(name = "KhachHang")
public class KhachHang {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "MaKH", nullable = false)
    private String maKH;

    @Column(name = "TenKH", nullable = false)
    private String tenKH;

    @Column(name = "SDT", nullable = false)
    private String sdt;

    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<HoaDon> hoaDons = new HashSet<>();
}
