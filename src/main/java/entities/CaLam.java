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

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

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

    @Column(name = "GiobatDau")
    private LocalDate gioBatDau;

    @Column(name = "GioKetThuc")
    private LocalDate gioKetThuc;

    @Column(name = "TrangThai")
    private boolean trangThai;
}