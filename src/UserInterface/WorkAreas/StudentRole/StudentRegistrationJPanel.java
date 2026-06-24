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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * StudentRegistrationJPanel allows student users to view available courses,
 * register for courses, drop registered courses, and view current registration.
 *
 * Author: Connor Ewart
 */
public class StudentRegistrationJPanel extends JPanel {

    private ArrayList<RegistrationCourse> availableCourses;
    private ArrayList<RegistrationCourse> registeredCourses;

    private JTable tblAvailableCourses;
    private JTable tblRegisteredCourses;

    private JButton btnRegister;
    private JButton btnDrop;
    private JButton btnRefresh;
    private JButton btnBack;

    public StudentRegistrationJPanel() {
        availableCourses = new ArrayList<>();
        registeredCourses = new ArrayList<>();

        initializeAvailableCourses();
        initComponents();
        populateAvailableCoursesTable();
        populateRegisteredCoursesTable();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Course Registration");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        JPanel tablePanel = new JPanel(new GridLayout(2, 1));

        tblAvailableCourses = new JTable();
        tblAvailableCourses.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Course Number", "Course Name", "Credits"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        JPanel availablePanel = new JPanel(new BorderLayout());
        availablePanel.add(new JLabel("Available Courses"), BorderLayout.NORTH);
        availablePanel.add(new JScrollPane(tblAvailableCourses), BorderLayout.CENTER);

        tblRegisteredCourses = new JTable();
        tblRegisteredCourses.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Course Number", "Course Name", "Credits"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        JPanel registeredPanel = new JPanel(new BorderLayout());
        registeredPanel.add(new JLabel("Registered Courses"), BorderLayout.NORTH);
        registeredPanel.add(new JScrollPane(tblRegisteredCourses), BorderLayout.CENTER);

        tablePanel.add(availablePanel);
        tablePanel.add(registeredPanel);

        add(tablePanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));

        btnRegister = new JButton("Register");
        btnRegister.addActionListener(e -> registerSelectedCourse());

        btnDrop = new JButton("Drop");
        btnDrop.addActionListener(e -> dropSelectedCourse());

        btnRefresh = new JButton("Refresh");
        btnRefresh.addActionListener(e -> refreshTables());

        btnBack = new JButton("Back");
        btnBack.addActionListener(e -> goBack());

        buttonPanel.add(btnRegister);
        buttonPanel.add(btnDrop);
        buttonPanel.add(btnRefresh);
        buttonPanel.add(btnBack);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void initializeAvailableCourses() {
        availableCourses.add(new RegistrationCourse("INFO 5100", "Application Engineering and Development", 4));
        availableCourses.add(new RegistrationCourse("INFO 6150", "Web Design and User Experience Engineering", 4));
        availableCourses.add(new RegistrationCourse("DAMG 6210", "Data Management and Database Design", 4));
        availableCourses.add(new RegistrationCourse("INFO 6205", "Program Structure and Algorithms", 4));
    }

    private void populateAvailableCoursesTable() {
        DefaultTableModel model = (DefaultTableModel) tblAvailableCourses.getModel();
        model.setRowCount(0);

        for (RegistrationCourse course : availableCourses) {
            Object[] row = new Object[3];
            row[0] = course.getCourseNumber();
            row[1] = course.getCourseName();
            row[2] = course.getCredits();
            model.addRow(row);
        }
    }

    private void populateRegisteredCoursesTable() {
        DefaultTableModel model = (DefaultTableModel) tblRegisteredCourses.getModel();
        model.setRowCount(0);

        for (RegistrationCourse course : registeredCourses) {
            Object[] row = new Object[3];
            row[0] = course.getCourseNumber();
            row[1] = course.getCourseName();
            row[2] = course.getCredits();
            model.addRow(row);
        }
    }

    private void registerSelectedCourse() {
        int selectedRow = tblAvailableCourses.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a course to register.");
            return;
        }

        RegistrationCourse selectedCourse = availableCourses.get(selectedRow);

        if (isAlreadyRegistered(selectedCourse)) {
            JOptionPane.showMessageDialog(this, "You are already registered for this course.");
            return;
        }

        registeredCourses.add(selectedCourse);
        populateRegisteredCoursesTable();
        JOptionPane.showMessageDialog(this, "Course registered successfully.");
    }

    private void dropSelectedCourse() {
        int selectedRow = tblRegisteredCourses.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a registered course to drop.");
            return;
        }

        registeredCourses.remove(selectedRow);
        populateRegisteredCoursesTable();
        JOptionPane.showMessageDialog(this, "Course dropped successfully.");
    }

    private boolean isAlreadyRegistered(RegistrationCourse selectedCourse) {
        for (RegistrationCourse course : registeredCourses) {
            if (course.getCourseNumber().equals(selectedCourse.getCourseNumber())) {
                return true;
            }
        }
        return false;
    }

    private void refreshTables() {
        populateAvailableCoursesTable();
        populateRegisteredCoursesTable();
    }

    private void goBack() {
        java.awt.Container parent = getParent();

        if (parent != null && parent.getLayout() instanceof java.awt.CardLayout) {
            ((java.awt.CardLayout) parent.getLayout()).show(parent, "student");
            parent.revalidate();
            parent.repaint();
        }
    }

    private static class RegistrationCourse {

        private String courseNumber;
        private String courseName;
        private int credits;

        public RegistrationCourse(String courseNumber, String courseName, int credits) {
            this.courseNumber = courseNumber;
            this.courseName = courseName;
            this.credits = credits;
        }

        public String getCourseNumber() {
            return courseNumber;
        }

        public String getCourseName() {
            return courseName;
        }

        public int getCredits() {
            return credits;
        }
    }
}

