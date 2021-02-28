/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.Interface;

import java.util.List;

/**
 *
 * @author Dell
 * @param <EntityType>
 * @param <KeyType>
 */
public interface  IEduSysDAO<EntityType, KeyType> {
     public void insert(EntityType model);
     public void update(EntityType model);
     public void delete(KeyType id);
     public EntityType selectById(KeyType id);
     public List<EntityType> selectAll();
     List<EntityType> selectBySql(String sql, Object...args);
}
