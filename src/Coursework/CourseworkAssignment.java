/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coursework;

/**
 * CourseworkAssignment represents an assignment for the Student use case.
 * Students can view coursework, submit assignments, and track progress.
 * 
 * Author: Connor Ewart
 */
public class CourseworkAssignment {

    private String courseName;
    private String assignmentName;
    private String dueDate;
    private String status;
    private String submissionText;
    private double grade;

    public CourseworkAssignment(String courseName, String assignmentName, String dueDate) {
        this.courseName = courseName;
        this.assignmentName = assignmentName;
        this.dueDate = dueDate;
        this.status = "Not Submitted";
        this.submissionText = "";
        this.grade = 0.0;
    }

    public void submitAssignment(String submissionText) {
        if (submissionText == null || submissionText.trim().isEmpty()) {
            throw new IllegalArgumentException("Submission text cannot be empty.");
        }

        this.submissionText = submissionText;
        this.status = "Submitted";
    }

    public String getCourseName() {
        return courseName;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }

    public String getSubmissionText() {
        return submissionText;
    }

    public double getGrade() {
        return grade;
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("Status cannot be empty.");
        }

        this.status = status;
    }

    public void setGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }

        this.grade = grade;
    }

    @Override
    public String toString() {
        return assignmentName;
    }
}