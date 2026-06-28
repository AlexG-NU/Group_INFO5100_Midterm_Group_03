/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface.WorkAreas.StudentRole;

import Business.Advising.AdvisorAcademicData;
import Business.Business;
import Business.Advising.AdvisorRecord;
import Business.Profiles.StudentProfile;
import Business.UserAccounts.UserAccount;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * StudentGraduationAuditJPanel allows student users to review graduation
 * progress, credits completed, credits required, remaining credits, GPA,
 * expected graduation date, and graduation status.
 *
 * Author: @connorewart
 */
public class StudentGraduationAuditJPanel extends JPanel {

    private Business business;
    private StudentProfile student;
    private AdvisorRecord advisorRecord;
    private UserAccount studentAccount;

    private JTable tblGraduationAudit;
    private JLabel lblStudentName;
    private JLabel lblNuid;
    private JLabel lblDepartment;
    private JLabel lblGpa;
    private JLabel lblExpectedGraduation;
    private JButton btnRefresh;
    private JButton btnBack;

    public StudentGraduationAuditJPanel(Business business, StudentProfile student) {
        this.business = business;
        this.student = student;

        loadAdvisorRecord();
        initComponents();
        populateGraduationAudit();
    }

    private void loadAdvisorRecord() {
        studentAccount = findStudentUserAccount();
        
        if (business != null && student != null && student.getPerson() != null) {
            String studentId = student.getPerson().getPersonId();
            advisorRecord = business.getAdvisorRecordDirectory().findRecordByStudentId(studentId);
        }
    }
    
    private UserAccount findStudentUserAccount() {
        if(business == null || student == null || student.getPerson() == null) {
            return null;
        }
        
        String studentPersonId = student.getPerson().getPersonId();
        
        for(UserAccount ua: business.getUserAccountDirectory().getUserAccountList()){
            if(ua.getAssociatedPersonProfile() != null
                    && ua.getAssociatedPersonProfile().getPerson() != null
                    && ua.getAssociatedPersonProfile().getPerson().getPersonId().equals(studentPersonId)){
                return ua;
            }
        }
        return null;
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Graduation Audit");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout());

        JPanel studentInfoPanel = new JPanel(new GridLayout(5, 1));

        lblStudentName = new JLabel("Student: ");
        lblNuid = new JLabel("NUID: ");
        lblDepartment = new JLabel("Department: ");
        lblGpa = new JLabel("GPA: ");
        lblExpectedGraduation = new JLabel("Expected Graduation: ");

        studentInfoPanel.add(lblStudentName);
        studentInfoPanel.add(lblNuid);
        studentInfoPanel.add(lblDepartment);
        studentInfoPanel.add(lblGpa);
        studentInfoPanel.add(lblExpectedGraduation);

        centerPanel.add(studentInfoPanel, BorderLayout.NORTH);

        tblGraduationAudit = new JTable();
        tblGraduationAudit.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Student", "Credits Completed", "Credits Required", "Remaining Credits", "Status"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        centerPanel.add(new JScrollPane(tblGraduationAudit), BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

        btnRefresh = new JButton("Refresh");
        btnRefresh.addActionListener(e -> {
            loadAdvisorRecord();
            populateGraduationAudit();
        });

        btnBack = new JButton("Back");
        btnBack.addActionListener(e -> goBack());

        buttonPanel.add(btnRefresh);
        buttonPanel.add(btnBack);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void populateGraduationAudit() {
        if (student == null || student.getPerson() == null) {
            JOptionPane.showMessageDialog(this, "No student profile found.");
            return;
        }

        String studentName = student.getPerson().getFullName();
        String nuid = student.getPerson().getNuid();
        String department = student.getPerson().getDepartment();

        lblStudentName.setText("Student: " + studentName);
        lblNuid.setText("NUID: " + nuid);
        lblDepartment.setText("Department: " + department);

        DefaultTableModel model = (DefaultTableModel) tblGraduationAudit.getModel();
        model.setRowCount(0);

        int creditsCompleted = AdvisorAcademicData.calculateCreditsCompleted(business, studentAccount);
        double gpa = AdvisorAcademicData.calculateGpa(business, studentAccount);

        int creditsRequired = 120;
        String expectedGraduation = "Not available";

        if (advisorRecord != null) {
            creditsRequired = advisorRecord.getCreditsRequired();
            expectedGraduation = advisorRecord.getPotentialGraduationDate();
        }

        int remainingCredits = Math.max(creditsRequired - creditsCompleted, 0);
        String status = AdvisorAcademicData.calculateGraduationStatus(business, studentAccount, advisorRecord);

        lblGpa.setText("GPA: " + String.format("%.2f", gpa));
        lblExpectedGraduation.setText("Expected Graduation: " + expectedGraduation);

        Object[] row = new Object[5];
        row[0] = studentName;
        row[1] = creditsCompleted;
        row[2] = creditsRequired;
        row[3] = remainingCredits;
        row[4] = status;

        model.addRow(row);
    }

    private void goBack() {
        java.awt.Container parent = getParent();

        if (parent != null && parent.getLayout() instanceof java.awt.CardLayout) {
            ((java.awt.CardLayout) parent.getLayout()).show(parent, "student");
            parent.revalidate();
            parent.repaint();
        }
    }
}
