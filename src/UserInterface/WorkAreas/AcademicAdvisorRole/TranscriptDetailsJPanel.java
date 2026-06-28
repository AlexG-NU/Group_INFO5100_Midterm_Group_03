/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.WorkAreas.AcademicAdvisorRole;

import Business.Advising.AdvisorAcademicData;
import Business.Business;
import Business.UserAccounts.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Janet 
 */
public class TranscriptDetailsJPanel extends javax.swing.JPanel {

    JPanel CardSequencePanel;
    Business business;
    UserAccount selectedStudentAccount;

    public TranscriptDetailsJPanel(Business bz, JPanel jp, UserAccount studentAccount) {
        this.business = bz;
        this.CardSequencePanel = jp;
        this.selectedStudentAccount = studentAccount;
        initComponents();
        displayTranscriptDetails();
    }

    private void displayTranscriptDetails() {
        if (selectedStudentAccount == null) {
            txtStudentName.setText("Not Available");
            txtNUID.setText("Not Available");
            txtGPA.setText("Not Available");
            txtCreditsCompleted.setText("Not Available");
            txtTranscriptDetails.setText("Student transcript data was not found.");
            return;
        }

        txtStudentName.setText(AdvisorAcademicData.getStudentName(selectedStudentAccount));
        txtNUID.setText(AdvisorAcademicData.getNuid(selectedStudentAccount));
        txtGPA.setText(AdvisorAcademicData.formatGpa(AdvisorAcademicData.calculateGpa(business, selectedStudentAccount)));
        txtCreditsCompleted.setText(String.valueOf(AdvisorAcademicData.calculateCreditsCompleted(business, selectedStudentAccount)));

        String transcript = AdvisorAcademicData.getCompletedCourses(business, selectedStudentAccount);
        if (transcript == null || transcript.trim().isEmpty()) {
            transcript = "No transcript/grade data has been entered for this student.";
        }
        txtTranscriptDetails.setText(transcript);
        txtTranscriptDetails.setCaretPosition(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblStudentName = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        lblNUID = new javax.swing.JLabel();
        txtNUID = new javax.swing.JTextField();
        lblGPA = new javax.swing.JLabel();
        txtGPA = new javax.swing.JTextField();
        lblCreditsCompleted = new javax.swing.JLabel();
        txtCreditsCompleted = new javax.swing.JTextField();
        lblTranscriptDetails = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTranscriptDetails = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(null);

        lblTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTitle.setText("View Transcript/ Grade Details");
        add(lblTitle);
        lblTitle.setBounds(30, 20, 500, 30);

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(30, 370, 90, 30);

        lblStudentName.setText("Student Name:");
        add(lblStudentName);
        lblStudentName.setBounds(30, 80, 120, 20);

        txtStudentName.setEditable(false);
        txtStudentName.setBackground(new java.awt.Color(204, 204, 204));
        add(txtStudentName);
        txtStudentName.setBounds(160, 80, 200, 24);

        lblNUID.setText("NUID:");
        add(lblNUID);
        lblNUID.setBounds(390, 80, 80, 20);

        txtNUID.setEditable(false);
        txtNUID.setBackground(new java.awt.Color(204, 204, 204));
        add(txtNUID);
        txtNUID.setBounds(510, 80, 190, 24);

        lblGPA.setText("GPA:");
        add(lblGPA);
        lblGPA.setBounds(30, 120, 120, 20);

        txtGPA.setEditable(false);
        txtGPA.setBackground(new java.awt.Color(204, 204, 204));
        add(txtGPA);
        txtGPA.setBounds(160, 120, 200, 24);

        lblCreditsCompleted.setText("Credits Completed:");
        add(lblCreditsCompleted);
        lblCreditsCompleted.setBounds(390, 110, 120, 30);

        txtCreditsCompleted.setEditable(false);
        txtCreditsCompleted.setBackground(new java.awt.Color(204, 204, 204));
        add(txtCreditsCompleted);
        txtCreditsCompleted.setBounds(510, 120, 190, 24);

        lblTranscriptDetails.setText("Completed Courses / Grades:");
        add(lblTranscriptDetails);
        lblTranscriptDetails.setBounds(30, 170, 250, 20);

        txtTranscriptDetails.setEditable(false);
        txtTranscriptDetails.setBackground(new java.awt.Color(204, 204, 204));
        txtTranscriptDetails.setColumns(20);
        txtTranscriptDetails.setLineWrap(true);
        txtTranscriptDetails.setRows(5);
        txtTranscriptDetails.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtTranscriptDetails);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 200, 670, 140);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).previous(CardSequencePanel);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCreditsCompleted;
    private javax.swing.JLabel lblGPA;
    private javax.swing.JLabel lblNUID;
    private javax.swing.JLabel lblStudentName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTranscriptDetails;
    private javax.swing.JTextField txtCreditsCompleted;
    private javax.swing.JTextField txtGPA;
    private javax.swing.JTextField txtNUID;
    private javax.swing.JTextField txtStudentName;
    private javax.swing.JTextArea txtTranscriptDetails;
    // End of variables declaration//GEN-END:variables
}
