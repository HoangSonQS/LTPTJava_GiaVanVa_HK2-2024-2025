package entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ChiTietHoaDon_SanPham")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@ToString
public class ChiTietHoaDon_SanPham {

    @EmbeddedId
    private ChiTietHoaDon_SanPhamId id;

    @ManyToOne
    @MapsId("maHD")
    @JoinColumn(name = "MaHD", nullable = false)
    @ToString.Exclude
    private HoaDon hoaDon;

    @ManyToOne
    @MapsId("maSP")
    @JoinColumn(name = "MaSP", nullable = false)
    private SanPham sanPham;

    @Column(name = "SoLuongSP", nullable = false)
    private int soLuongSP;

    @Column(name = "DonGia", nullable = false)
    private double donGia;
}