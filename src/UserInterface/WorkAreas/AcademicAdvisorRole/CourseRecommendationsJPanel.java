/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.AcademicAdvisorRole;

import Business.Advising.AdvisorRecord;
import Business.Advising.AdvisorAcademicData;
import Business.Business;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import UserInterface.WorkAreas.AcademicAdvisorRole.StudentDetailJPanel;
import CourseCatalog.Course;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author janet
 */

public class CourseRecommendationsJPanel extends javax.swing.JPanel {

    JPanel CardSequencePanel;
    Business business;
    AdvisorRecord selectedRecord;
    UserAccount selectedStudentAccount;

    public CourseRecommendationsJPanel(Business bz, JPanel jp) {
        this.business = bz;
        this.CardSequencePanel = jp;
        this.selectedStudentAccount = null;
        initComponents();
        loadAvailableCourses();
        refreshTable();
        clearFields();
    }

    public CourseRecommendationsJPanel(Business bz, JPanel jp, UserAccount selectedStudentAccount) {
        this.business = bz;
        this.CardSequencePanel = jp;
        this.selectedStudentAccount = selectedStudentAccount;
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
        cmbAvailableCourses.addItem("-- Select Course --");

        if (business != null
                && business.getDepartment() != null
                && business.getDepartment().getCourseCatalog() != null) {
            for (Course course : business.getDepartment().getCourseCatalog().getCourseList()) {
                cmbAvailableCourses.addItem(AdvisorAcademicData.courseDisplay(course));
            }
        }

        if (cmbAvailableCourses.getItemCount() == 1) {
            cmbAvailableCourses.addItem("No courses available");
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
        if (record != null) {
            selectedStudentAccount = record.getStudentAccount();
        }
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

    private boolean isValidDate(String dateValue) {
        if (dateValue == null || dateValue.trim().isEmpty()) {
            return false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(dateValue.trim());
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    private boolean validateRecommendationFields() {
        if (txtLastMeetingDate.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a last meeting date in MM/dd/yyyy format.");
            return false;
        }
        if (!isValidDate(txtLastMeetingDate.getText())) {
            JOptionPane.showMessageDialog(this, "Last meeting date must use MM/dd/yyyy format.");
            return false;
        }
        if (txtPotentialGradDate.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a potential graduation date in MM/dd/yyyy format.");
            return false;
        }
        if (!isValidDate(txtPotentialGradDate.getText())) {
            JOptionPane.showMessageDialog(this, "Potential graduation date must use MM/dd/yyyy format.");
            return false;
        }
        if (txtRecommendedCourses.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter at least one recommended course.");
            return false;
        }
        if (txtAdvisorNotes.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter advisor notes.");
            return false;
        }
        return true;
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
        btnViewCompletedCourses = new javax.swing.JButton();
        lblLastMeetingDate1 = new javax.swing.JLabel();
        lblLastMeetingDate2 = new javax.swing.JLabel();

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
        jScrollPane1.setBounds(30, 95, 860, 130);

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
        lblStudentName.setBounds(30, 290, 100, 20);

        txtStudentName.setEditable(false);
        txtStudentName.setBackground(new java.awt.Color(204, 204, 204));
        add(txtStudentName);
        txtStudentName.setBounds(160, 290, 220, 26);

        lblLastMeetingDate.setText("Last Meeting Date:");
        add(lblLastMeetingDate);
        lblLastMeetingDate.setBounds(30, 340, 130, 20);
        add(txtLastMeetingDate);
        txtLastMeetingDate.setBounds(160, 340, 220, 26);

        lblPotentialGradDate.setText("Potential Grad Date:");
        add(lblPotentialGradDate);
        lblPotentialGradDate.setBounds(30, 390, 130, 20);
        add(txtPotentialGradDate);
        txtPotentialGradDate.setBounds(160, 390, 220, 26);

        lblAvailableCourses.setText("Available Course:");
        add(lblAvailableCourses);
        lblAvailableCourses.setBounds(410, 250, 140, 20);
        add(cmbAvailableCourses);
        cmbAvailableCourses.setBounds(560, 250, 320, 26);

        btnAddCourse.setText("Add Course");
        btnAddCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCourseActionPerformed(evt);
            }
        });
        add(btnAddCourse);
        btnAddCourse.setBounds(560, 290, 120, 30);

        lblRecommendedCourses.setText("Recommended Courses:");
        add(lblRecommendedCourses);
        lblRecommendedCourses.setBounds(410, 320, 140, 20);

        txtRecommendedCourses.setColumns(20);
        txtRecommendedCourses.setLineWrap(true);
        txtRecommendedCourses.setRows(5);
        jScrollPane2.setViewportView(txtRecommendedCourses);

        add(jScrollPane2);
        jScrollPane2.setBounds(560, 330, 320, 80);

        lblAdvisorNotes.setText("Advisor Notes:");
        add(lblAdvisorNotes);
        lblAdvisorNotes.setBounds(410, 430, 140, 20);

        txtAdvisorNotes.setColumns(20);
        txtAdvisorNotes.setLineWrap(true);
        txtAdvisorNotes.setRows(5);
        jScrollPane3.setViewportView(txtAdvisorNotes);

        add(jScrollPane3);
        jScrollPane3.setBounds(560, 430, 320, 125);

        btnSave.setText("Save / Update");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave);
        btnSave.setBounds(760, 600, 120, 30);

        btnClear.setText("Clear Fields");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        add(btnClear);
        btnClear.setBounds(620, 600, 120, 30);

        btnViewCompletedCourses.setText("View Completed Courses");
        btnViewCompletedCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewCompletedCoursesActionPerformed(evt);
            }
        });
        add(btnViewCompletedCourses);
        btnViewCompletedCourses.setBounds(700, 290, 180, 30);

        lblLastMeetingDate1.setText("(MM/dd/yyyy):");
        add(lblLastMeetingDate1);
        lblLastMeetingDate1.setBounds(30, 410, 130, 20);

        lblLastMeetingDate2.setText("(MM/dd/yyyy):");
        add(lblLastMeetingDate2);
        lblLastMeetingDate2.setBounds(30, 360, 130, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        refreshOpenStudentDetailPanel();
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
        if (!validateRecommendationFields()) {
            return;
        }
        selectedRecord.setLastMeetingDate(txtLastMeetingDate.getText().trim());
        selectedRecord.setPotentialGraduationDate(txtPotentialGradDate.getText().trim());
        selectedRecord.setRecommendedCourses(txtRecommendedCourses.getText().trim());
        selectedRecord.setAdvisorNotes(txtAdvisorNotes.getText().trim());
        JOptionPane.showMessageDialog(this, "Advisor recommendation saved.");
        refreshTable();
        displayRecord(selectedRecord);
        refreshOpenStudentDetailPanel();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCourseActionPerformed
        if (selectedRecord == null) {
            JOptionPane.showMessageDialog(this, "Please select a student first.");
            return;
        }
        Object selectedCourse = cmbAvailableCourses.getSelectedItem();
        if (selectedCourse == null) {
            JOptionPane.showMessageDialog(this, "Please select an available course first.");
            return;
        }

        String course = selectedCourse.toString().trim();
        if (course.isEmpty() || course.equals("-- Select Course --") || course.equals("No courses available")) {
            JOptionPane.showMessageDialog(this, "Please select a valid available course first.");
            return;
        }

        String currentCourses = txtRecommendedCourses.getText().trim();
        if (currentCourses.contains(course)) {
            JOptionPane.showMessageDialog(this, "This course is already listed for the selected student.");
            return;
        }

        if (currentCourses.isEmpty()) {
            txtRecommendedCourses.setText(course);
        } else {
            txtRecommendedCourses.setText(currentCourses + ", " + course);
        }
   
    }//GEN-LAST:event_btnAddCourseActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        if (selectedRecord == null) {
            JOptionPane.showMessageDialog(this, "Please select a student first.");
            return;
        }
        txtLastMeetingDate.setText("");
        txtPotentialGradDate.setText("");
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

    private void btnViewCompletedCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewCompletedCoursesActionPerformed
        // TODO add your handling code here:
        if (selectedRecord == null || selectedStudentAccount == null) {
            JOptionPane.showMessageDialog(this, "Please select a student first.");
            return;
        }

        TranscriptDetailsJPanel panel = new TranscriptDetailsJPanel(business, CardSequencePanel, selectedStudentAccount);
        CardSequencePanel.add("TranscriptDetailsJPanel", panel);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }

    private void refreshOpenStudentDetailPanel() {
        if (CardSequencePanel == null) {
            return;
        }
        for (Component component : CardSequencePanel.getComponents()) {
            if (component instanceof StudentDetailJPanel) {
                ((StudentDetailJPanel) component).displayStudentDetails();
            }
            if (component instanceof ViewStudentsJPanel) {
                ((ViewStudentsJPanel) component).refreshTable();
            }
            if (component instanceof AcademicProgressJPanel) {
                ((AcademicProgressJPanel) component).refreshTable();
            }
        }
    
    }//GEN-LAST:event_btnViewCompletedCoursesActionPerformed

   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCourse;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnViewCompletedCourses;
    private javax.swing.JComboBox<String> cmbAvailableCourses;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAdvisorNotes;
    private javax.swing.JLabel lblAvailableCourses;
    private javax.swing.JLabel lblLastMeetingDate;
    private javax.swing.JLabel lblLastMeetingDate1;
    private javax.swing.JLabel lblLastMeetingDate2;
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
