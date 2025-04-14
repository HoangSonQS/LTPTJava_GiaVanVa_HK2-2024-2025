package iuh.fit.entities;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Embeddable
@EqualsAndHashCode
public class ChiTietHoaDon_SanPhamId implements Serializable {
    private String maHD;
    private String maSP;

    public ChiTietHoaDon_SanPhamId(String pnh00123, String sp001) {

    }

    public ChiTietHoaDon_SanPhamId() {

    }
}
