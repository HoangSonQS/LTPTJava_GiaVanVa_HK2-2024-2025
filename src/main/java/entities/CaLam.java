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
    @Column(name = "maCa", nullable = false)
    private String maCa;

    @Column(name = "tenCa")
    private String tenCa;

    @Column(name = "giobatDau")
    private LocalDate gioBatDau;

    @Column(name = "gioKetThuc")
    private LocalDate gioKetThuc;

    @Column(name = "trangThai")
    private boolean trangThai;
}