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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.MySQL;
import model.MySQLSyncApp;
import model.onlineMYSQL;
import static model.MyDateTimeUtils.getCurrentDateTime;
import model.MyMethods;

/**
 *
 * @author Dell
 */
public class SupplierRegistration extends javax.swing.JPanel {

    private HashMap<String, String> companyMap = new HashMap<>();

    private Grn grn;
//    private DiliveryGRN deliveryGRN;
    private JDialog dailog;

//    public void setDeliveryGRN(DiliveryGRN deliveryGRN) {
//        this.deliveryGRN = deliveryGRN;
//    }
    public void setGrn(Grn grn) {
        this.grn = grn;

    }

    public void setDiaload(JDialog dailog) {
        this.dailog = dailog;
    }

    public JTextField getTextField24() {
        return jTextField24;
    }

    public void searchByCompany() {
        if (jTable7.getSelectedRow() == -1) {
            loadSuppliers("first_name", "ASC");
        }

    }

    private String CompanyID;

    public void setCompanyID(String CompanyID) {
        this.CompanyID = CompanyID;
    }

    public SupplierRegistration() {
        initComponents();
        loadSuppliers("first_name", "ASC");
        MyMethods.setTableHeaderFontSize(jTable7, 16);
        jButton36.setEnabled(false);
        jTextField25.setEditable(false);

        loadCompanies();
    }

    private void loadCompanies() {
        try {
            ResultSet resultset = MySQL.execute("SELECT * FROM `company`");

            while (resultset.next()) {
                companyMap.put(resultset.getString("company.name"), resultset.getString("company.id"));
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, "loadComapny", e);
        }
    }

    public void setCompanyName(String name) {
        jTextField24.setText(name);
    }

    public void mobileFieldGrabFocus() {
        jTextField20.grabFocus();
    }

    private void loadSuppliers(String column, String method) {
        String mobile = jTextField20.getText().trim();
        String firstname = jTextField21.getText().trim();
        String lastname = jTextField22.getText().trim();
        String email = ""; //getThe text from the text field if needed to search by email tooo
        String company = jTextField24.getText().trim();

        try {
            ResultSet resultset = MySQL.execute("SELECT * FROM `supplier` INNER JOIN `company` ON `supplier`.`company_id`=`company`.`id`"
                    + " WHERE `mobile` LIKE '" + mobile + "%' AND `first_name` LIKE '" + firstname + "%' AND `last_name` LIKE '" + lastname + "%' "
                    + " AND `email` LIKE '" + email + "%' AND `company`.`name` LIKE '" + company + "%' ORDER BY `" + column + "` " + method + "");

            DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
            model.setRowCount(0);

            while (resultset.next()) {
                Vector<String> vector = new Vector<>();

                vector.add(resultset.getString("mobile"));
                vector.add(resultset.getString("first_name"));
                vector.add(resultset.getString("last_name"));
                vector.add(resultset.getString("email"));
                vector.add(resultset.getString("company.name"));
                vector.add(resultset.getString("balance_amount"));
                companyMap.put(resultset.getString("company.name"), resultset.getString("company.id"));

                model.addRow(vector);
            }

            jLabel67.setText("Suppliers (" + model.getRowCount() + ")");
        } catch (Exception e) {
            logger.log(Level.WARNING, "SupplierRegistrtion_search", e);
            e.printStackTrace();
        }
    }

    private void reset() {
        jTextField20.setText("");
        jTextField21.setText("");
        jTextField22.setText("");
        jTextField23.setText("");
        jTextField24.setText("");
        jTextField25.setText("");
        jTextField25.setEditable(false);
        jButton36.setEnabled(false);
        jButton35.setEnabled(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card6 = new javax.swing.JPanel();
        jPanel71 = new javax.swing.JPanel();
        jPanel92 = new javax.swing.JPanel();
        jPanel72 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jPanel73 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jButton37 = new javax.swing.JButton();
        jTextField24 = new javax.swing.JTextField();
        jPanel93 = new javax.swing.JPanel();
        jPanel74 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jPanel75 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jPanel77 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel94 = new javax.swing.JPanel();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jPanel76 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        card6.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jPanel71.setLayout(new java.awt.GridLayout(1, 3, 20, 0));

        jPanel92.setLayout(new java.awt.GridLayout(4, 0, 0, 10));

        jPanel72.setLayout(new java.awt.BorderLayout());

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel61.setText("Mobile");
        jLabel61.setPreferredSize(new java.awt.Dimension(90, 16));
        jPanel72.add(jLabel61, java.awt.BorderLayout.WEST);

        jTextField20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField20KeyReleased(evt);
            }
        });
        jPanel72.add(jTextField20, java.awt.BorderLayout.CENTER);

        jPanel92.add(jPanel72);

        jPanel73.setLayout(new java.awt.BorderLayout());

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel62.setText("First name");
        jLabel62.setPreferredSize(new java.awt.Dimension(90, 16));
        jPanel73.add(jLabel62, java.awt.BorderLayout.WEST);

        jTextField21.setFont(new java.awt.Font("Iskoola Pota", 0, 18)); // NOI18N
        jTextField21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField21KeyReleased(evt);
            }
        });
        jPanel73.add(jTextField21, java.awt.BorderLayout.CENTER);

        jPanel92.add(jPanel73);

        jButton37.setBackground(new java.awt.Color(0, 153, 255));
        jButton37.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jButton37.setForeground(new java.awt.Color(255, 255, 255));
        jButton37.setText("Select company");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        jPanel92.add(jButton37);

        jTextField24.setEditable(false);
        jTextField24.setFont(new java.awt.Font("Iskoola Pota", 0, 18)); // NOI18N
        jTextField24.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextField24PropertyChange(evt);
            }
        });
        jPanel92.add(jTextField24);

        jPanel71.add(jPanel92);

        jPanel93.setLayout(new java.awt.GridLayout(4, 0, 0, 10));

        jPanel74.setLayout(new java.awt.BorderLayout());

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel63.setText("<html> <p>Last name</p> <html>");
        jLabel63.setPreferredSize(new java.awt.Dimension(90, 16));
        jPanel74.add(jLabel63, java.awt.BorderLayout.WEST);

        jTextField22.setFont(new java.awt.Font("Iskoola Pota", 0, 18)); // NOI18N
        jTextField22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField22KeyReleased(evt);
            }
        });
        jPanel74.add(jTextField22, java.awt.BorderLayout.CENTER);

        jPanel93.add(jPanel74);

        jPanel75.setLayout(new java.awt.BorderLayout());

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel64.setText("Email");
        jLabel64.setPreferredSize(new java.awt.Dimension(90, 16));
        jPanel75.add(jLabel64, java.awt.BorderLayout.WEST);

        jTextField23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel75.add(jTextField23, java.awt.BorderLayout.CENTER);

        jPanel93.add(jPanel75);

        jPanel77.setLayout(new java.awt.BorderLayout());

        jLabel68.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel68.setText("Balance");
        jLabel68.setPreferredSize(new java.awt.Dimension(90, 16));
        jPanel77.add(jLabel68, java.awt.BorderLayout.WEST);

        jTextField25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel77.add(jTextField25, java.awt.BorderLayout.CENTER);

        jPanel93.add(jPanel77);

        jPanel71.add(jPanel93);

        jTable7.setAutoCreateRowSorter(true);
        jTable7.setFont(new java.awt.Font("Iskoola Pota", 0, 16)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mobile", "First Name", "Last name", "Email", "Company", "Balance amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable7.setIntercellSpacing(new java.awt.Dimension(10, 0));
        jTable7.setRowHeight(40);
        jTable7.setSelectionBackground(new java.awt.Color(224, 224, 224));
        jTable7.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable7.getTableHeader().setReorderingAllowed(false);
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jTable7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable7KeyPressed(evt);
            }
        });
        jScrollPane7.setViewportView(jTable7);
        if (jTable7.getColumnModel().getColumnCount() > 0) {
            jTable7.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable7.getColumnModel().getColumn(1).setPreferredWidth(0);
            jTable7.getColumnModel().getColumn(4).setPreferredWidth(150);
        }

        jPanel94.setLayout(new java.awt.GridLayout(3, 0, 0, 10));

        jButton35.setBackground(new java.awt.Color(0, 153, 255));
        jButton35.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jButton35.setForeground(new java.awt.Color(255, 255, 255));
        jButton35.setText("Create account");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jPanel94.add(jButton35);

        jButton36.setBackground(new java.awt.Color(0, 153, 255));
        jButton36.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jButton36.setForeground(new java.awt.Color(255, 255, 255));
        jButton36.setText("Update account");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        jPanel94.add(jButton36);

        jPanel76.setLayout(new java.awt.BorderLayout());

        jLabel65.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel65.setText("Total GRN : ");
        jLabel65.setPreferredSize(new java.awt.Dimension(110, 16));
        jPanel76.add(jLabel65, java.awt.BorderLayout.WEST);

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel66.setText("...");
        jLabel66.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel76.add(jLabel66, java.awt.BorderLayout.CENTER);

        jPanel94.add(jPanel76);

        jLabel67.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel67.setText("Suppliers (1)");

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout card6Layout = new javax.swing.GroupLayout(card6);
        card6.setLayout(card6Layout);
        card6Layout.setHorizontalGroup(
            card6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(card6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(card6Layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(card6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(card6Layout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(jPanel71, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel94, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(3, 3, 3)))
        );
        card6Layout.setVerticalGroup(
            card6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card6Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(card6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel67)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))
            .addGroup(card6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(card6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(card6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel94, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(505, Short.MAX_VALUE)))
        );

        add(card6);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        // TODO add your handling code here:
        SupportFrame sf = new SupportFrame(new Home("", "", ""), true);

        CompanyRegistration companyRegistration = new CompanyRegistration();

        sf.getJPanel().removeAll();
        sf.getJPanel().add(companyRegistration);
        sf.getJPanel().revalidate();
        sf.getJPanel().repaint();

        companyRegistration.setSuplierRegistration(this);
        companyRegistration.setDiaload(sf);

        sf.setVisible(true);


    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        // TODO add your handling code here:

        String mobile = jTextField20.getText();
        String fname = jTextField21.getText();
        String lname = jTextField22.getText();
        String email = jTextField23.getText();

        if (CompanyID == null) {
            JOptionPane.showMessageDialog(this, "Please select company", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter mobile number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalid mobile number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter first name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (fname.length() > 45) {
            JOptionPane.showMessageDialog(this, "Name length cannot exeed 45 characters", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter last name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lname.length() > 45) {
            JOptionPane.showMessageDialog(this, "Name length cannot exeed 45 characters", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (email.length() > 45) {
            JOptionPane.showMessageDialog(this, "Name length cannot exeed 45 characters", "Warning", JOptionPane.WARNING_MESSAGE);
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

                    ResultSet resultset = MySQL.execute("SELECT * FROM `supplier` WHERE `mobile`='" + mobile + "' OR `email`='" + email + "'");

                    if (resultset.next()) {
                        JOptionPane.showMessageDialog(this, "Supplier already exsists", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        MySQL.execute("INSERT INTO `supplier` (`mobile`,`first_name`,`last_name`,`email`,`balance_amount`,`company_id`,`last_update_time`)"
                                + "VALUES ('" + mobile + "','" + fname + "','" + lname + "','" + email + "','0','" + CompanyID + "','" + getCurrentDateTime() + "')");

                        reset();
                        loadSuppliers("first_name", "ASC");
                        JOptionPane.showMessageDialog(this, "Supplier successfully registered", "Message", JOptionPane.INFORMATION_MESSAGE);

                    }

                }

            } catch (Exception e) {
                logger.log(Level.WARNING, "SupplierRegistration_update", e);
                e.printStackTrace();
            }

        }


    }//GEN-LAST:event_jButton35ActionPerformed

    private void jTable7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable7KeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_jTable7KeyPressed

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        // TODO add your handling code here:
        jTextField25.setEditable(true);

        int row = jTable7.getSelectedRow();
        jButton36.setEnabled(true);

        jTextField24.setText(String.valueOf(jTable7.getValueAt(row, 4)));
        jTextField20.setText(String.valueOf(jTable7.getValueAt(row, 0)));
        jTextField21.setText(String.valueOf(jTable7.getValueAt(row, 1)));
        jTextField22.setText(String.valueOf(jTable7.getValueAt(row, 2)));
        jTextField23.setText(String.valueOf(jTable7.getValueAt(row, 3)));
        jTextField25.setText(String.valueOf(jTable7.getValueAt(row, 5)));

        jTextField20.setEditable(false);
        jButton35.setEnabled(false);

        try {
            ResultSet resultset = MySQL.execute("SELECT * FROM `grn_item` INNER JOIN `grn` ON `grn_item`.`grn_id`=`grn`.`id` "
                    + "WHERE `supplier_mobile`='" + String.valueOf(jTable7.getValueAt(row, 0)) + "'");

            HashMap<String, Double> grnMap = new HashMap<>();

            while (resultset.next()) {
                grnMap.put(resultset.getString("grn_id"), resultset.getDouble("paid_amount"));

            }

            jLabel66.setText(String.valueOf(grnMap.size()));

        } catch (Exception e) {
            logger.log(Level.WARNING, "SupplierRegistrtaion_searchGRN", e);
            e.printStackTrace();
        }

        if (evt.getClickCount() == 2) {

            if (grn != null) {
                grn.getTextField14().setText(String.valueOf(jTable7.getValueAt(row, 0)));
                grn.getTextField12().setText(String.valueOf(jTable7.getValueAt(row, 1) + " " + jTable7.getValueAt(row, 2)));
                grn.balancepayment = Double.parseDouble(String.valueOf(jTable7.getValueAt(row, 5)));
                grn.setpayment(String.valueOf(jTable7.getValueAt(row, 5)));

                grn.setEnabled(true);
                dailog.dispose();
            }

        }


    }//GEN-LAST:event_jTable7MouseClicked

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        // TODO add your handling code here:
        if (jTable7.getSelectedRow() != -1) {

            String mobile = jTextField20.getText();
            String fname = jTextField21.getText();
            String lname = jTextField22.getText();
            String email = jTextField23.getText();
            String balance = jTextField25.getText();

            if (fname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter first name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (fname.length() > 45) {
                JOptionPane.showMessageDialog(this, "Name length cannot exeed 45 characters", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (lname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter last name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (lname.length() > 45) {
                JOptionPane.showMessageDialog(this, "Name length cannot exeed 45 characters", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (email.length() > 45) {
                JOptionPane.showMessageDialog(this, "Name length cannot exeed 45 characters", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (fname.equals(String.valueOf(jTable7.getValueAt(jTable7.getSelectedRow(), 1)))
                    && lname.equals(String.valueOf(jTable7.getValueAt(jTable7.getSelectedRow(), 2)))
                    && email.equals(String.valueOf(jTable7.getValueAt(jTable7.getSelectedRow(), 3)))
                    && jTextField24.getText().equals(String.valueOf(jTable7.getValueAt(jTable7.getSelectedRow(), 4)))
                && balance.equals(String.valueOf(jTable7.getValueAt(jTable7.getSelectedRow(), 5)))) {

                JOptionPane.showMessageDialog(this, "No change detected", "Message", JOptionPane.INFORMATION_MESSAGE);

            } else {

                if (this.CompanyID == null) {
                    this.CompanyID = companyMap.get(jTextField24.getText());
                }

                try {

                    boolean emailSet = false;

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

                    }

                    if (emailSet) {

                        ResultSet resultset = MySQL.execute("SELECT * FROM `supplier` WHERE `mobile`!='" + mobile + "' AND `email`='" + email + "' AND `email` <> 'Email is not registered'");

                        if (resultset.next()) {
                            JOptionPane.showMessageDialog(this, "Email already exsists", "Warning", JOptionPane.WARNING_MESSAGE);
                            jTextField23.setText("");
                        } else {
                            String x;
                            if (jTextField23.getText().equals(String.valueOf(jTable7.getValueAt(jTable7.getSelectedRow(), 4)))) {
                                x = "";
                            } else {
                                x = ", `company_id`='" + CompanyID + "'";
                            }

                            MySQL.execute("UPDATE `supplier` SET `first_name`='" + fname + "',`last_name`='" + lname + "',`email`='" + email + "' " + x + ""
                                    + ",`balance_amount`='"+balance+"', `last_update_time`='" + getCurrentDateTime() + "' WHERE `mobile`='" + mobile + "'");

                            reset();
                            JOptionPane.showMessageDialog(this, "Supplier successfully updated", "Message", JOptionPane.INFORMATION_MESSAGE);
                            jButton36.setEnabled(false);
                            jButton35.setEnabled(true);
                            jTextField24.setText("");
                            loadSuppliers("first_name", "ASC");
                        }

                    }

                } catch (Exception e) {
                    logger.log(Level.WARNING, "SupplierRegistrtaion_update", e);
                    e.printStackTrace();

                }

            }
        }


    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //jTable7.clearSelection(); 
        reset();
        jTextField24.setText("");
        jTextField20.setEditable(true);
        jLabel66.setText("...");
        loadSuppliers("first_name", "ASC");


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField20KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField20KeyReleased
        // TODO add your handling code here:
        if (jTable7.getSelectedRow() == -1) {
            loadSuppliers("mobile", "ASC");
        }


    }//GEN-LAST:event_jTextField20KeyReleased

    private void jTextField21KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField21KeyReleased
        // TODO add your handling code here:
        if (jTable7.getSelectedRow() == -1) {
            loadSuppliers("first_name", "ASC");
        }

    }//GEN-LAST:event_jTextField21KeyReleased

    private void jTextField22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField22KeyReleased
        // TODO add your handling code here:.
        if (jTable7.getSelectedRow() == -1) {
            loadSuppliers("last_name", "ASC");
        }

    }//GEN-LAST:event_jTextField22KeyReleased

    private void jTextField24PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField24PropertyChange
        // TODO add your handling code here:
        loadSuppliers("last_name", "ASC");
    }//GEN-LAST:event_jTextField24PropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card6;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    public javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    // End of variables declaration//GEN-END:variables
}
