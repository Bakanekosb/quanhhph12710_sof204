/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.model;

import com.edusys.helper.DateHelper;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class NguoiHoc {

    private String maNH;
    private String hoTen;
    private Date ngaySinh;
    private boolean gioiTinh = true;
    private String dienThoai;
    private String email;
    private String ghiChu;
    private String maNV;
    private Date ngayDK;

    public NguoiHoc() {
    }   

    public NguoiHoc(String maNH, String hoTen, Date ngaySinh, boolean gioiTinh, String dienThoai, String email, String ghiChu, String maNV, Date ngayDK) {
        this.maNH = maNH;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
        this.email = email;
        this.ghiChu = ghiChu;
        this.maNV = maNV;
        this.ngayDK = ngayDK;
    }
    
    

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }

    @Override
    public String toString() {
        return "NguoiHoc{" + "maNH=" + maNH + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", dienThoai=" + dienThoai + ", email=" + email + ", ghiChu=" + ghiChu + ", maNV=" + maNV + ", ngayDK=" + ngayDK + '}';
    }
    
    
}
