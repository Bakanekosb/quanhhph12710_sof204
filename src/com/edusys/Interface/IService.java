/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.Interface;

/**
 *
 * @author Dell
 */
public interface IService {
    void loadTable();
    void setBtnEnabled(boolean maTonTai);
    StringBuilder checkField();
    void insert();
    void update();
    void delete();
    void clear();
}