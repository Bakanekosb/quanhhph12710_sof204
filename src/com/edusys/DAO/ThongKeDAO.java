/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.DAO;

/**
 *
 * @author Dell
 */
import com.edusys.helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ThongKeDAO {

    public List<Object[]> getNguoiHoc() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call SP_LUONGNGUOIHOC}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {   
                    Object[] model = {
                        rs.getInt("NAM"),
                        rs.getInt("SOLUONGNGUOIHOC"),
                        rs.getDate("NGAYSOMNHAT"),
                        rs.getDate("NGAYMUONNHAT")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }
        return list;

    }

    public List<Object[]> getBangDiem(Integer makh) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call SP_BANGDIEM (?)}";
                rs = JdbcHelper.executeQuery(sql, makh);
                while (rs.next()) {
                    double diem = rs.getDouble("Diem");
                    String xepLoai = "Xuất sắc";
                    if (diem < 0) {
                        xepLoai = "Chưa nhập";
                    } else if (diem < 3) {
                        xepLoai = "Kém";
                    } else if (diem < 5) {
                        xepLoai = "Yếu";
                    } else if (diem < 6.5) {
                        xepLoai = "Trung bình";
                    } else if (diem < 7.5) {
                        xepLoai = "Khá";
                    } else if (diem < 9) {
                        xepLoai = "Giỏi";
                    }
                    Object[] model = {
                        rs.getString("MaNH"),
                        rs.getString("HoTen"),
                        diem,
                        xepLoai
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {            
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Object[]> getDiemTheoChuyenDe() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call SP_DIEMCHUYENDE}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("TENCHUYENDE"),
                        rs.getInt("SOLUONGHOCVIEN"),
                        rs.getDouble("DIEMCAONHAT"),
                        rs.getDouble("DIEMTHAPNHAT"),
                        new DecimalFormat("#0.00").format(rs.getDouble("DIEMTRUNGBINH"))
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Object[]> getDoanhThu(int nam) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call SP_DOANHTHU (?)}";
                rs = JdbcHelper.executeQuery(sql, nam);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("CHUYENDE"),
                        rs.getInt("SOLUONGKHOAHOC"),
                        rs.getInt("SOLUONGHOCVIEN"),
                        rs.getDouble("DOANHTHU"),
                        rs.getDouble("HOCPHITHAPNHAT"),
                        rs.getDouble("HOCPHICAONHAT"),
                        rs.getDouble("HOCPHITRUNGBINH")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public List<Integer> getNamHoc() {
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call SP_NAMHOC}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {  
                    list.add(rs.getInt("NAM"));
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
