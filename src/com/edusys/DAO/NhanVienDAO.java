/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.DAO;

import com.edusys.Interface.IEduSysDAO;
import com.edusys.model.NhanVien;
import com.edusys.helper.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Dell
 */
public class NhanVienDAO implements IEduSysDAO<NhanVien, String> {

    @Override
    public void insert(NhanVien model) {
        String insert_sql = "INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(insert_sql,
                model.getMaNV(),
                model.getMatKhau(),
                model.getHoTen(),
                model.isVaiTro());
    }

    @Override
    public void update(NhanVien model) {
        String update_sql = "UPDATE NhanVien SET MatKhau=?, HoTen=?, VaiTro=? WHERE MaNV=?";
        JdbcHelper.executeUpdate(update_sql,
                model.getMatKhau(),
                model.getHoTen(),
                model.isVaiTro(),
                model.getMaNV());
    }

    @Override
    public void delete(String id) {
        String delete_sql = "DELETE FROM NhanVien WHERE MaNV=?";
        JdbcHelper.executeUpdate(delete_sql, id);
    }

    @Override
    public NhanVien selectById(String id) {
        String selectById_sql = "SELECT * FROM NhanVien WHERE MaNV=?";
        List<NhanVien> list = selectBySql(selectById_sql, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<NhanVien> selectAll() {
        String selectAll_sql = "SELECT * FROM NhanVien";
        return selectBySql(selectAll_sql);
    }

    public List<NhanVien> selectByPage(int pageNumber, int rowsOfPage) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call SP_SELECTNHANVIEN (?,?)}";
                rs = JdbcHelper.executeQuery(sql, pageNumber, rowsOfPage);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);

        }
        return list;
    }

    public int getTotalRow() {
        int total = 0;
        try {
            String getTotalsql = "SELECT COUNT(*) TOTAL FROM NHANVIEN";
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(getTotalsql);
                while (rs.next()) {
                    total = rs.getInt("Total");
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return total;
    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private NhanVien readFromResultSet(ResultSet rs) throws Exception {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setHoTen(rs.getString("HoTen"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        return model;
    }

}
