package entities;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
@EqualsAndHashCode

public class ChiTietSanPham_PhieuNhapId{
    private String maPNH;
    private String maSP;
}
