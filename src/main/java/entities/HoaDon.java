package entities;

import enums.PhuongThucThanhToan;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "HoaDons")
public class HoaDon {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "MaHD", nullable = false)
    private String maHD;

    @Column(name = "MaNV", nullable = false)
    private String maNV;

    @Column(name = "ThoiGian", nullable = false)
    private LocalDateTime thoiGian;

    @Column(name = "TongSoLuongSP")
    private int tongSoLuongSP;

    @Enumerated(EnumType.STRING)
    @Column(name = "PhuongThucTT")
    private PhuongThucThanhToan phuongThucTT;

    @Column(name = "ThanhTien")
    private double thanhTien;

    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<ChiTietHoaDon_SanPham> chiTietHoaDonSanPhams = new HashSet<>();
}