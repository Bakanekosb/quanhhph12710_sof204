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
import com.edusys.model.ChuyenDe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChuyenDeDAO implements IEduSysDAO<ChuyenDe, String> {
    
    @Override
    public void insert(ChuyenDe model) {
        String insert_sql = "INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, MoTa) VALUES (?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(insert_sql,
                model.getMaCD(),
                model.getTenCD(),
                model.getHocPhi(),
                model.getThoiLuong(),
                model.getHinh(),
                model.getMoTa());
    }

    @Override
    public void update(ChuyenDe model) {
        String update_sql = "UPDATE ChuyenDe SET TenCD=?, HocPhi=?, ThoiLuong=?, Hinh=?, MoTa=? WHERE MaCD=?";
        JdbcHelper.executeUpdate(update_sql,
                model.getTenCD(),
                model.getHocPhi(),
                model.getThoiLuong(),
                model.getHinh(),
                model.getMoTa(),
                model.getMaCD());
    }

    @Override
    public void delete(String id) {
        String delete_sql = "DELETE FROM ChuyenDe WHERE MaCD=?";
        JdbcHelper.executeUpdate(delete_sql, id);
    }

    @Override
    public ChuyenDe selectById(String id) {
        String selectById_sql = "SELECT * FROM ChuyenDe WHERE MaCD=?";
        List<ChuyenDe> list = selectBySql(selectById_sql, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<ChuyenDe> selectAll() {
        String selectAll_sql = "SELECT * FROM ChuyenDe";
        return selectBySql(selectAll_sql);
    }

    @Override
    public List<ChuyenDe> selectBySql(String sql, Object... args) {
        List<ChuyenDe> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    ChuyenDe model = readFromResultSet(rs);
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
    
     public ChuyenDe selectByName(String name) {
        String selectById_sql = "SELECT * FROM ChuyenDe WHERE TenCD=?";
        List<ChuyenDe> list = selectBySql(selectById_sql, name);
        return list.isEmpty() ? null : list.get(0);
    }
       

    private ChuyenDe readFromResultSet(ResultSet rs) throws SQLException {
        ChuyenDe model = new ChuyenDe();
        model.setMaCD(rs.getString("MaCD"));
        model.setHinh(rs.getString("Hinh"));
        model.setHocPhi(rs.getDouble("HocPhi"));
        model.setMoTa(rs.getString("MoTa"));
        model.setTenCD(rs.getString("TenCD"));
        model.setThoiLuong(rs.getInt("ThoiLuong"));
        return model;
    }

}
