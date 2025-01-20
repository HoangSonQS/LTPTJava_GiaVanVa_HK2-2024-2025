package entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
@EqualsAndHashCode
public class ChiTietHoaDon_SanPhamId implements Serializable {
    private String maHD;
    private String maSP;

}