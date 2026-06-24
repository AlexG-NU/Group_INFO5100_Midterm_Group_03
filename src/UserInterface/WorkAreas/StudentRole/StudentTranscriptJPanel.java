/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package UserInterface.WorkAreas.StudentRole;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * StudentTranscriptJPanel allows student users to review completed courses,
 * grades, credits earned, and GPA.
 *
 * Author: Connor Ewart
 */
public class StudentTranscriptJPanel extends JPanel {

    private ArrayList<TranscriptCourse> completedCourses;
    private JTable tblTranscript;
    private JLabel lblGpa;
    private JLabel lblCreditsCompleted;
    private JButton btnRefresh;
    private JButton btnBack;

    public StudentTranscriptJPanel() {
        completedCourses = new ArrayList<>();
        initializeCompletedCourses();
        initComponents();
        populateTranscriptTable();
        updateSummaryLabels();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Review Transcript");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        tblTranscript = new JTable();
        tblTranscript.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Course Number", "Course Name", "Term", "Credits", "Grade"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        add(new JScrollPane(tblTranscript), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel summaryPanel = new JPanel(new GridLayout(1, 2));
        lblCreditsCompleted = new JLabel("Credits Completed: ");
        lblGpa = new JLabel("GPA: ");
        summaryPanel.add(lblCreditsCompleted);
        summaryPanel.add(lblGpa);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        btnRefresh = new JButton("Refresh");
        btnRefresh.addActionListener(e -> {
            populateTranscriptTable();
            updateSummaryLabels();
        });

        btnBack = new JButton("Back");
        btnBack.addActionListener(e -> goBack());

        buttonPanel.add(btnRefresh);
        buttonPanel.add(btnBack);

        bottomPanel.add(summaryPanel, BorderLayout.NORTH);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initializeCompletedCourses() {
        completedCourses.add(new TranscriptCourse("INFO 5100", "Application Engineering and Development", "Spring 2026", 4, "A"));
        completedCourses.add(new TranscriptCourse("INFO 6150", "Web Design and User Experience Engineering", "Spring 2026", 4, "B+"));
        completedCourses.add(new TranscriptCourse("DAMG 6210", "Data Management and Database Design", "Summer 2026", 4, "A-"));
        completedCourses.add(new TranscriptCourse("INFO 6205", "Program Structure and Algorithms", "Summer 2026", 4, "B"));
    }

    private void populateTranscriptTable() {
        DefaultTableModel model = (DefaultTableModel) tblTranscript.getModel();
        model.setRowCount(0);

        for (TranscriptCourse course : completedCourses) {
            Object[] row = new Object[5];
            row[0] = course.getCourseNumber();
            row[1] = course.getCourseName();
            row[2] = course.getTerm();
            row[3] = course.getCredits();
            row[4] = course.getGrade();
            model.addRow(row);
        }
    }

    private void updateSummaryLabels() {
        lblCreditsCompleted.setText("Credits Completed: " + calculateCreditsCompleted());
        lblGpa.setText("GPA: " + String.format("%.2f", calculateGpa()));
    }

    private int calculateCreditsCompleted() {
        int totalCredits = 0;

        for (TranscriptCourse course : completedCourses) {
            totalCredits += course.getCredits();
        }

        return totalCredits;
    }

    private double calculateGpa() {
        if (completedCourses.isEmpty()) {
            return 0.0;
        }

        double totalQualityPoints = 0.0;
        int totalCredits = 0;

        for (TranscriptCourse course : completedCourses) {
            totalQualityPoints += convertGradeToPoints(course.getGrade()) * course.getCredits();
            totalCredits += course.getCredits();
        }

        if (totalCredits == 0) {
            return 0.0;
        }

        return totalQualityPoints / totalCredits;
    }

    private double convertGradeToPoints(String grade) {
        if (grade == null) {
            return 0.0;
        }

        switch (grade) {
            case "A":
                return 4.0;
            case "A-":
                return 3.7;
            case "B+":
                return 3.3;
            case "B":
                return 3.0;
            case "B-":
                return 2.7;
            case "C+":
                return 2.3;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            case "F":
                return 0.0;
            default:
                return 0.0;
        }
    }

    private void goBack() {
        java.awt.Container parent = getParent();

        if (parent != null && parent.getLayout() instanceof java.awt.CardLayout) {
            ((java.awt.CardLayout) parent.getLayout()).show(parent, "student");
            parent.revalidate();
            parent.repaint();
        }
    }

    private static class TranscriptCourse {

        private String courseNumber;
        private String courseName;
        private String term;
        private int credits;
        private String grade;

        public TranscriptCourse(String courseNumber, String courseName, String term, int credits, String grade) {
            this.courseNumber = courseNumber;
            this.courseName = courseName;
            this.term = term;
            this.credits = credits;
            this.grade = grade;
        }

        public String getCourseNumber() {
            return courseNumber;
        }

        public String getCourseName() {
            return courseName;
        }

        public String getTerm() {
            return term;
        }

        public int getCredits() {
            return credits;
        }

        public String getGrade() {
            return grade;
        }
    }
}