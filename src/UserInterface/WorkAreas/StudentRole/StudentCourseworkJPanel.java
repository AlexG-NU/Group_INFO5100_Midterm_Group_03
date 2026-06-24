/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface.WorkAreas.StudentRole;

import Coursework.CourseworkAssignment;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 * StudentCourseworkJPanel allows student users to view coursework,
 * submit assignments, and track assignment progress.
 *
 * Author: @connorewart
 */
public class StudentCourseworkJPanel extends JPanel {

    private ArrayList<CourseworkAssignment> courseworkList;
    private JTable tblCoursework;
    private JTextArea txtSubmission;
    private JButton btnSubmit;
    private JButton btnRefresh;
    private JButton btnBack;

    public StudentCourseworkJPanel() {
        courseworkList = new ArrayList<>();
        initializeSampleCoursework();
        initComponents();
        populateCourseworkTable();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Manage Coursework");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        tblCoursework = new JTable();
        tblCoursework.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Course", "Assignment", "Due Date", "Status", "Grade"}
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        JScrollPane tableScrollPane = new JScrollPane(tblCoursework);
        add(tableScrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JLabel submissionLabel = new JLabel("Submission Text:");
        bottomPanel.add(submissionLabel, BorderLayout.NORTH);

        txtSubmission = new JTextArea(5, 30);
        JScrollPane submissionScrollPane = new JScrollPane(txtSubmission);
        bottomPanel.add(submissionScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));

        btnSubmit = new JButton("Submit Assignment");
        btnSubmit.addActionListener(e -> submitSelectedAssignment());

        btnRefresh = new JButton("Refresh");
        btnRefresh.addActionListener(e -> populateCourseworkTable());
        
        btnBack = new JButton("Back");
        btnBack.addActionListener(e -> goBack());

        buttonPanel.add(btnSubmit);
        buttonPanel.add(btnRefresh);
        buttonPanel.add(btnBack);

        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initializeSampleCoursework() {
        courseworkList.add(new CourseworkAssignment("INFO 5100", "Student Use Case Design", "06/24/2026"));
        courseworkList.add(new CourseworkAssignment("INFO 5100", "Course Registration Workflow", "06/25/2026"));
        courseworkList.add(new CourseworkAssignment("INFO 5100", "Graduation Audit Draft", "06/26/2026"));
    }

    private void populateCourseworkTable() {
        DefaultTableModel model = (DefaultTableModel) tblCoursework.getModel();
        model.setRowCount(0);

        for (CourseworkAssignment assignment : courseworkList) {
            Object[] row = new Object[5];
            row[0] = assignment.getCourseName();
            row[1] = assignment.getAssignmentName();
            row[2] = assignment.getDueDate();
            row[3] = assignment.getStatus();

            if (assignment.getGrade() == 0.0) {
                row[4] = "Not Graded";
            } else {
                row[4] = assignment.getGrade();
            }

            model.addRow(row);
        }
    }

    private void submitSelectedAssignment() {
        int selectedRow = tblCoursework.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an assignment to submit.");
            return;
        }

        String submissionText = txtSubmission.getText();

        if (submissionText == null || submissionText.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Submission text cannot be empty.");
            return;
        }

        CourseworkAssignment selectedAssignment = courseworkList.get(selectedRow);

        try {
            selectedAssignment.submitAssignment(submissionText);
            populateCourseworkTable();
            txtSubmission.setText("");
            JOptionPane.showMessageDialog(this, "Assignment submitted successfully.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    private void goBack() {
        java.awt.Container parent = getParent();
        
        if(parent != null && parent.getLayout() instanceof java.awt.CardLayout){
            ((java.awt.CardLayout) parent.getLayout()).show(parent, "student");
            parent.revalidate();
            parent.repaint();
        }
    }
}
