package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


@Entity
@Table(name = "PhieuNhapHangs")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PhieuNhapHang {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "MaPNH", nullable = false)
    private String maPNH;

    @Column(name = "MaNV", nullable = false)
    private String maNV;

    @Column(name = "TenNV")
    private String tenNV;
    @Column(name = "ThoiGian")
    private LocalDateTime thoiGian;
    @Column(name = "TongSoLuongSP")
    private int tongSoLuongSP;
    @Column(name = "ThanhTien")
    private double thanhTien;
}
