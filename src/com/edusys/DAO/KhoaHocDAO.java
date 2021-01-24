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
import com.edusys.model.KhoaHoc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhoaHocDAO extends EduSysDAO<KhoaHoc, Integer>{

    @Override
    public void insert(KhoaHoc model) {
        insert_sql = "INSERT INTO KhoaHoc (MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV) VALUES (?, ?, ?, ?, ?,?)";
        JdbcHelper.executeUpdate(insert_sql,
                model.getMaCD(),
                model.getHocPhi(),
                model.getThoiLuong(),
                model.getNgayKG(),
                model.getGhiChu(),
                model.getMaNV());
    }

    @Override
    public void update(KhoaHoc model) {
        update_sql = "UPDATE KhoaHoc SET MaCD=?, HocPhi=?, ThoiLuong=?, NgayKG=?, GhiChu=?, MaNV=? WHERE MaKH=?";
        JdbcHelper.executeUpdate(update_sql,
                model.getMaCD(),
                model.getHocPhi(),
                model.getThoiLuong(),
                model.getNgayKG(),
                model.getGhiChu(),
                model.getMaNV(),
                model.getMaKH());
    }

    @Override
    public void delete(Integer id) {
        delete_sql = "DELETE FROM KhoaHoc WHERE MaKH=?";
        JdbcHelper.executeUpdate(delete_sql, id);
    }
    
    @Override
    public KhoaHoc selectById(Integer id) {
        selectById_sql = "SELECT * FROM KhoaHoc WHERE MaKH=?";
        List<KhoaHoc> list = selectBySql(selectById_sql, id);
        return list.isEmpty() ? null : list.get(0);
    }
    
    public List<KhoaHoc> selectByMaCD(String maCD) {
        selectById_sql = "SELECT * FROM KhoaHoc WHERE MaCD=?";
        List<KhoaHoc> list = selectBySql(selectById_sql, maCD);
        return list.isEmpty() ? null : list;
    }

    @Override
    public List<KhoaHoc> selectAll() {
        selectAll_sql = "SELECT * FROM KhoaHoc";
        return selectBySql(selectAll_sql);
    }

    @Override
    protected List<KhoaHoc> selectBySql(String sql, Object... args) {
        List<KhoaHoc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    KhoaHoc model = readFromResultSet(rs);
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

    private KhoaHoc readFromResultSet(ResultSet rs) throws SQLException {
        KhoaHoc model = new KhoaHoc();
        model.setMaKH(rs.getInt("MaKH"));
        model.setHocPhi(rs.getDouble("HocPhi"));
        model.setThoiLuong(rs.getInt("ThoiLuong"));
        model.setNgayKG(rs.getDate("NgayKG"));
        model.setGhiChu(rs.getString("GhiChu"));
        model.setMaNV(rs.getString("MaNV"));
        model.setNgayTao(rs.getDate("NgayTao"));
        model.setMaCD(rs.getString("MaCD"));

        return model;
    }
    
}
