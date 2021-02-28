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
import com.edusys.Interface.IEduSysDAO;
import com.edusys.helper.DateHelper;
import com.edusys.helper.JdbcHelper;
import com.edusys.model.NguoiHoc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NguoiHocDAO implements IEduSysDAO<NguoiHoc, String> {

    @Override
    public void insert(NguoiHoc model) {
        String insert_sql = "INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, ngayDK) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(insert_sql,
                model.getMaNH(),
                model.getHoTen(),
                model.getNgaySinh(),
                model.isGioiTinh(),
                model.getDienThoai(),
                model.getEmail(),
                model.getGhiChu(),
                model.getMaNV(),
                model.getNgayDK());
    }

    @Override
    public void update(NguoiHoc model) {
        String update_sql = "UPDATE NguoiHoc SET HoTen=?, NgaySinh=?, GioiTinh=?, DienThoai=?, Email=?, GhiChu=?,MaNV =  ? WHERE  MaNH =  ?";
        JdbcHelper.executeUpdate(update_sql,
                model.getHoTen(),
                model.getNgaySinh(),
                model.isGioiTinh(),
                model.getDienThoai(),
                model.getEmail(),
                model.getGhiChu(),
                model.getMaNV(),
                model.getMaNH());
    }

    @Override
    public void delete(String id) {
        String delete_sql = "DELETE FROM NguoiHoc WHERE MaNH=?";
        JdbcHelper.executeUpdate(delete_sql, id);
    }

    @Override
    public NguoiHoc selectById(String id) {
        String selectById_sql = "SELECT * FROM NguoiHoc WHERE MaNH=?";
        List<NguoiHoc> list = selectBySql(selectById_sql, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<NguoiHoc> selectAll() {
        String selectAll_sql = "SELECT * FROM NguoiHoc";
        return selectBySql(selectAll_sql);
    }

//    public List<NguoiHoc> selectByPage(int pageNumber, int rowsOfPage) {
//        List<NguoiHoc> list = new ArrayList<>();
//        try {
//            ResultSet rs = null;
//            try {
//                String sql = "{call SP_SELECTNGUOIHOC (?,?)}";
//                rs = JdbcHelper.executeQuery(sql);
//                while (rs.next()) {
//                    list.add(readFromResultSet(rs));
//                }
//            } finally {
//                rs.getStatement().getConnection().close();
//            }
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//
//        }
//        return list;
//    }
    @Override
    public List<NguoiHoc> selectBySql(String sql, Object... args) {
        List<NguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NguoiHoc model = readFromResultSet(rs);
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

//    public List<NguoiHoc> selectByKeyword(String keyword) {
//        String sql = "SELECT * FROM NguoiHoc WHERE HoTen LIKE ?";
//        return selectBySql(sql, "%" + keyword + "%");
//    }
    public List<NguoiHoc> selectByKeyword(String keyword, int pageNumber, int rowsOfPage) {
        List<NguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call SP_SELECTNGUOIHOC (?,?,?)}";
                rs = JdbcHelper.executeQuery(sql, "%" + keyword + "%", pageNumber, rowsOfPage);
                while (rs.next()) {
                    NguoiHoc model = readFromResultSet(rs);
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

    public int getTotalRow(String keyword)  {
        int total = 0;
        try {

            ResultSet rs = null;
            try {
                String sql = "{call SP_TOTALNGUOIHOC (?)}";
                rs = JdbcHelper.executeQuery(sql, "%" + keyword + "%");
                while (rs.next()) {
                    total = rs.getInt("Total");
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return total;
    }

//    public int getTotal() {
//        int total = 0;
//        try {
//            String getTotalsql = "SELECT COUNT(*) TOTAL FROM NGUOIHOC";
//            ResultSet rs = null;
//            try {
//                rs = JdbcHelper.executeQuery(getTotalsql);
//                while (rs.next()) {
//                    total = rs.getInt("Total");
//                }
//            } finally {
//                rs.getStatement().getConnection().close();
//            }
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//        return total;
//    }
    public List<NguoiHoc> selectByCourse(Integer makh) {
        String sql = "SELECT * FROM NguoiHoc WHERE MaNH NOT IN (SELECT MaNH FROM HocVien WHERE MaKH=?)";
        return selectBySql(sql, makh);
    }

    private NguoiHoc readFromResultSet(ResultSet rs) throws SQLException {
        NguoiHoc model = new NguoiHoc();
        model.setMaNH(rs.getString("MaNH"));
        model.setHoTen(rs.getString("HoTen"));
        model.setNgaySinh(rs.getDate("NgaySinh"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setDienThoai(rs.getString("DienThoai"));
        model.setEmail(rs.getString("Email"));
        model.setGhiChu(rs.getString("GhiChu"));
        model.setMaNV(rs.getString("MaNV"));
        model.setNgayDK(rs.getDate("NgayDK"));
        return model;
    }
}
