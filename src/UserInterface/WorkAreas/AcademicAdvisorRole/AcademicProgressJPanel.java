package UserInterface.WorkAreas.AcademicAdvisorRole;

import Business.Advising.AdvisorRecord;
import Business.Advising.AdvisorAcademicData;
import Business.Business;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class AcademicProgressJPanel extends javax.swing.JPanel {

    JPanel CardSequencePanel;
    Business business;

    public AcademicProgressJPanel(Business bz, JPanel jp) {
        this.business = bz;
        this.CardSequencePanel = jp;
        initComponents();
        refreshTable();
    }

    public void refreshTable() {
        int rc = tblProgress.getRowCount();
        for (int i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) tblProgress.getModel()).removeRow(i);
        }

        UserAccountDirectory uad = business.getUserAccountDirectory();
        for (UserAccount ua : uad.getUserAccountList()) {
            if (ua.getAssociatedPersonProfile().getRole().equals("Student")) {
                AdvisorRecord record = business.getAdvisorRecordDirectory().getOrCreateRecord(ua);
                AdvisorAcademicData.syncAdvisorRecord(business, record);
                Object[] row = new Object[6];
                row[0] = AdvisorAcademicData.getNuid(ua);
                row[1] = AdvisorAcademicData.getStudentName(ua);
                row[2] = AdvisorAcademicData.getDepartment(ua);
                row[3] = AdvisorAcademicData.calculateCreditsCompleted(business, ua);
                row[4] = AdvisorAcademicData.formatGpa(AdvisorAcademicData.calculateGpa(business, ua));
                row[5] = AdvisorAcademicData.calculateAcademicStanding(business, ua, record);
              
                ((DefaultTableModel) tblProgress.getModel()).addRow(row);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblTable = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProgress = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnViewTranscript = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(null);

        lblTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTitle.setText("View Academic Progress");
        add(lblTitle);
        lblTitle.setBounds(30, 20, 500, 30);

        lblTable.setText("Student Academic Progress Summary");
        add(lblTable);
        lblTable.setBounds(30, 90, 300, 20);

        tblProgress.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NUID", "Student Name", "Department", "Credits Completed", "GPA", "Academic Standing"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProgress);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 110, 800, 150);

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(30, 300, 90, 30);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh);
        btnRefresh.setBounds(140, 300, 90, 30);

        btnViewTranscript.setText("View Transcript Details");
        btnViewTranscript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewTranscriptActionPerformed(evt);
            }
        });
        add(btnViewTranscript);
        btnViewTranscript.setBounds(640, 300, 180, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).previous(CardSequencePanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refreshTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnViewTranscriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewTranscriptActionPerformed
        // TODO add your handling code here:
         int selectedRow = tblProgress.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select one student first.");
            return;
        }

        String nuid = String.valueOf(tblProgress.getValueAt(selectedRow, 0));
        UserAccount selectedStudent = null;
        for (UserAccount ua : business.getUserAccountDirectory().getUserAccountList()) {
            if (ua.getAssociatedPersonProfile().getRole().equals("Student")
                    && AdvisorAcademicData.getNuid(ua).equals(nuid)) {
                selectedStudent = ua;
                break;
            }
        }

        if (selectedStudent == null) {
            JOptionPane.showMessageDialog(this, "Student transcript data was not found.");
            return;
        }

        TranscriptDetailsJPanel panel = new TranscriptDetailsJPanel(business, CardSequencePanel, selectedStudent);
        CardSequencePanel.add("TranscriptDetailsJPanel", panel);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    
    }//GEN-LAST:event_btnViewTranscriptActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnViewTranscript;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTable;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblProgress;
    // End of variables declaration//GEN-END:variables
}
