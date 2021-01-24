/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.DAO;

import java.util.List;

/**
 *
 * @author Dell
 * @param <EntityType>
 * @param <KeyType>
 */
abstract public class EduSysDAO<EntityType, KeyType> {
    protected String insert_sql;
    protected String update_sql;
    protected String delete_sql;
    protected String selectAll_sql;
    protected String selectById_sql;
    abstract public void insert(EntityType model);
    abstract public void update(EntityType model);
    abstract public void delete(KeyType id);
    abstract public EntityType selectById(KeyType id);
    abstract public List<EntityType> selectAll();
    abstract protected List<EntityType> selectBySql(String sql, Object...args);
}
