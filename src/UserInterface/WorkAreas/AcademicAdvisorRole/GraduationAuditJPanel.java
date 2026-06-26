package UserInterface.WorkAreas.AcademicAdvisorRole;

import Business.Advising.AdvisorRecord;
import Business.Business;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class GraduationAuditJPanel extends javax.swing.JPanel {

    JPanel CardSequencePanel;
    Business business;

    public GraduationAuditJPanel(Business bz, JPanel jp) {
        this.business = bz;
        this.CardSequencePanel = jp;
        initComponents();
        refreshTable();
    }

    public void refreshTable() {
        int rc = tblAudit.getRowCount();
        for (int i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) tblAudit.getModel()).removeRow(i);
        }

        UserAccountDirectory uad = business.getUserAccountDirectory();
        for (UserAccount ua : uad.getUserAccountList()) {
            if (ua.getAssociatedPersonProfile().getRole().equals("Student")) {
                AdvisorRecord record = business.getAdvisorRecordDirectory().getOrCreateRecord(ua);
                String status = record.getGraduationStatus();
                Object[] row = new Object[7];
                row[0] = record.getStudentNuid();
                row[1] = record.getStudentName();
                row[2] = record.getCreditsCompleted();
                row[3] = record.getCreditsRequired();
                row[4] = record.getRemainingCredits();
                row[5] = record.getPotentialGraduationDate();
                row[6] = status;
                ((DefaultTableModel) tblAudit.getModel()).addRow(row);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAudit = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(null);

        lblTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTitle.setText("Graduation Audit");
        add(lblTitle);
        lblTitle.setBounds(30, 20, 500, 30);

        tblAudit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NUID", "Student Name", "Credits Completed", "Credits Required", "Remaining Credits", "Potential Graduation Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAudit);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 110, 900, 150);

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
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).previous(CardSequencePanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refreshTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblAudit;
    // End of variables declaration//GEN-END:variables
}
