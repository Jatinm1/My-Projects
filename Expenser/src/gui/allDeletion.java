package gui;

import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 *
 * @author jatin
 */
public class allDeletion extends javax.swing.JFrame {

    /**
     * Creates new form allDeletion
     */
    public allDeletion() {
        initComponents();
    }
    
    private void deleteAllTransactions() {
        Icon binicon = new javax.swing.ImageIcon(getClass().getResource("/Extrafiles/binIcon.png"));
        
        
        
        try {
            int r = JOptionPane.showConfirmDialog(null, "<html><p style=\"color:black; font-size:18px; font-family: 'calibri'\">This Action will Delete all the Transactions, Do you really want to DELETE ? </p></html>" , "Deletion Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, binicon);

            
            if (r == JOptionPane.YES_OPTION) {
                
                

                
                int finalConfirmation = JOptionPane.showConfirmDialog(null, "<html><p style=\"color:black; font-size:18px; font-family: 'calibri'\">Think again, Do you really want to Delete ? </p></html>" , "Deletion Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, binicon);
                if (finalConfirmation == JOptionPane.YES_OPTION) {

                    db.DbConnect.st.execute("truncate spendings");
                    Icon successicon = new javax.swing.ImageIcon(getClass().getResource("/Extrafiles/successicon.png"));
                    JOptionPane.showMessageDialog(null,"<html><p style=\"color:black; font-size:18px; font-family: 'calibri'\">All Transactions Deleted Successfully</p></html>","Success", JOptionPane.INFORMATION_MESSAGE,successicon);
                    dispose();
                }
                else{}
            }
            else{}
            
            

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }
    
    
    private void deleteAllCategories() {
        Icon binicon = new javax.swing.ImageIcon(getClass().getResource("/Extrafiles/binIcon.png"));
        
        
        
        try {
            int r = JOptionPane.showConfirmDialog(null, "<html><p style=\"color:black; font-size:18px; font-family: 'Meiryo'\">This Action will Delete all the Categories and Transactions associated with it, Do you really want to DELETE ? </p></html>" , "Deletion Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, binicon);

            
            if (r == JOptionPane.YES_OPTION) {
                
                int finalConfirmation = JOptionPane.showConfirmDialog(null, "<html><p style=\"color:black; font-size:18px; font-family: 'calibri'\">Think again, Do you really want to Delete ? </p></html>" , "Deletion Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, binicon);
                if (finalConfirmation == JOptionPane.YES_OPTION) {

                    db.DbConnect.st.execute("truncate category_info");
                    db.DbConnect.st.execute("truncate spendings");
                    
                    Icon successicon = new javax.swing.ImageIcon(getClass().getResource("/Extrafiles/successicon.png"));
                    JOptionPane.showMessageDialog(null,"<html><p style=\"color:black; font-size:18px; font-family: 'calibri'\">All Categories and Transactions Deleted Successfully</p></html>","Success", JOptionPane.INFORMATION_MESSAGE,successicon);
                    dispose();
                }
                else{}
            }
            else{}
            
            

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

        kGradientPanel2 = new keeptoo.KGradientPanel();
        delCategories = new javax.swing.JButton();
        delTransactions = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Deletion Area");
        setResizable(false);

        kGradientPanel2.setkGradientFocus(1000);

        delCategories.setBackground(new java.awt.Color(255, 0, 0));
        delCategories.setFont(new java.awt.Font("Trebuchet MS", 1, 38)); // NOI18N
        delCategories.setForeground(new java.awt.Color(255, 255, 255));
        delCategories.setText("DELETE ALL THE CATEGORIES");
        delCategories.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));
        delCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delCategoriesActionPerformed(evt);
            }
        });

        delTransactions.setBackground(new java.awt.Color(255, 0, 0));
        delTransactions.setFont(new java.awt.Font("Trebuchet MS", 1, 38)); // NOI18N
        delTransactions.setForeground(new java.awt.Color(255, 255, 255));
        delTransactions.setText("DELETE ALL THE TRANSACTIONS");
        delTransactions.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));
        delTransactions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delTransactionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(delTransactions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delCategories, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE))
                .addGap(49, 49, 49))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(delTransactions, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(delCategories, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void delCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delCategoriesActionPerformed
        deleteAllCategories();
    }//GEN-LAST:event_delCategoriesActionPerformed

    private void delTransactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delTransactionsActionPerformed
        deleteAllTransactions();
    }//GEN-LAST:event_delTransactionsActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delCategories;
    private javax.swing.JButton delTransactions;
    private keeptoo.KGradientPanel kGradientPanel2;
    // End of variables declaration//GEN-END:variables
}