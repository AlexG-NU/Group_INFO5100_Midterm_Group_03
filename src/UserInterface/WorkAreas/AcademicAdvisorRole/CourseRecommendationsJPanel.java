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
        loadAvailableCourses();
        refreshTable();
        clearFields();
    }

    public CourseRecommendationsJPanel(Business bz, JPanel jp, UserAccount selectedStudentAccount) {
        this.business = bz;
        this.CardSequencePanel = jp;
        initComponents();
        loadAvailableCourses();
        refreshTable();
        if (selectedStudentAccount != null) {
            AdvisorRecord record = business.getAdvisorRecordDirectory().getOrCreateRecord(selectedStudentAccount);
            displayRecord(record);
        } else {
            clearFields();
        }
    }

    private void loadAvailableCourses() {
        cmbAvailableCourses.removeAllItems();
        cmbAvailableCourses.addItem("INFO 5100 - Application Engineering and Development");
        cmbAvailableCourses.addItem("INFO 6150 - Web Design and User Experience Engineering");
        cmbAvailableCourses.addItem("DAMG 6210 - Data Management and Database Design");
        cmbAvailableCourses.addItem("INFO 6205 - Program Structure and Algorithms");
        cmbAvailableCourses.addItem("CSYE 6200 - Concepts of Object-Oriented Design");
        cmbAvailableCourses.addItem("INFO 7250 - Engineering Big Data Systems");
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
                Object[] row = new Object[5];
                row[0] = record.getStudentNuid();
                row[1] = record.getStudentName();
                row[2] = record.getRecommendedCourses();
                row[3] = record.getLastMeetingDate();
                row[4] = record.getPotentialGraduationDate();
                ((DefaultTableModel) tblRecommendations.getModel()).addRow(row);
            }
        }
    }

    private AdvisorRecord findRecordByStudentNuid(String nuid) {
        return business.getAdvisorRecordDirectory().findRecordByStudentNuid(nuid);
    }

    private void displayRecord(AdvisorRecord record) {
        selectedRecord = record;
        if (record == null) {
            clearFields();
            return;
        }
        txtStudentId.setText(record.getStudentNuid());
        txtStudentName.setText(record.getStudentName());
        txtLastMeetingDate.setText(record.getLastMeetingDate());
        txtPotentialGradDate.setText(record.getPotentialGraduationDate());
        txtRecommendedCourses.setText(record.getRecommendedCourses());
        txtAdvisorNotes.setText(record.getAdvisorNotes());
    }

    private void clearFields() {
        selectedRecord = null;
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
        lblAvailableCourses = new javax.swing.JLabel();
        cmbAvailableCourses = new javax.swing.JComboBox<>();
        btnAddCourse = new javax.swing.JButton();
        lblRecommendedCourses = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRecommendedCourses = new javax.swing.JTextArea();
        lblAdvisorNotes = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAdvisorNotes = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(null);

        lblTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTitle.setText("Course Recommendations");
        add(lblTitle);
        lblTitle.setBounds(30, 20, 600, 30);

        tblRecommendations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NUID", "Student Name", "Recommended Courses", "Last Meeting Date", "Potential Graduation Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        jScrollPane1.setBounds(30, 95, 900, 130);

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(30, 600, 90, 30);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh);
        btnRefresh.setBounds(140, 600, 90, 30);

        lblStudentId.setText("NUID:");
        add(lblStudentId);
        lblStudentId.setBounds(30, 250, 100, 20);

        txtStudentId.setEditable(false);
        txtStudentId.setBackground(new java.awt.Color(204, 204, 204));
        add(txtStudentId);
        txtStudentId.setBounds(160, 250, 220, 26);

        lblStudentName.setText("Student Name:");
        add(lblStudentName);
        lblStudentName.setBounds(30, 285, 100, 20);

        txtStudentName.setEditable(false);
        txtStudentName.setBackground(new java.awt.Color(204, 204, 204));
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

        lblAvailableCourses.setText("Available Course:");
        add(lblAvailableCourses);
        lblAvailableCourses.setBounds(410, 250, 140, 20);
        add(cmbAvailableCourses);
        cmbAvailableCourses.setBounds(570, 250, 360, 26);

        btnAddCourse.setText("Add Course");
        btnAddCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCourseActionPerformed(evt);
            }
        });
        add(btnAddCourse);
        btnAddCourse.setBounds(570, 285, 120, 30);

        lblRecommendedCourses.setText("Recommended Courses:");
        add(lblRecommendedCourses);
        lblRecommendedCourses.setBounds(410, 325, 150, 20);

        txtRecommendedCourses.setColumns(20);
        txtRecommendedCourses.setLineWrap(true);
        txtRecommendedCourses.setRows(5);
        jScrollPane2.setViewportView(txtRecommendedCourses);

        add(jScrollPane2);
        jScrollPane2.setBounds(570, 325, 360, 80);

        lblAdvisorNotes.setText("Advisor Notes:");
        add(lblAdvisorNotes);
        lblAdvisorNotes.setBounds(410, 425, 150, 20);

        txtAdvisorNotes.setColumns(20);
        txtAdvisorNotes.setLineWrap(true);
        txtAdvisorNotes.setRows(5);
        jScrollPane3.setViewportView(txtAdvisorNotes);

        add(jScrollPane3);
        jScrollPane3.setBounds(570, 425, 360, 125);

        btnSave.setText("Save / Update");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave);
        btnSave.setBounds(790, 600, 120, 30);

        btnClear.setText("Clear Fields");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        add(btnClear);
        btnClear.setBounds(650, 600, 120, 30);
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

    private void btnAddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCourseActionPerformed
        if (selectedRecord == null) {
            JOptionPane.showMessageDialog(this, "Please select a student first.");
            return;
        }
        String course = (String) cmbAvailableCourses.getSelectedItem();
        selectedRecord.addRecommendedCourse(course);
        txtRecommendedCourses.setText(selectedRecord.getRecommendedCourses());
        refreshTable();
    }//GEN-LAST:event_btnAddCourseActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        if (selectedRecord == null) {
            JOptionPane.showMessageDialog(this, "Please select a student first.");
            return;
        }
        txtRecommendedCourses.setText("");
        txtAdvisorNotes.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void tblRecommendationsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRecommendationsMousePressed
        int selectedrow = tblRecommendations.getSelectedRow();
        if (selectedrow < 0) {
            return;
        }
        String nuid = (String) tblRecommendations.getValueAt(selectedrow, 0);
        displayRecord(findRecordByStudentNuid(nuid));
    }//GEN-LAST:event_tblRecommendationsMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCourse;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbAvailableCourses;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAdvisorNotes;
    private javax.swing.JLabel lblAvailableCourses;
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
