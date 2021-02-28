/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.helper;

import com.edusys.DAO.ChuyenDeDAO;
import com.edusys.DAO.KhoaHocDAO;
import com.edusys.model.ChuyenDe;
import com.edusys.model.HocVien;
import com.edusys.model.KhoaHoc;
import com.edusys.model.NguoiHoc;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextField;

/**
 *
 * @author Dell
 */
public class Utils {

    KhoaHocDAO khoaHocDAO = new KhoaHocDAO();
    ChuyenDeDAO chuyenDeDAO = new ChuyenDeDAO();
    List<KhoaHoc> lst_khoaHoc = new ArrayList<>();
    List<ChuyenDe> lst_chuyenDe = new ArrayList<>();
    List<NguoiHoc> lst_nguoiHoc = new ArrayList<>();
    List<HocVien> lst_hocVien = new ArrayList<>();
    KhoaHoc kh;

    public String getTenKH(int id) {
        kh = khoaHocDAO.selectById(id);
        String tenCD = chuyenDeDAO.selectById(kh.getMaCD()).getTenCD();
        return tenCD + " (" + DateHelper.toString(kh.getNgayKG()) + ") " + "MaKH: " + kh.getMaKH();
    }

   

}
