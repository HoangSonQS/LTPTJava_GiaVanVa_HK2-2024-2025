package entities;

import enums.ChucVu;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @EqualsAndHashCode.Include
    private String maNV;
    private String tenNV;
    private String email;
    private String sdt;
    private LocalDate ngaySinh;
    private ChucVu chucVu;
}
