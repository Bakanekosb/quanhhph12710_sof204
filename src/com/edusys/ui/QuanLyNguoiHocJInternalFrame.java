/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.ui;

import com.edusys.Interface.IService;
import com.edusys.DAO.NguoiHocDAO;
import com.edusys.helper.DateHelper;
import com.edusys.helper.DialogHelper;
import com.edusys.helper.ShareHelper;
import com.edusys.model.NguoiHoc;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class QuanLyNguoiHocJInternalFrame extends javax.swing.JInternalFrame implements IService {

    /**
     * Creates new form QuanLyNguoiHocJInternalFrame
     */
    NguoiHocDAO nguoiHocDAO = new NguoiHocDAO();
    List<NguoiHoc> lst_nguoiHoc;
    DefaultTableModel tblModel = new DefaultTableModel(new String[]{"MÃ NH", "HỌ TÊN", "NGÀY SINH", "GIÓI TÍNH", "ĐIỆN THOẠI", "EMAIL", "NGÀY ĐK", "MÃ NV"}, 0);
    int rowIndex = -1;
    String keyword = "";
    int pageNumber = 1;
    int rowsOfPage = 10;
    int totalPage = (int) Math.ceil((double) nguoiHocDAO.getTotalRow(keyword) / rowsOfPage);

    public QuanLyNguoiHocJInternalFrame() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_maNguoiHoc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_hoten = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbo_gioiTinh = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_ngaySinh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_dienThoai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_ghiChu = new javax.swing.JTextPane();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_moi = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_prev = new javax.swing.JButton();
        btn_first = new javax.swing.JButton();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        panel_danhSach = new javax.swing.JPanel();
        panel_timKiem = new javax.swing.JPanel();
        txt_timKiem = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_danhSachNguoiHoc = new javax.swing.JTable();
        btn_firstPage = new javax.swing.JButton();
        btn_prevPage = new javax.swing.JButton();
        btn_nextPage = new javax.swing.JButton();
        btn_lastPage = new javax.swing.JButton();
        txt_soTrang = new javax.swing.JTextField();
        lbl_tongSoTrang = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("QUẢN LÝ NGƯỜI HỌC");

        jLabel2.setText("Mã người học");

        jLabel3.setText("Họ và tên");

        jLabel4.setText("Giới tính");

        cbo_gioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel5.setText("Ngày sinh");

        jLabel6.setText("Điện thoại");

        jLabel7.setText("Địa chỉ email");

        jLabel8.setText("Ghi chú");

        jScrollPane1.setViewportView(txt_ghiChu);

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_moi.setText("Mới");
        btn_moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moiActionPerformed(evt);
            }
        });

        btn_last.setText(">|");
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

        btn_next.setText(">>");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_prev.setText("<<");
        btn_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevActionPerformed(evt);
            }
        });

        btn_first.setText("|<");
        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });

        jDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(txt_maNguoiHoc)
                    .addComponent(txt_hoten)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(txt_email))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(btn_them)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_sua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_xoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_moi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_first)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_prev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_next)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_last))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(225, 225, 225)
                                .addComponent(jLabel5))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(214, 214, 214)
                                .addComponent(jLabel7))
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_dienThoai, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_gioiTinh, javax.swing.GroupLayout.Alignment.LEADING, 0, 230, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_maNguoiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_gioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_dienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa)
                    .addComponent(btn_moi)
                    .addComponent(btn_last)
                    .addComponent(btn_next)
                    .addComponent(btn_prev)
                    .addComponent(btn_first))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("CẬP NHẬT", panel);

        panel_danhSach.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panel_danhSachComponentShown(evt);
            }
        });

        panel_timKiem.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timKiemActionPerformed(evt);
            }
        });
        txt_timKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timKiemKeyReleased(evt);
            }
        });

        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_timKiemLayout = new javax.swing.GroupLayout(panel_timKiem);
        panel_timKiem.setLayout(panel_timKiemLayout);
        panel_timKiemLayout.setHorizontalGroup(
            panel_timKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_timKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_timKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        panel_timKiemLayout.setVerticalGroup(
            panel_timKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_timKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_timKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("TÌM KIẾM");

        tbl_danhSachNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_danhSachNguoiHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_danhSachNguoiHocMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_danhSachNguoiHoc);

        btn_firstPage.setText("|<");
        btn_firstPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstPageActionPerformed(evt);
            }
        });

        btn_prevPage.setText("<<");
        btn_prevPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevPageActionPerformed(evt);
            }
        });

        btn_nextPage.setText(">>");
        btn_nextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextPageActionPerformed(evt);
            }
        });

        btn_lastPage.setText(">|");
        btn_lastPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastPageActionPerformed(evt);
            }
        });

        txt_soTrang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_soTrangKeyReleased(evt);
            }
        });

        lbl_tongSoTrang.setText("/");

        javax.swing.GroupLayout panel_danhSachLayout = new javax.swing.GroupLayout(panel_danhSach);
        panel_danhSach.setLayout(panel_danhSachLayout);
        panel_danhSachLayout.setHorizontalGroup(
            panel_danhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_danhSachLayout.createSequentialGroup()
                .addGroup(panel_danhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_danhSachLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel_danhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                            .addComponent(panel_timKiem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_danhSachLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panel_danhSachLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btn_firstPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_prevPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_soTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_tongSoTrang)
                        .addGap(41, 41, 41)
                        .addComponent(btn_nextPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_lastPage)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_danhSachLayout.setVerticalGroup(
            panel_danhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_danhSachLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_danhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_firstPage)
                    .addComponent(btn_prevPage)
                    .addComponent(btn_nextPage)
                    .addComponent(btn_lastPage)
                    .addComponent(txt_soTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_tongSoTrang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("DANH SÁCH", panel_danhSach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tabs, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabs))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        insert();
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        update();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        delete();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_moiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moiActionPerformed
        clear();
    }//GEN-LAST:event_btn_moiActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        rowIndex = tbl_danhSachNguoiHoc.getRowCount() - 1;
        setModel(lst_nguoiHoc.get(rowIndex));
    }//GEN-LAST:event_btn_lastActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        rowIndex++;
        setModel(lst_nguoiHoc.get(rowIndex));
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        rowIndex--;
        setModel(lst_nguoiHoc.get(rowIndex));
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        rowIndex = 0;
        setModel(lst_nguoiHoc.get(rowIndex));
    }//GEN-LAST:event_btn_firstActionPerformed

    private void txt_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timKiemActionPerformed

    private void tbl_danhSachNguoiHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_danhSachNguoiHocMouseClicked

        rowIndex = tbl_danhSachNguoiHoc.getSelectedRow();
        setModel(lst_nguoiHoc.get(rowIndex));
        tabs.setSelectedIndex(0);
        setBtnEnabled(true);
    }//GEN-LAST:event_tbl_danhSachNguoiHocMouseClicked

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        ShareHelper.OPENING = false;
    }//GEN-LAST:event_formInternalFrameClosing

    private void jDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserPropertyChange
        txt_ngaySinh.setText(DateHelper.toString(jDateChooser.getDate()));
    }//GEN-LAST:event_jDateChooserPropertyChange

    private void btn_firstPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstPageActionPerformed
        changePage("first");
    }//GEN-LAST:event_btn_firstPageActionPerformed

    private void btn_prevPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevPageActionPerformed
        changePage("prev");
    }//GEN-LAST:event_btn_prevPageActionPerformed

    private void btn_nextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextPageActionPerformed
        changePage("next");
    }//GEN-LAST:event_btn_nextPageActionPerformed

    private void btn_lastPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastPageActionPerformed
        changePage("last");
    }//GEN-LAST:event_btn_lastPageActionPerformed

    private void txt_soTrangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_soTrangKeyReleased

    }//GEN-LAST:event_txt_soTrangKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        keyword = txt_timKiem.getText();
        loadTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_timKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiemKeyReleased
        keyword = txt_timKiem.getText();
        loadTable();
    }//GEN-LAST:event_txt_timKiemKeyReleased

    private void panel_danhSachComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panel_danhSachComponentShown
        loadTable();
    }//GEN-LAST:event_panel_danhSachComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_firstPage;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_lastPage;
    private javax.swing.JButton btn_moi;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_nextPage;
    private javax.swing.JButton btn_prev;
    private javax.swing.JButton btn_prevPage;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbo_gioiTinh;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_tongSoTrang;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel_danhSach;
    private javax.swing.JPanel panel_timKiem;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbl_danhSachNguoiHoc;
    private javax.swing.JTextField txt_dienThoai;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextPane txt_ghiChu;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_maNguoiHoc;
    private javax.swing.JTextField txt_ngaySinh;
    private javax.swing.JTextField txt_soTrang;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables

    private void init() {
//        setLocationRelativeTo(null);
//        this.setIconImage(XImage.getAppIcon());
        BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
        for (MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()) {
            basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
        }
        setTitle("QUẢN LÝ NGƯỜI HỌC");
        tbl_danhSachNguoiHoc.setModel(tblModel);
        loadTable();
        tabs.setSelectedIndex(1);
        setBtnEnabled(false);
        txt_soTrang.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    pageNumber = Integer.parseInt(txt_soTrang.getText());
                    pageNumber = pageNumber > totalPage ? totalPage : pageNumber;
                    loadTable();
                } catch (NumberFormatException e) {
                    System.out.println("loi");
                }
            }
        });
    }

    @Override
    public void loadTable() {
        tblModel.setRowCount(0);
        try {
            totalPage = (int) Math.ceil((double) nguoiHocDAO.getTotalRow(keyword) / rowsOfPage);
            if (pageNumber > totalPage) {
                pageNumber = 1;
            }
            lst_nguoiHoc = nguoiHocDAO.selectByKeyword(keyword, pageNumber, 10);
            for (NguoiHoc x : lst_nguoiHoc) {
                tblModel.addRow(new Object[]{x.getMaNH(), x.getHoTen(), x.isGioiTinh() ? "Nam" : "Nữ",
                    DateHelper.toString(x.getNgaySinh()), x.getDienThoai(), x.getEmail()});
            }
            btnStatus();
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu loadTable_nguoiHoc!");
        }
    }

    void changePage(String button) {
        switch (button) {
            case "first": {
                pageNumber = 1;
                break;
            }
            case "prev": {
                pageNumber--;
                break;
            }
            case "next": {
                pageNumber++;
                break;
            }
            case "last": {
                pageNumber = totalPage;
                break;
            }
        }
        loadTable();

    }

    void btnStatus() {
        txt_soTrang.setText(pageNumber + "");
        lbl_tongSoTrang.setText("/" + totalPage + "");
        btn_firstPage.setEnabled(pageNumber > 1);
        btn_prevPage.setEnabled(pageNumber > 1);
        btn_lastPage.setEnabled(pageNumber < totalPage);
        btn_nextPage.setEnabled(pageNumber < totalPage);
    }

    void setModel(NguoiHoc model) {
        txt_maNguoiHoc.setText(model.getMaNH());
        txt_hoten.setText(model.getHoTen());
        txt_dienThoai.setText(model.getHoTen());
        txt_email.setText(model.getEmail());
        txt_ghiChu.setText(model.getGhiChu());
        cbo_gioiTinh.setSelectedItem(model.isGioiTinh() ? "Nam" : "Nữ");
        txt_ngaySinh.setText(DateHelper.toString(model.getNgaySinh()));
        setBtnEnabled(true);
    }

    NguoiHoc getModel() {
        if (checkField().length() > 0) {
            DialogHelper.alert(this, checkField().toString());
            return null;
        }
        return new NguoiHoc(txt_maNguoiHoc.getText(), txt_hoten.getText(), DateHelper.toDate(txt_ngaySinh.getText()),
                cbo_gioiTinh.getSelectedIndex() == 0, txt_dienThoai.getText(),
                txt_email.getText(), txt_ghiChu.getText(), ShareHelper.USER.getMaNV(), DateHelper.now());
//        NguoiHoc(String maNH, String hoTen, Date ngaySinh, boolean gioiTinh, String dienThoai, String email, String ghiChu, String maNV)
    }

    @Override
    public StringBuilder checkField() {
        StringBuilder sb = new StringBuilder();
        String maNH = txt_maNguoiHoc.getText();
        String hoTen = txt_hoten.getText();
        String dienThoai = txt_dienThoai.getText();
        String email = txt_email.getText();
        if (maNH.isBlank()) {
            sb.append("Không được để trống mã người học\n");
        }
        if (hoTen.isBlank()) {
            sb.append("Không được để trống họ tên\n");
        }
        if (dienThoai.isBlank()) {
            sb.append("Không được để trống số điện thoại\n");
        }
        if (email.isBlank()) {
            sb.append("Không được để trống email\n");
        }
        return sb;
    }

    @Override
    public void setBtnEnabled(boolean maTonTai) {
        txt_maNguoiHoc.setEnabled(!maTonTai);
        btn_them.setEnabled(!maTonTai);
        btn_sua.setEnabled(maTonTai);
        btn_xoa.setEnabled(maTonTai);

        boolean first = rowIndex > 0;
        boolean last = rowIndex < tbl_danhSachNguoiHoc.getRowCount() - 1;
        btn_first.setEnabled(first && maTonTai);
        btn_last.setEnabled(last && maTonTai);
        btn_prev.setEnabled(first && maTonTai);
        btn_next.setEnabled(last && maTonTai);
    }

    @Override
    public void insert() {
        if (getModel() != null) {
            System.out.println(getModel().toString());
            try {
                nguoiHocDAO.insert(getModel());
//                loadTable();
                clear();
                DialogHelper.alert(this, "Thêm mới thành công!");
            } catch (Exception e) {
                System.out.println("loi");
                DialogHelper.alert(this, "Thêm mới thất bại!");
            }
        }
    }

    @Override
    public void update() {
        if (getModel() != null) {
            try {
                nguoiHocDAO.update(getModel());
                loadTable();
                DialogHelper.alert(this, "Cập nhật thành công!");
            } catch (Exception e) {
                DialogHelper.alert(this, "Cập nhật thất bại!");
            }
        }
    }

    @Override
    public void delete() {
        if (ShareHelper.USER.isVaiTro()) {
            if (rowIndex >= 0) {
                if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa người học này?")) {
                    String manh = txt_maNguoiHoc.getText();
                    try {
                        nguoiHocDAO.delete(manh);
                        loadTable();
                        clear();
                        DialogHelper.alert(this, "Xóa thành công!");
                    } catch (Exception e) {
                        DialogHelper.alert(this, "Xóa thất bại!");
                    }
                }
            }
        } else {
            DialogHelper.alert(this, "Chỉ trưởng phòng mới có quyền xóa!");
        }
    }

    @Override
    public void clear() {
        NguoiHoc model = new NguoiHoc();
        model.setMaNV(ShareHelper.USER.getMaNV());
        model.setNgayDK(DateHelper.now());
        this.setModel(model);
        txt_ngaySinh.setText("");
        setBtnEnabled(false);
    }
}
