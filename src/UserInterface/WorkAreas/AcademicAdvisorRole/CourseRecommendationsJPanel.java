package UserInterface.WorkAreas.AcademicAdvisorRole;

import Business.Advising.AdvisorRecord;
import Business.Business;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class CourseRecommendationsJPanel extends javax.swing.JPanel {

    JPanel CardSequencePanel;
    Business business;
    AdvisorRecord selectedRecord;

    public CourseRecommendationsJPanel(Business bz, JPanel jp) {
        this.business = bz;
        this.CardSequencePanel = jp;
        initComponents();
        refreshTable();
        clearFields();
    }

    public CourseRecommendationsJPanel(Business bz, JPanel jp, UserAccount selectedStudentAccount) {
        this.business = bz;
        this.CardSequencePanel = jp;
        initComponents();
        refreshTable();
        if (selectedStudentAccount != null) {
            AdvisorRecord record = business.getAdvisorRecordDirectory().getOrCreateRecord(selectedStudentAccount);
            displayRecord(record);
        } else {
            clearFields();
        }
    }

    public void refreshTable() {
        int rc = tblRecommendations.getRowCount();
        for (int i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) tblRecommendations.getModel()).removeRow(i);
        }

        UserAccountDirectory uad = business.getUserAccountDirectory();
        for (UserAccount ua : uad.getUserAccountList()) {
            if (ua.getAssociatedPersonProfile().getRole().equals("Student")) {
                AdvisorRecord record = business.getAdvisorRecordDirectory().getOrCreateRecord(ua);
                Object[] row = new Object[6];
                row[0] = record.getStudentId();
                row[1] = record.getStudentName();
                row[2] = record.getRecommendedCourses();
                row[3] = record.getLastMeetingDate();
                row[4] = record.getPotentialGraduationDate();
                row[5] = record.getAdvisorNotes();
                ((DefaultTableModel) tblRecommendations.getModel()).addRow(row);
            }
        }
    }

    private AdvisorRecord findRecordByStudentId(String studentId) {
        return business.getAdvisorRecordDirectory().findRecordByStudentId(studentId);
    }

    private void displayRecord(AdvisorRecord record) {
        selectedRecord = record;
        if (record == null) {
            clearFields();
            return;
        }
        txtStudentId.setText(record.getStudentId());
        txtStudentName.setText(record.getStudentName());
        txtLastMeetingDate.setText(record.getLastMeetingDate());
        txtPotentialGradDate.setText(record.getPotentialGraduationDate());
        txtRecommendedCourses.setText(record.getRecommendedCourses());
        txtAdvisorNotes.setText(record.getAdvisorNotes());
    }

    private void clearFields() {
        txtStudentId.setText("");
        txtStudentName.setText("");
        txtLastMeetingDate.setText("");
        txtPotentialGradDate.setText("");
        txtRecommendedCourses.setText("");
        txtAdvisorNotes.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecommendations = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        lblStudentId = new javax.swing.JLabel();
        txtStudentId = new javax.swing.JTextField();
        lblStudentName = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        lblLastMeetingDate = new javax.swing.JLabel();
        txtLastMeetingDate = new javax.swing.JTextField();
        lblPotentialGradDate = new javax.swing.JLabel();
        txtPotentialGradDate = new javax.swing.JTextField();
        lblRecommendedCourses = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRecommendedCourses = new javax.swing.JTextArea();
        lblAdvisorNotes = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAdvisorNotes = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(null);

        lblTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTitle.setText("Course Recommendations");
        add(lblTitle);
        lblTitle.setBounds(30, 20, 600, 30);

        tblRecommendations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Person ID", "Student Name", "Recommended Courses", "Last Meeting Date", "Potential Graduation Date", "Advisor Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRecommendations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblRecommendationsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblRecommendations);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 95, 850, 130);

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(30, 560, 90, 30);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh);
        btnRefresh.setBounds(140, 560, 90, 30);

        lblStudentId.setText("Student ID:");
        add(lblStudentId);
        lblStudentId.setBounds(30, 250, 100, 20);

        txtStudentId.setEditable(false);
        add(txtStudentId);
        txtStudentId.setBounds(160, 250, 220, 26);

        lblStudentName.setText("Student Name:");
        add(lblStudentName);
        lblStudentName.setBounds(30, 285, 100, 20);

        txtStudentName.setEditable(false);
        add(txtStudentName);
        txtStudentName.setBounds(160, 285, 220, 26);

        lblLastMeetingDate.setText("Last Meeting Date:");
        add(lblLastMeetingDate);
        lblLastMeetingDate.setBounds(30, 320, 130, 20);
        add(txtLastMeetingDate);
        txtLastMeetingDate.setBounds(160, 320, 220, 26);

        lblPotentialGradDate.setText("Potential Grad Date:");
        add(lblPotentialGradDate);
        lblPotentialGradDate.setBounds(30, 355, 130, 20);
        add(txtPotentialGradDate);
        txtPotentialGradDate.setBounds(160, 355, 220, 26);

        lblRecommendedCourses.setText("Recommended Courses:");
        add(lblRecommendedCourses);
        lblRecommendedCourses.setBounds(410, 250, 140, 20);

        txtRecommendedCourses.setColumns(20);
        txtRecommendedCourses.setRows(5);
        jScrollPane2.setViewportView(txtRecommendedCourses);

        add(jScrollPane2);
        jScrollPane2.setBounds(570, 250, 310, 90);

        lblAdvisorNotes.setText("Advisor Notes:");
        add(lblAdvisorNotes);
        lblAdvisorNotes.setBounds(410, 360, 150, 20);

        txtAdvisorNotes.setColumns(20);
        txtAdvisorNotes.setRows(5);
        jScrollPane3.setViewportView(txtAdvisorNotes);

        add(jScrollPane3);
        jScrollPane3.setBounds(570, 360, 310, 120);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave);
        btnSave.setBounds(760, 560, 80, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).previous(CardSequencePanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refreshTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (selectedRecord == null) {
            JOptionPane.showMessageDialog(this, "Please select a student first.");
            return;
        }
        selectedRecord.setLastMeetingDate(txtLastMeetingDate.getText().trim());
        selectedRecord.setPotentialGraduationDate(txtPotentialGradDate.getText().trim());
        selectedRecord.setRecommendedCourses(txtRecommendedCourses.getText().trim());
        selectedRecord.setAdvisorNotes(txtAdvisorNotes.getText().trim());
        JOptionPane.showMessageDialog(this, "Advisor recommendation saved.");
        refreshTable();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tblRecommendationsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRecommendationsMousePressed
        int selectedrow = tblRecommendations.getSelectedRow();
        if (selectedrow < 0) {
            return;
        }
        String studentId = (String) tblRecommendations.getValueAt(selectedrow, 0);
        displayRecord(findRecordByStudentId(studentId));
    }//GEN-LAST:event_tblRecommendationsMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAdvisorNotes;
    private javax.swing.JLabel lblLastMeetingDate;
    private javax.swing.JLabel lblPotentialGradDate;
    private javax.swing.JLabel lblRecommendedCourses;
    private javax.swing.JLabel lblStudentId;
    private javax.swing.JLabel lblStudentName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblRecommendations;
    private javax.swing.JTextArea txtAdvisorNotes;
    private javax.swing.JTextField txtLastMeetingDate;
    private javax.swing.JTextField txtPotentialGradDate;
    private javax.swing.JTextArea txtRecommendedCourses;
    private javax.swing.JTextField txtStudentId;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
