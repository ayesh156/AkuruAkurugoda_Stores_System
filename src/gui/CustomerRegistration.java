/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import static gui.Login.logger;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
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
import model.MySQLSyncApp;
import model.onlineMYSQL;

/**
 *
 * @author Dell
 */
public class CustomerRegistration extends javax.swing.JPanel {

    /**
     * Creates new form CustomerRegistration
     */
    MySQLSyncApp sync = new MySQLSyncApp();
    Home home;
    JDialog dailog;

    public void setHome(Home home) {
        this.home = home;

    }

//    HomeDelivery homeDelivery;
//
//    public void setHomeDelivery() {
//
//    }
    public void setDiaload(JDialog dailog) {
        this.dailog = dailog;
    }

//     private Invoice invoice;
//
//    public void setInvoice(Invoice invoice) {
//        this.invoice = invoice;
//    }
    public CustomerRegistration() {
        initComponents();
        loadCustomers("first_name");
        MyMethods.setTableHeaderFontSize(jTable5, 16);
        jButton31.setEnabled(false);
        jTextField18.setEditable(false);
    }

    private void reset() {
        jTextField13.setEditable(true);
        jTextField18.setEditable(false);
        jTextField15.setText("");
        jTextField16.setText("");
        jTextField17.setText("");
        jTextField13.setText("");
        jLabel57.setText(" ");
        jTextField18.setText("");
//        jTextField1.grabFocus();
//        jComboBox1.setSelectedIndex(0);
//        jTable1.clearSelection();
//        jButton1.setEnabled(true);

    }

    private void loadCustomers(String column) {

        String firstname = jTextField15.getText().trim();
        String lastname = jTextField16.getText().trim();
        String mobile = jTextField13.getText().trim();
        String email = jTextField17.getText().trim();

        try {
            ResultSet resultset = MySQL.execute("SELECT * FROM `customer` WHERE (`email` LIKE '" + email + "%' AND `last_name` LIKE '" + lastname + "%' "
                    + "AND `first_name` LIKE '" + firstname + "%' AND `mobile` LIKE '" + mobile + "%') AND  `email` <> 'no email'"
                    + "ORDER BY `" + column + "` ASC ");

            DefaultTableModel model = (DefaultTableModel) jTable5.getModel();

            model.setRowCount(0);

            while (resultset.next()) {

                Vector<String> vector = new Vector<>();

                vector.add(resultset.getString("mobile"));
                vector.add(resultset.getString("first_name"));
                vector.add(resultset.getString("last_name"));
                vector.add(resultset.getString("email"));
                vector.add(resultset.getString("balance_payment"));

                model.addRow(vector);

            }
            jLabel5.setText("Registered customers (" + model.getRowCount() + ")");
        } catch (Exception e) {
            logger.log(Level.WARNING, "Load_customers", e);
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

        card4 = new javax.swing.JPanel();
        jPanel70 = new javax.swing.JPanel();
        jPanel89 = new javax.swing.JPanel();
        jPanel63 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jPanel64 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jPanel90 = new javax.swing.JPanel();
        jPanel67 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jPanel68 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jPanel69 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jPanel87 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jPanel91 = new javax.swing.JPanel();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jPanel66 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        card4.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jPanel70.setLayout(new java.awt.GridLayout(1, 3, 20, 0));

        jPanel89.setLayout(new java.awt.GridLayout(3, 0, 0, 10));

        jPanel63.setLayout(new java.awt.BorderLayout());

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel50.setText("Mobile");
        jLabel50.setPreferredSize(new java.awt.Dimension(90, 16));
        jPanel63.add(jLabel50, java.awt.BorderLayout.WEST);

        jTextField13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField13KeyReleased(evt);
            }
        });
        jPanel63.add(jTextField13, java.awt.BorderLayout.CENTER);

        jPanel89.add(jPanel63);

        jPanel64.setLayout(new java.awt.BorderLayout());

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel53.setText("First name");
        jLabel53.setPreferredSize(new java.awt.Dimension(90, 16));
        jPanel64.add(jLabel53, java.awt.BorderLayout.WEST);

        jTextField15.setFont(new java.awt.Font("Iskoola Pota", 0, 18)); // NOI18N
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });
        jTextField15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField15KeyReleased(evt);
            }
        });
        jPanel64.add(jTextField15, java.awt.BorderLayout.CENTER);

        jPanel89.add(jPanel64);

        jPanel70.add(jPanel89);

        jPanel90.setLayout(new java.awt.GridLayout(3, 0, 0, 10));

        jPanel67.setLayout(new java.awt.BorderLayout());

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel54.setText("<html> <p>Last name</p> <html>");
        jLabel54.setPreferredSize(new java.awt.Dimension(90, 16));
        jPanel67.add(jLabel54, java.awt.BorderLayout.WEST);

        jTextField16.setFont(new java.awt.Font("Iskoola Pota", 0, 18)); // NOI18N
        jTextField16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField16KeyReleased(evt);
            }
        });
        jPanel67.add(jTextField16, java.awt.BorderLayout.CENTER);

        jPanel90.add(jPanel67);

        jPanel68.setLayout(new java.awt.BorderLayout());

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel55.setText("Email");
        jLabel55.setPreferredSize(new java.awt.Dimension(90, 16));
        jPanel68.add(jLabel55, java.awt.BorderLayout.WEST);

        jTextField17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });
        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField17KeyReleased(evt);
            }
        });
        jPanel68.add(jTextField17, java.awt.BorderLayout.CENTER);

        jPanel90.add(jPanel68);

        jPanel69.setLayout(new java.awt.BorderLayout());

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel58.setText("Balance");
        jLabel58.setPreferredSize(new java.awt.Dimension(90, 16));
        jPanel69.add(jLabel58, java.awt.BorderLayout.WEST);

        jTextField18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });
        jTextField18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField18KeyReleased(evt);
            }
        });
        jPanel69.add(jTextField18, java.awt.BorderLayout.CENTER);

        jPanel90.add(jPanel69);

        jPanel70.add(jPanel90);

        jPanel87.setLayout(new javax.swing.BoxLayout(jPanel87, javax.swing.BoxLayout.LINE_AXIS));

        jTable5.setAutoCreateRowSorter(true);
        jTable5.setFont(new java.awt.Font("Iskoola Pota", 0, 16)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mobile", "First Name", "Last name", "Email", "Balance Payment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.setIntercellSpacing(new java.awt.Dimension(10, 0));
        jTable5.setRowHeight(40);
        jTable5.setSelectionBackground(new java.awt.Color(224, 224, 224));
        jTable5.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable5.getTableHeader().setReorderingAllowed(false);
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        jPanel87.add(jScrollPane5);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setText("Registered customers");

        jPanel91.setLayout(new java.awt.GridLayout(3, 0, 0, 10));

        jButton30.setBackground(new java.awt.Color(0, 153, 255));
        jButton30.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jButton30.setForeground(new java.awt.Color(255, 255, 255));
        jButton30.setText("Register customer");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel91.add(jButton30);

        jButton31.setBackground(new java.awt.Color(0, 153, 255));
        jButton31.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jButton31.setForeground(new java.awt.Color(255, 255, 255));
        jButton31.setText("Update customer");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel91.add(jButton31);

        jPanel66.setLayout(new java.awt.BorderLayout());

        jLabel56.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel56.setText("Total invoices : ");
        jLabel56.setPreferredSize(new java.awt.Dimension(130, 16));
        jPanel66.add(jLabel56, java.awt.BorderLayout.WEST);

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("...");
        jLabel57.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel66.add(jLabel57, java.awt.BorderLayout.CENTER);

        jPanel91.add(jPanel66);

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout card4Layout = new javax.swing.GroupLayout(card4);
        card4.setLayout(card4Layout);
        card4Layout.setHorizontalGroup(
            card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(card4Layout.createSequentialGroup()
                        .addComponent(jPanel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel91, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(card4Layout.createSequentialGroup()
                        .addGroup(card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addGroup(card4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        card4Layout.setVerticalGroup(
            card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel91, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(card4Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(card4);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:

        jButton31.setEnabled(true);
        jTextField18.setEditable(true);
        int row = jTable5.getSelectedRow();

        jTextField13.setText(String.valueOf(jTable5.getValueAt(row, 0)));
        jTextField15.setText(String.valueOf(jTable5.getValueAt(row, 1)));
        jTextField16.setText(String.valueOf(jTable5.getValueAt(row, 2)));
        jTextField17.setText(String.valueOf(jTable5.getValueAt(row, 3)));
        jTextField18.setText(String.valueOf(jTable5.getValueAt(row, 4)));
        jTextField13.setEditable(false);

        jButton30.setEnabled(false);

        try {
            ResultSet resultset = MySQL.execute("SELECT COUNT(`id`) FROM `invoice` WHERE `customer_mobile`='" + jTextField13.getText() + "'");

            if (resultset.next()) {
                jLabel57.setText(resultset.getString(1));
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, "Jtable_5_mouseclick", e);
        }

//        if (evt.getClickCount() == 2 && invoice != null) {
//            invoice.getjTextField2().setText(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
//            invoice.getjLabel19().setText(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 1)) + " " + jTable1.getValueAt(jTable1.getSelectedRow(), 2));
//            invoice.getjFormattedTextField3().setText(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 4)));
//            this.dispose();
//        }
        if (evt.getClickCount() == 2 && home != null) {
            double balancepayment = Double.parseDouble(String.valueOf(jTable5.getValueAt(row, 4)));
//           double x = balancepayment * 2;
//
//          balancepayment = balancepayment - x;
            home.jTextField1.setText(String.valueOf(jTable5.getValueAt(jTable5.getSelectedRow(), 0)));
            home.balancepayment = balancepayment;
            home.calculate();

            if (dailog != null) {
                dailog.dispose();
            }
        }


    }//GEN-LAST:event_jTable5MouseClicked

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:

        String mobile = jTextField13.getText();
        String firstname = jTextField15.getText();
        String lastname = jTextField16.getText();
        String email = jTextField17.getText();

        if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter mobile", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalid mobile number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (firstname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter first name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (firstname.length() > 45) {
            JOptionPane.showMessageDialog(this, "First Name length cannot exeed 45 characters", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lastname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter last name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lastname.length() > 45) {
            JOptionPane.showMessageDialog(this, "Last Name length cannot exeed 45 characters", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (email.length() > 45) {
            JOptionPane.showMessageDialog(this, "Email length cannot exeed 45 characters", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                boolean emailSet = false;

                if (!email.isEmpty()) {

                    if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {

                        JOptionPane.showMessageDialog(this, "Invalid email address", "Warning", JOptionPane.WARNING_MESSAGE);

                    } else {
                        emailSet = true;
                    }

                } else {

                    if (email.isEmpty()) {
                        email = "Email is not registered";
                        emailSet = true;
                    }

                }

                if (emailSet) {

                    ResultSet resultset = MySQL.execute("SELECT * FROM `customer` WHERE `mobile`='" + mobile + "' OR (`email`='" + email + "' AND `email` <> 'Email is not registered')");

                    if (resultset.next()) {
                        JOptionPane.showMessageDialog(this, "Customer aready registered", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        MySQL.execute("INSERT INTO  `customer` (`mobile`,`first_name`,`last_name`,`email`,`balance_payment`,`last_update_time`) VALUES "
                                + "('" + mobile + "','" + firstname + "','" + lastname + "','" + email + "','0', '" + getCurrentDateTime() + "')");

                        reset();
                        loadCustomers("first_name");
                        JOptionPane.showMessageDialog(this, "Customer successfully registered", "Message", JOptionPane.INFORMATION_MESSAGE);

                    }

                }

            } catch (Exception e) {
                logger.log(Level.WARNING, "Insert_new_customer", e);
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:

        String mobile = jTextField13.getText();
        String firstname = jTextField15.getText();
        String lastname = jTextField16.getText();
        String email = jTextField17.getText();
        String balance = jTextField18.getText();

        if (firstname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter first name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (firstname.length() > 45) {
            JOptionPane.showMessageDialog(this, "First Name length cannot exeed 45 characters", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lastname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter last name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lastname.length() > 45) {
            JOptionPane.showMessageDialog(this, "Last Name length cannot exeed 45 characters", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (email.length() > 45) {
            JOptionPane.showMessageDialog(this, "Email length cannot exeed 45 characters", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {

                boolean emailSet = false;
                boolean update = false;

                if (!email.isEmpty() && !email.equals("Email is not registered")) {

                    if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {

                        JOptionPane.showMessageDialog(this, "Invalid email address", "Warning", JOptionPane.WARNING_MESSAGE);

                    } else {
                        emailSet = true;
                    }

                } else {

                    if (email.isEmpty() && !email.equals("Email is not registered")) {
                        email = "Email is not registered";
                        emailSet = true;
                    }

                    update = true;

                }

                if (emailSet) {

                    ResultSet resultset = MySQL.execute("SELECT * FROM `customer` WHERE `email`='" + email + "' AND `email` <> 'Email is not registered'");

                    if (resultset.next()) {
                        if (mobile.equals(resultset.getString("mobile"))) {
                            if (!resultset.next()) {
                                update = true;
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Email aready exists", "Warning", JOptionPane.WARNING_MESSAGE);
                            jTextField17.setText("");
                        }

                    } else {
                        update = true;
                    }

                }

                if (update) {
                    MySQL.execute("Update `customer` SET `first_name`='" + firstname + "',`last_name`='" + lastname + "',"
                            + "`email`='" + email + "',`balance_payment`='" + balance + "',`last_update_time`='" + getCurrentDateTime() + "' WHERE  `mobile`='" + mobile + "'");

                    reset();
                    loadCustomers("first_name");
                    JOptionPane.showMessageDialog(this, "Customer successfully updated", "Message", JOptionPane.INFORMATION_MESSAGE);
                    jButton30.setEnabled(true);
                    jButton31.setEnabled(false);
                }

            } catch (Exception e) {
                logger.log(Level.WARNING, "Update_customer", e);
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        jButton30.setEnabled(true);
        jButton31.setEnabled(false);
        reset();
        loadCustomers("first_name");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyReleased
        // TODO add your handling code here:
        if (jTable5.getSelectedRow() == -1) {
            loadCustomers("mobile");
        }

    }//GEN-LAST:event_jTextField13KeyReleased

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTextField15KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyReleased
        // TODO add your handling code 
        if (jTable5.getSelectedRow() == -1) {
            loadCustomers("first_name");
        }
    }//GEN-LAST:event_jTextField15KeyReleased

    private void jTextField16KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField16KeyReleased
        // TODO add your handling code here:
        if (jTable5.getSelectedRow() == -1) {
            loadCustomers("last_name");
        }
    }//GEN-LAST:event_jTextField16KeyReleased

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField17KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17KeyReleased

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jTextField18KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField18KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    // End of variables declaration//GEN-END:variables

//    void setDialod(SupportFrame sf) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    void setDialod(SupportFrame sf) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    void setHome() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
