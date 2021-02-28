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
import com.edusys.helper.JdbcHelper;
import com.edusys.model.HocVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HocVienDAO implements IEduSysDAO<HocVien, Integer> {

    @Override
    public void insert(HocVien model) {
        String insert_sql = "INSERT INTO HocVien(MaKH, MaNH, Diem) VALUES(?, ?, ?)";
        JdbcHelper.executeUpdate(insert_sql,
                model.getMaKH(),
                model.getMaNH(),
                model.getDiem());
    }

    @Override
    public void update(HocVien model) {
        String update_sql = "UPDATE HocVien SET Diem=? WHERE MaHV=?";
        JdbcHelper.executeUpdate(update_sql,
                model.getDiem(),
                model.getMaHV());
    }

    @Override
    public void delete(Integer id) {
        String delete_sql = "DELETE FROM HocVien WHERE MaHV=?";
        JdbcHelper.executeUpdate(delete_sql, id);
    }

    @Override
    public HocVien selectById(Integer id) {
        String selectById_sql = "SELECT * FROM HocVien WHERE MaHV=?";
        List<HocVien> list = selectBySql(selectById_sql, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<HocVien> selectAll() {
        String selectAll_sql = "SELECT * FROM HocVien";
        return selectBySql(selectAll_sql);
    }

    public List<HocVien> selectByCourse(int id) {
        String sql = "select * from hocvien where makh = ?";
        return selectBySql(sql, id);
    }

    @Override
    public List<HocVien> selectBySql(String sql, Object... args) {
        List<HocVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HocVien model = readFromResultSet(rs);
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

    private HocVien readFromResultSet(ResultSet rs) throws SQLException {
        HocVien model = new HocVien();
        model.setMaHV(rs.getInt("MaHV"));
        model.setMaKH(rs.getInt("MaKH"));
        model.setMaNH(rs.getString("MaNH"));
        model.setDiem(rs.getDouble("Diem"));
        return model;
    }

}
