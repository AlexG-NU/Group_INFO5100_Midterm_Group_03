/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package UserInterface.WorkAreas.AcademicAdvisorRole;

import Business.Advising.AdvisorRecord;
import Business.Business;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class GraduationAuditJPanel extends javax.swing.JPanel {

    JPanel CardSequencePanel;
    Business business;
    UserAccount selectedStudentAccount;
    AdvisorRecord selectedRecord;

    public GraduationAuditJPanel(Business bz, JPanel jp) {
        this.business = bz;
        this.CardSequencePanel = jp;
        initComponents();
        refreshTable();
        clearReviewFields();
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
                Object[] row = new Object[6];
                row[0] = record.getStudentNuid();
                row[1] = record.getStudentName();
                row[2] = record.getCreditsCompleted();
                row[3] = record.getCreditsRequired();
                row[4] = record.getRemainingCredits();
                row[5] = record.getGraduationStatus();
                ((DefaultTableModel) tblAudit.getModel()).addRow(row);
            }
        }
    }

    private void loadSelectedRecord() {
        if (selectedRecord == null) {
            clearReviewFields();
            return;
        }

        txtSelectedStudent.setText(selectedRecord.getStudentName());
        txtPotentialGraduationDate.setText(selectedRecord.getPotentialGraduationDate());
        cmbGraduationPlanStatus.setSelectedItem(selectedRecord.getGraduationPlanStatus());
        txtGraduationReviewNotes.setText(selectedRecord.getGraduationReviewNotes());
    }

    private void clearReviewFields() {
     
        txtPotentialGraduationDate.setText("");
        cmbGraduationPlanStatus.setSelectedItem("Needs Review");
        txtGraduationReviewNotes.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAudit = new javax.swing.JTable();
        lblSelectedStudent = new javax.swing.JLabel();
        txtSelectedStudent = new javax.swing.JTextField();
        lblPotentialGraduationDate = new javax.swing.JLabel();
        txtPotentialGraduationDate = new javax.swing.JTextField();
        lblGraduationPlanStatus = new javax.swing.JLabel();
        cmbGraduationPlanStatus = new javax.swing.JComboBox<>();
        lblGraduationReviewNotes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGraduationReviewNotes = new javax.swing.JTextArea();
        btnBack = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnSaveReview = new javax.swing.JButton();
        btnClearFields = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(null);

        lblTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTitle.setText("Graduation Audit");
        add(lblTitle);
        lblTitle.setBounds(30, 20, 500, 30);

        tblAudit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NUID", "Student Name", "Completed", "Required", "Remaining", "Audit Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAudit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblAuditMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblAudit);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 900, 150);

        lblSelectedStudent.setText("Student:");
        add(lblSelectedStudent);
        lblSelectedStudent.setBounds(30, 250, 130, 25);

        txtSelectedStudent.setEditable(false);
        add(txtSelectedStudent);
        txtSelectedStudent.setBounds(180, 250, 250, 25);

        lblPotentialGraduationDate.setText("Potential Graduation Date:");
        add(lblPotentialGraduationDate);
        lblPotentialGraduationDate.setBounds(30, 285, 160, 25);
        add(txtPotentialGraduationDate);
        txtPotentialGraduationDate.setBounds(180, 285, 250, 25);

        lblGraduationPlanStatus.setText("Graduation Plan Status:");
        add(lblGraduationPlanStatus);
        lblGraduationPlanStatus.setBounds(30, 320, 160, 25);

        cmbGraduationPlanStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Needs Review", "On Track", "At Risk", "Ready for Final Review" }));
        add(cmbGraduationPlanStatus);
        cmbGraduationPlanStatus.setBounds(180, 320, 250, 25);

        lblGraduationReviewNotes.setText("Graduation Review Notes:");
        add(lblGraduationReviewNotes);
        lblGraduationReviewNotes.setBounds(470, 250, 170, 25);

        txtGraduationReviewNotes.setColumns(20);
        txtGraduationReviewNotes.setLineWrap(true);
        txtGraduationReviewNotes.setRows(5);
        txtGraduationReviewNotes.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtGraduationReviewNotes);

        add(jScrollPane2);
        jScrollPane2.setBounds(630, 250, 300, 95);

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(30, 390, 90, 30);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh);
        btnRefresh.setBounds(140, 390, 90, 30);

        btnSaveReview.setText("Save Review");
        btnSaveReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveReviewActionPerformed(evt);
            }
        });
        add(btnSaveReview);
        btnSaveReview.setBounds(630, 390, 120, 30);

        btnClearFields.setText("Clear Fields");
        btnClearFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFieldsActionPerformed(evt);
            }
        });
        add(btnClearFields);
        btnClearFields.setBounds(770, 390, 120, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).previous(CardSequencePanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refreshTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblAuditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAuditMousePressed
        int selectedRow = tblAudit.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }

        String nuid = String.valueOf(tblAudit.getValueAt(selectedRow, 0));
        selectedRecord = business.getAdvisorRecordDirectory().findRecordByStudentNuid(nuid);
        if (selectedRecord != null) {
            selectedStudentAccount = selectedRecord.getStudentAccount();
        }
        loadSelectedRecord();
    }//GEN-LAST:event_tblAuditMousePressed

    private void btnSaveReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveReviewActionPerformed
        if (selectedRecord == null) {
            JOptionPane.showMessageDialog(this, "Please select one student first.");
            return;
        }

        selectedRecord.setPotentialGraduationDate(txtPotentialGraduationDate.getText().trim());
        selectedRecord.setGraduationPlanStatus(String.valueOf(cmbGraduationPlanStatus.getSelectedItem()));
        selectedRecord.setGraduationReviewNotes(txtGraduationReviewNotes.getText().trim());
        JOptionPane.showMessageDialog(this, "Graduation review saved.");
        refreshTable();
        loadSelectedRecord();
    }//GEN-LAST:event_btnSaveReviewActionPerformed

    private void btnClearFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFieldsActionPerformed
        clearReviewFields();
    }//GEN-LAST:event_btnClearFieldsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClearFields;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSaveReview;
    private javax.swing.JComboBox<String> cmbGraduationPlanStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGraduationPlanStatus;
    private javax.swing.JLabel lblGraduationReviewNotes;
    private javax.swing.JLabel lblPotentialGraduationDate;
    private javax.swing.JLabel lblSelectedStudent;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblAudit;
    private javax.swing.JTextArea txtGraduationReviewNotes;
    private javax.swing.JTextField txtPotentialGraduationDate;
    private javax.swing.JTextField txtSelectedStudent;
    // End of variables declaration//GEN-END:variables
}
