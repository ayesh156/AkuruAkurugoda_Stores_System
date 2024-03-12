/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import static model.MyDateTimeUtils.getCurrentDateTime;
import model.MyMethods;
import model.MySQL;
import model.onlineMYSQL;

/**
 *
 * @author Dell
 */
public class CompanyRegistration extends javax.swing.JPanel {

    /**
     * Creates new form CompanyRegistration
     *
     */
    private SupplierRegistration supplierRegistration;
    private JDialog dailog;

    public void setSuplierRegistration(SupplierRegistration supplierRegistration) {
        this.supplierRegistration = supplierRegistration;

    }

    public void setDiaload(JDialog dailog) {
        this.dailog = dailog;
    }

    public CompanyRegistration() {
        initComponents();
        loadCompany();
        jButton33.setEnabled(false);
        MyMethods.setTableHeaderFontSize(jTable6, 16);
    }

    

    private void reset() {
        jTextField19.setText("");
        jTextField18.setText("");
        jButton32.setEnabled(true);
        jButton33.setEnabled(false);

    }

    private void loadCompany() {
        try {
            ResultSet resultset = MySQL.execute("SELECT * FROM `company` WHERE `name` LIKE '" + jTextField19.getText().trim() + "%' AND `hotline` LIKE '" + jTextField18.getText().trim() + "%'");

            DefaultTableModel model = (DefaultTableModel) jTable6.getModel();

            model.setRowCount(0);

            while (resultset.next()) {
                Vector<String> vector = new Vector<>();

                vector.add(resultset.getString("id"));
                vector.add(resultset.getString("name"));
                vector.add(resultset.getString("hotline"));

                model.addRow(vector);
            }

            jLabel60.setText("Registered companies (" + model.getRowCount() + ")");

        } catch (Exception e) {
            Login.logger.log(Level.WARNING, "CompanyRegistration_loadCompany", e);
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card5 = new javax.swing.JPanel();
        jPanel65 = new javax.swing.JPanel();
        jTextField18 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        jButton34 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel60 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel65.setMinimumSize(new java.awt.Dimension(100, 45));

        jTextField18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField18.setPreferredSize(new java.awt.Dimension(200, 45));
        jTextField18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField18KeyReleased(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel58.setText("Hotline");

        jTextField19.setFont(new java.awt.Font("Iskoola Pota", 0, 18)); // NOI18N
        jTextField19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField19KeyReleased(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel59.setText("Name");

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel65Layout.createSequentialGroup()
                .addGap(0, 253, Short.MAX_VALUE)
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField19)
            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel69.setPreferredSize(new java.awt.Dimension(0, 45));

        jButton34.setBackground(new java.awt.Color(0, 153, 255));
        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reload1.png"))); // NOI18N
        jButton34.setPreferredSize(new java.awt.Dimension(81, 40));
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton32.setBackground(new java.awt.Color(0, 153, 255));
        jButton32.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jButton32.setForeground(new java.awt.Color(255, 255, 255));
        jButton32.setText("Add company");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setBackground(new java.awt.Color(0, 153, 255));
        jButton33.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jButton33.setForeground(new java.awt.Color(255, 255, 255));
        jButton33.setText("Update company");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel69Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton34, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTable6.setAutoCreateRowSorter(true);
        jTable6.setFont(new java.awt.Font("Iskoola Pota", 0, 16)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Hotline"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.setFocusable(false);
        jTable6.setIntercellSpacing(new java.awt.Dimension(10, 0));
        jTable6.setRowHeight(40);
        jTable6.setSelectionBackground(new java.awt.Color(224, 224, 224));
        jTable6.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable6.getTableHeader().setReorderingAllowed(false);
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable6);
        if (jTable6.getColumnModel().getColumnCount() > 0) {
            jTable6.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable6.getColumnModel().getColumn(2).setPreferredWidth(0);
        }

        jLabel60.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel60.setText("Registered companies");

        javax.swing.GroupLayout card5Layout = new javax.swing.GroupLayout(card5);
        card5.setLayout(card5Layout);
        card5Layout.setHorizontalGroup(
            card5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(card5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card5Layout.createSequentialGroup()
                        .addGroup(card5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel69, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(card5Layout.createSequentialGroup()
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        card5Layout.setVerticalGroup(
            card5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE))
        );

        add(card5);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:

        String name = jTextField19.getText();
        String hotline = jTextField18.getText();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter company name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (name.length()>45) {
            JOptionPane.showMessageDialog(this, "Name length cannot exeed 45 characters", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (hotline.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter hotline number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                
                ResultSet resultset = MySQL.execute("SELECT * FROM `company` WHERE `name`='" + name + "' OR `hotline`='" + hotline + "'");

                if (resultset.next()) {
                    JOptionPane.showMessageDialog(this, "Company name or hotline number already used", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    MySQL.execute("INSERT INTO `company` (`name`,`hotline`,`last_update_time`) VALUES ('" + name + "','" + hotline + "','" + getCurrentDateTime() + "')");

                    reset();
                    loadCompany();
                    JOptionPane.showMessageDialog(this, "Company successfully registered", "Message", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception e) {
                Login.logger.log(Level.WARNING, "CompanyRegistration_register", e);
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_jButton32ActionPerformed

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        // TODO add your handling code here:
        int row = jTable6.getSelectedRow();
        jButton33.setEnabled(true);

        jTextField19.setText(String.valueOf(jTable6.getValueAt(row, 1)));
        jTextField18.setText(String.valueOf(jTable6.getValueAt(row, 2)));

        jButton32.setEnabled(false);

        if (evt.getClickCount() == 2 && supplierRegistration != null) {

            supplierRegistration.setCompanyName(String.valueOf(jTable6.getValueAt(row, 1)));
//          supplierRegistration.mobileFieldGrabFocus();
            supplierRegistration.setCompanyID(String.valueOf(jTable6.getValueAt(row, 0)));

            dailog.dispose();
            supplierRegistration.searchByCompany();
        }

    }//GEN-LAST:event_jTable6MouseClicked

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed

        int row = jTable6.getSelectedRow();

        String name = jTextField19.getText();
        String hotline = jTextField18.getText();
        String ID = String.valueOf(jTable6.getValueAt(row, 0));

        String getName = String.valueOf(jTable6.getValueAt(row, 1));
        String getHotline = String.valueOf(jTable6.getValueAt(row, 2));

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter company name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (name.length()>45) {
            JOptionPane.showMessageDialog(this, "Name length cannot exeed 45 characters", "Warning", JOptionPane.WARNING_MESSAGE);
        } else  if (hotline.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter hotline number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (getName.equals(name) && getHotline.equals(hotline)) {
            JOptionPane.showMessageDialog(this, "No any changes detected ", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {

                ResultSet resultset = MySQL.execute("SELECT * FROM `company` WHERE (`name`='" + name + "' OR `hotline`='" + hotline + "') AND `id`!='" + ID + "'");

                if (resultset.next()) {
                    JOptionPane.showMessageDialog(this, "Company name or hotline number already used", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    MySQL.execute("UPDATE `company` SET `name`='" + name + "',`hotline`='" + hotline + "', `last_update_time`='" + getCurrentDateTime() + "' WHERE `id`='" + ID + "'");

                    reset();
                    loadCompany();
                    JOptionPane.showMessageDialog(this, "Company successfully updated", "Message", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception e) {
                Login.logger.log(Level.WARNING, "CompanyRegistration_update", e);
                e.printStackTrace();

            }
        }        // TODO add your handling code here:


    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:        
        reset();
        loadCompany();

    }//GEN-LAST:event_jButton34ActionPerformed

    private void jTextField19KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField19KeyReleased
        // TODO add your handling code here:
        if (jTable6.getSelectedRow() == -1) {
            loadCompany();
        }

    }//GEN-LAST:event_jTextField19KeyReleased

    private void jTextField18KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField18KeyReleased
        // TODO add your handling code here:
        if (jTable6.getSelectedRow() == -1) {
            loadCompany();
        }
    }//GEN-LAST:event_jTextField18KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card5;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    // End of variables declaration//GEN-END:variables

}