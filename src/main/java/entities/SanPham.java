package entities;

import enums.LoaiHang;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class SanPham {

    @Id
    @Column(name = "MaSP", nullable = false)
    private String maSP;

    @Column(name = "TenSP")
    private String tenSP;
    private LocalDateTime ngaySX;
    private LocalDateTime HSD;
    private double giaBan;
    private double giaNhap;
    private double Thue;
    private LoaiHang loaiHang;
}
