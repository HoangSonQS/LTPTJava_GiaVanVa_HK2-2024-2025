/*
 *@ (#) CaLam.java        1.0     1/20/2025
 *Copyright (c) 2025 IUH.All rights reserved.
 */

package entities;/*
 *@descripsion:
 *@author : Khai Tien
 *@date: 1/20/2025
 *@version: 1.0
 */

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "CaLam")
public class CaLam {
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "MaCa", nullable = false)
    private String maCa;

    @Column(name = "TenCa")
    private String tenCa;

    @Column(name = "GioBatDau")
    private LocalDate gioBatDau;

    @Column(name = "GioKetThuc")
    private LocalDate gioKetThuc;

    @Column(name = "TrangThai")
    private boolean trangThai;

    @OneToMany(mappedBy = "caLam", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<HoaDon> hoaDons = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "maTaiKhoan", nullable = false)
    private TaiKhoan taiKhoan;
}