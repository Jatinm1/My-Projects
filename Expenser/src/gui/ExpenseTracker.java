package gui;
import java.awt.Font;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;

/**
 *
 * @author jatin
 */
public class ExpenseTracker extends javax.swing.JFrame {

    /**
     * Creates new form SpendingTracker
     */
    public ExpenseTracker() {
        initComponents();
        displayCategory();
        d.setDate(new java.util.Date());
        d.setSelectableDateRange(null, new java.util.Date());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getAEntries();
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Trebuchet MS", Font.BOLD, 18));

    }
    

    void displayCategory() {
        try {
            category.removeAllItems();
            ResultSet rs = db.DbConnect.st.executeQuery("select * from category_info");
            while (rs.next()) {
                category.addItem(rs.getString("category"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void getEntries() {
        try {
            javax.swing.table.DefaultTableModel dtm
                    = (javax.swing.table.DefaultTableModel) table.getModel();
            int rc = dtm.getRowCount();
            while (rc-- != 0) {
                dtm.removeRow(0);
            }
            java.time.LocalDate cd = java.time.LocalDate.now();
            java.time.LocalDate bd = cd.minusDays(30);

            ResultSet rs = db.DbConnect.st.executeQuery("select * from spendings where sdate <= '" + cd + "' and sdate >= '" + bd + "' ");

            int total = 0;
            while (rs.next()) {
                int t = rs.getInt("amount");
                total += t;
                Object o[] = {rs.getInt("sid"), rs.getDate("sdate"), rs.getString("tname"), rs.getString("category"), t};
                dtm.addRow(o);
                totalAmount.setText(total + "");

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }

    }

    private String monthGetter() {

        int selectedMonthView = spendMonth.getMonth();

        String month = "";
        
        
        switch(selectedMonthView){
            case 0: 
                month = "January Spendings";
                break;
            case 1: 
                month = "February Spendings";
                break;
            case 2: 
                month = "March Spendings";
                break;
            case 3: 
                month = "April Spendings";
                break;
            case 4: 
                month = "May Spendings";
                break;
            case 5: 
                month = "June Spendings";
                break;
            case 6: 
                month = "July Spendings";
                break;
            case 7: 
                month = "August Spendings";
                break;
            case 8: 
                month = "September Spendings";
                break;
            case 9: 
                month = "October Spendings";
                break;
            case 10: 
                month = "November Spendings";
                break;
            case 11: 
                month = "December Spendings";
                break;
        }
        return month;
    }

    private void getMEntries() {
        try {
            javax.swing.table.DefaultTableModel dtm
                    = (javax.swing.table.DefaultTableModel) table.getModel();
            int rc = dtm.getRowCount();
            while (rc-- != 0) {
                dtm.removeRow(0);
            }
//            java.time.LocalDate cm = java.time.LocalDate.;
            int getMonthfromUser = spendMonth.getMonth();

            int selectedMonth = getMonthfromUser + 1;
            ResultSet rs = db.DbConnect.st.executeQuery("select * from spendings where MONTH(sdate) = '" + selectedMonth + "'  order by sdate asc");
            
            int total = 0;
            while (rs.next()) {
                int t = rs.getInt("amount");
                total += t;
                Object o[] = {rs.getInt("sid"), rs.getDate("sdate"), rs.getString("tname"), rs.getString("category"), t};
                dtm.addRow(o);
                
            }
            totalAmount.setText(total + "");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }

    }

    private void getAEntries() {
        currentViewLabel.setText("All Spendings till Now");
        try {
            javax.swing.table.DefaultTableModel dtm
                    = (javax.swing.table.DefaultTableModel) table.getModel();
            int rc = dtm.getRowCount();
            while (rc-- != 0) {
                dtm.removeRow(0);
            }
//            java.time.LocalDate cm = java.time.LocalDate.;
            int getMonthfromUser = spendMonth.getMonth();
            int selectedMonth = getMonthfromUser + 1;
            ResultSet rs = db.DbConnect.st.executeQuery("select * from spendings order by sdate desc");
            
            int total = 0;
            while (rs.next()) {
                int t = rs.getInt("amount");
                total += t;
                Object o[] = {rs.getInt("sid"), rs.getDate("sdate"), rs.getString("tname"), rs.getString("category"), t};
                dtm.addRow(o);
                

            }
            totalAmount.setText(total + "");

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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        d = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        a = new javax.swing.JTextField();
        category = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        transaction = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        totalAmount = new javax.swing.JLabel();
        spendMonth = new com.toedter.calendar.JMonthChooser();
        jLabel6 = new javax.swing.JLabel();
        previousSpends = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        allSpendings = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        currentViewLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        masterMenu = new javax.swing.JMenu();
        viewAllSpendings = new javax.swing.JMenuItem();
        sortedSpendings = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        exitButton = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Expenser - An Expense Tracker");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(58, 73, 235));

        jPanel2.setBackground(new java.awt.Color(0, 138, 250));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add New Expense");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Category:");

        d.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date:");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Amount:");

        a.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        a.setMinimumSize(new java.awt.Dimension(80, 25));
        a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aMouseClicked(evt);
            }
        });
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });
        a.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aKeyTyped(evt);
            }
        });

        category.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        category.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        category.setName(""); // NOI18N
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jButton1.setText("Add New category");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(212, 6, 205));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ADD");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Transaction Name:");

        transaction.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        transaction.setMinimumSize(new java.awt.Dimension(90, 27));
        transaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionMouseClicked(evt);
            }
        });
        transaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transaction, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(a, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(category, 0, 253, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(a, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(d, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(transaction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(category))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {category, jLabel3});

        table.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "Transaction", "Category", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(0, 0, 0));
        table.setRowHeight(45);
        table.setShowGrid(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                tableCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jScrollPane1.setViewportView(table);

        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete Selected Transaction");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(58, 73, 235));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total Amount:");

        totalAmount.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        totalAmount.setForeground(new java.awt.Color(255, 255, 255));
        totalAmount.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(831, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        spendMonth.setBackground(new java.awt.Color(255, 255, 255));
        spendMonth.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        spendMonth.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                spendMonthPropertyChange(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jLabel6.setText("or");

        previousSpends.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        previousSpends.setText("Last 30 Days Spendings");
        previousSpends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousSpendsActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jLabel7.setText("or");

        allSpendings.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        allSpendings.setText("All Spendings till Now");
        allSpendings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allSpendingsActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(50, 56, 172));

        currentViewLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        currentViewLabel.setForeground(new java.awt.Color(255, 255, 255));
        currentViewLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentViewLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentViewLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(currentViewLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jMenuBar1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jMenuBar1FocusGained(evt);
            }
        });

        masterMenu.setText("Options");
        masterMenu.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        viewAllSpendings.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        viewAllSpendings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Extrafiles/All Spendings.png"))); // NOI18N
        viewAllSpendings.setText("View all Expenses");
        viewAllSpendings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllSpendingsActionPerformed(evt);
            }
        });
        masterMenu.add(viewAllSpendings);

        sortedSpendings.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        sortedSpendings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Extrafiles/filter_and_sort.png"))); // NOI18N
        sortedSpendings.setText("Sort View of Expenses");
        sortedSpendings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortedSpendingsActionPerformed(evt);
            }
        });
        masterMenu.add(sortedSpendings);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Extrafiles/binIconMenu.png"))); // NOI18N
        jMenuItem1.setText("More Deleting Options");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        masterMenu.add(jMenuItem1);

        exitButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Extrafiles/exit.png"))); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        masterMenu.add(exitButton);

        aboutMenu.setText("More Options");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Extrafiles/about.png"))); // NOI18N
        jMenuItem4.setText("About App");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        aboutMenu.add(jMenuItem4);

        masterMenu.add(aboutMenu);

        jMenuBar1.add(masterMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spendMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(12, 12, 12)
                                .addComponent(previousSpends)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addGap(12, 12, 12)
                                .addComponent(allSpendings)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spendMonth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(allSpendings, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(previousSpends, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel6, previousSpends, spendMonth});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            java.util.Date dt = d.getDate();
            String s1 = transaction.getText();
            String s2 = a.getText();
            String s3 = (String) category.getSelectedItem();
            if(s3 != null){
                
                if (dt != null && !s1.equals("") && !s2.equals("") && !s3.equals("")) {
                int amt = Integer.parseInt(s2);
                java.sql.Date date = new java.sql.Date(dt.getTime());
                db.DbConnect.st.executeUpdate("insert into spendings(sdate,tname,category,amount) values('" + date + "', '" + s1 + "', '" + s3 + "', " + amt + ")");
                Icon successicon = new javax.swing.ImageIcon(getClass().getResource("/Extrafiles/successicon.png"));
        JOptionPane.showMessageDialog(null,"<html><p style=\"color:black; font-size:18px; font-family: 'calibri'\">Transaction Added Successfully</p></html>","Success", JOptionPane.INFORMATION_MESSAGE,successicon);
                transaction.setText("");
                a.setText("");
                getAEntries();

            } else {
                Icon erroricon = new javax.swing.ImageIcon(getClass().getResource("/Extrafiles/errorIcon.png"));
                    
        JOptionPane.showMessageDialog(null,"<html><p style=\"color:black; font-size:18px; font-family: 'Calibri'\">Please fill all the Details</p></html>","Warning", JOptionPane.INFORMATION_MESSAGE,erroricon);
            }
            
            
            }
            else{
                
                Icon erroricon = new javax.swing.ImageIcon(getClass().getResource("/Extrafiles/errorIcon.png"));
                    
        JOptionPane.showMessageDialog(null,"<html><p style=\"color:black; font-size:18px; font-family: 'calibri'\">Every Transaction should have a Category. <br> If there is no category, Add new one.</p></html>","Warning", JOptionPane.INFORMATION_MESSAGE,erroricon);
            
            
            
            }
        } catch(SQLSyntaxErrorException ex){
            Icon erroricon = new javax.swing.ImageIcon(getClass().getResource("/Extrafiles/errorIcon.png"));
            JOptionPane.showMessageDialog(null, "<html><p style=\"color:black; font-size:18px; font-family: 'calibri'\">You can't use ' or &#34; in Transaction Name </p></html>", "Warning", HEIGHT, erroricon);
        }
        
        
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Category().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void transactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transactionActionPerformed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryActionPerformed

    private void aKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aKeyTyped
        char ch = evt.getKeyChar();
        if (!Character.isDigit(ch)) {
            evt.consume();
        }
    }//GEN-LAST:event_aKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        int rowID = table.getSelectedRow();
        if (rowID != -1) {
            int r = JOptionPane.showConfirmDialog(null, "<html><p style=\"color:black; font-size:18px; font-family: 'calibri'\">Do you really want to Delete ?</p></html>", "Deletion Confirmation", JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                int id = (int) table.getValueAt(rowID, 0);
                try {
                    db.DbConnect.st.executeUpdate("delete from spendings where sid = " + id);
                    javax.swing.table.DefaultTableModel dtm =  (javax.swing.table.DefaultTableModel)table.getModel();
            
                    int rc = dtm.getRowCount();
                    db.DbConnect.st.execute("alter table spendings auto_increment = "+rc);

                    Icon successicon = new javax.swing.ImageIcon(getClass().getResource("/Extrafiles/successicon.png"));
                    
        JOptionPane.showMessageDialog(null,"<html><p style=\"color:black; font-size:18px; font-family: 'calibri'\">Transaction Deleted Successfully</p></html>","Success", JOptionPane.INFORMATION_MESSAGE,successicon);
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            getAEntries();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void viewAllSpendingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllSpendingsActionPerformed
        new viewSpending().setVisible(true);
    }//GEN-LAST:event_viewAllSpendingsActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        Icon exiticon = new javax.swing.ImageIcon(getClass().getResource("/Extrafiles/ExitIcon.png"));
        int r = JOptionPane.showConfirmDialog(null, "<html><p style=\"color:black; font-size:18px; font-family: 'calibri'\">Do you want to Exit ?</p></html>" , "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, exiticon);
        if (r == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       new aboutApp().setVisible(true); 
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void transactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionMouseClicked

    }//GEN-LAST:event_transactionMouseClicked

    private void aMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aMouseClicked

    }//GEN-LAST:event_aMouseClicked

    private void previousSpendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousSpendsActionPerformed
        currentViewLabel.setText("Last 30 Days Spending");
        getEntries();
    }//GEN-LAST:event_previousSpendsActionPerformed

    private void allSpendingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allSpendingsActionPerformed
        currentViewLabel.setText("All Spendings till Now");
        getAEntries();
    }//GEN-LAST:event_allSpendingsActionPerformed

    private void tableCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tableCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tableCaretPositionChanged

    private void sortedSpendingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortedSpendingsActionPerformed
        new SortedSpends().setVisible(true);
    }//GEN-LAST:event_sortedSpendingsActionPerformed

    private void jMenuBar1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jMenuBar1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuBar1FocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
      getAEntries();  
      displayCategory();
    }//GEN-LAST:event_formWindowGainedFocus

    private void spendMonthPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_spendMonthPropertyChange
        String selectedMonth = monthGetter();
        currentViewLabel.setText(selectedMonth);
        totalAmount.setText("0");
        getMEntries();
    }//GEN-LAST:event_spendMonthPropertyChange

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new allDeletion().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExpenseTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExpenseTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExpenseTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExpenseTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExpenseTracker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a;
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JButton allSpendings;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JLabel currentViewLabel;
    private com.toedter.calendar.JDateChooser d;
    private javax.swing.JMenuItem exitButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu masterMenu;
    private javax.swing.JButton previousSpends;
    private javax.swing.JMenuItem sortedSpendings;
    private com.toedter.calendar.JMonthChooser spendMonth;
    protected static javax.swing.JTable table;
    private javax.swing.JLabel totalAmount;
    private javax.swing.JTextField transaction;
    private javax.swing.JMenuItem viewAllSpendings;
    // End of variables declaration//GEN-END:variables
}
