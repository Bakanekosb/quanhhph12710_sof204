/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.DAO;

import com.edusys.model.NhanVien;
import com.edusys.helper.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Dell
 */
public class NhanVienDAO extends EduSysDAO<NhanVien, String> {

    @Override
    public void insert(NhanVien model) {
        insert_sql = "INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(insert_sql,
                model.getMaNV(),
                model.getMatKhau(),
                model.getHoTen(),
                model.isVaiTro());
    }

    @Override
    public void update(NhanVien model) {
        update_sql = "UPDATE NhanVien SET MatKhau=?, HoTen=?, VaiTro=? WHERE MaNV=?";
        JdbcHelper.executeUpdate(update_sql,
                model.getMatKhau(),
                model.getHoTen(),
                model.isVaiTro(),
                model.getMaNV());
    }

    @Override
    public void delete(String id) {
        delete_sql = "DELETE FROM NhanVien WHERE MaNV=?";
        JdbcHelper.executeUpdate(delete_sql, id);
    }

    @Override
    public NhanVien selectById(String id) {
        selectById_sql = "SELECT * FROM NhanVien WHERE MaNV=?";
        List<NhanVien> list = selectBySql(selectById_sql, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<NhanVien> selectAll() {
        selectAll_sql = "SELECT * FROM NhanVien";
        return selectBySql(selectAll_sql);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
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
