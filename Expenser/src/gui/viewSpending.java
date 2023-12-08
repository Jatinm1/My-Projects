package gui;

import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author jatin
 */
public class viewSpending extends javax.swing.JFrame {

    /**
     * Creates new form viewSpending
     */
    public viewSpending() {
        initComponents();
        displayCategory();
        tableProps();

    }

    void tableProps() {
        TableColumn Dcol1 = dateTable.getColumnModel().getColumn(0);
        Dcol1.setPreferredWidth(100);
        TableColumn Dcol2 = dateTable.getColumnModel().getColumn(1);
        Dcol2.setPreferredWidth(150);
        TableColumn Dcol3 = dateTable.getColumnModel().getColumn(2);
        Dcol3.setPreferredWidth(100);
        TableColumn Dcol4 = dateTable.getColumnModel().getColumn(3);
        Dcol4.setPreferredWidth(100);

        JTableHeader headerD = dateTable.getTableHeader();
        headerD.setFont(new Font("Trebuchet MS", Font.BOLD, 16));

    }

    void displayCategory() {
        try {
            viewthisCategoryOnly.removeAllItems();
            viewthisCategoryOnly.addItem("All Categories");
            viewthisCategoryOnly.setSelectedItem("All Categories");
            ResultSet rs = db.DbConnect.st.executeQuery("select * from category_info");
            while (rs.next()) {
                viewthisCategoryOnly.addItem(rs.getString("category"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void getDateEntries() {
        try {
            javax.swing.table.DefaultTableModel dtm
                    = (javax.swing.table.DefaultTableModel) dateTable.getModel();
            int rc = dtm.getRowCount();
            while (rc-- != 0) {
                dtm.removeRow(0);
            }
            java.util.Date fdS = fromDateS.getDate();
            java.util.Date tdS = toDateS.getDate();

            String thisCategoryOnly = (String) viewthisCategoryOnly.getSelectedItem();
            String categoryOnly = (String) viewthisCategoryOnly.getSelectedItem();

            if (fdS != null && tdS != null && thisCategoryOnly.equals("All Categories")) {
                java.sql.Date fDate = new java.sql.Date(fdS.getTime());
                java.sql.Date tDate = new java.sql.Date(tdS.getTime());

                if (tDate.after(fDate)) {
                    ResultSet rs = db.DbConnect.st.executeQuery("select * from spendings where sdate <= '" + tDate + "' and sdate >= '" + fDate + "' order by sdate asc ");
                    int total = 0;
                    while (rs.next()) {
                        int t = rs.getInt("amount");
                        total += t;
                        Object o[] = {rs.getDate("sdate"), rs.getString("tname"), rs.getString("category"), t};
                        dtm.addRow(o);
                        totalSD.setText(total + "");
                    }
                } else {

                    Icon erroricon = new javax.swing.ImageIcon(getClass().getResource("/Extrafiles/errorIcon.png"));
                    JOptionPane.showMessageDialog(null, "<html><p style=\"color:black; font-size:18px; font-family: 'calibri'\">TO date should come after FROM date</p></html>", "Warning", HEIGHT, erroricon);
                }

            } else if (fdS != null && tdS != null && categoryOnly != null) {
                java.sql.Date fDate = new java.sql.Date(fdS.getTime());
                java.sql.Date tDate = new java.sql.Date(tdS.getTime());

                if (tDate.after(fDate)) {
                    ResultSet rs = db.DbConnect.st.executeQuery("select * from spendings where sdate <= '" + tDate + "' and sdate >= '" + fDate + "' and category = '" + categoryOnly + "' order by sdate asc ");
                    int total = 0;
                    while (rs.next()) {
                        int t = rs.getInt("amount");
                        total += t;
                        Object o[] = {rs.getDate("sdate"), rs.getString("tname"), rs.getString("category"), t};
                        dtm.addRow(o);
                        totalSD.setText(total + "");
                    }
                } else {

                    Icon erroricon = new javax.swing.ImageIcon(getClass().getResource("/Extrafiles/errorIcon.png"));
                    JOptionPane.showMessageDialog(null, "<html><p style=\"color:black; font-size:18px; font-family: 'calibri'\">TO date should come after FROM date</p></html>", "Warning", HEIGHT, erroricon);
                }
            } else {

                Icon erroricon = new javax.swing.ImageIcon(getClass().getResource("/Extrafiles/errorIcon.png"));

                JOptionPane.showMessageDialog(null, "<html><p style=\"color:black; font-size:18px; font-family: 'calibri'\">Enter both Dates</p></html>", "Warning", HEIGHT, erroricon);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

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

        kGradientPanel1 = new keeptoo.KGradientPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jPanel3 = new javax.swing.JPanel();
        totalSD = new javax.swing.JLabel();
        fromDateS = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        toDateS = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        dateTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        viewthisCategoryOnly = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Spendings");

        kGradientPanel2.setkGradientFocus(600);

        jPanel3.setOpaque(false);

        totalSD.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        totalSD.setForeground(new java.awt.Color(255, 255, 255));
        totalSD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalSD.setText("0");

        fromDateS.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fromDateSPropertyChange(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("From:");

        toDateS.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                toDateSPropertyChange(evt);
            }
        });

        dateTable.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        dateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Transaction", "Category", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dateTable.setGridColor(new java.awt.Color(0, 0, 0));
        dateTable.setRowHeight(35);
        dateTable.setShowGrid(true);
        dateTable.getTableHeader().setResizingAllowed(false);
        dateTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(dateTable);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Amount:");

        viewthisCategoryOnly.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        viewthisCategoryOnly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewthisCategoryOnlyActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Category:");

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Spending Date Wise");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("To:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalSD, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fromDateS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(toDateS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(viewthisCategoryOnly, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(fromDateS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(toDateS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(viewthisCategoryOnly, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel4)
                    .addComponent(totalSD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {fromDateS, jLabel2});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, toDateS});

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        getDateEntries();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fromDateSPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fromDateSPropertyChange
        toDateS.setSelectableDateRange(fromDateS.getDate(), new java.util.Date());
    }//GEN-LAST:event_fromDateSPropertyChange

    private void toDateSPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_toDateSPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_toDateSPropertyChange

    private void viewthisCategoryOnlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewthisCategoryOnlyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewthisCategoryOnlyActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dateTable;
    private com.toedter.calendar.JDateChooser fromDateS;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private com.toedter.calendar.JDateChooser toDateS;
    private javax.swing.JLabel totalSD;
    private javax.swing.JComboBox<String> viewthisCategoryOnly;
    // End of variables declaration//GEN-END:variables
}
