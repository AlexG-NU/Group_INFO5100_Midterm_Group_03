/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Advising;

import Business.Business;
import Business.UserAccounts.UserAccount;
import CourseCatalog.Course;
import CourseCatalog.StudentGrade;
import java.util.ArrayList;


/**
 *
 * @author janet
 * 
 *
 * I created this for the Academic Advisor role to read student academic information
 * from the same grade/course data used by Faculty and Student screens
 */
public class AdvisorAcademicData {

    public static String getNuid(UserAccount studentAccount) {
        if (studentAccount == null || studentAccount.getAssociatedPersonProfile() == null) {
            return "";
        }
        return studentAccount.getAssociatedPersonProfile().getPerson().getNuid();
    }

    public static String getStudentName(UserAccount studentAccount) {
        if (studentAccount == null || studentAccount.getAssociatedPersonProfile() == null) {
            return "";
        }
        return studentAccount.getAssociatedPersonProfile().getPerson().getFullName();
    }

    public static String getDepartment(UserAccount studentAccount) {
        if (studentAccount == null || studentAccount.getAssociatedPersonProfile() == null) {
            return "";
        }
        return studentAccount.getAssociatedPersonProfile().getPerson().getDepartment();
    }

    public static double calculateGpa(Business business, UserAccount studentAccount) {
        String nuid = getNuid(studentAccount);
        if (business == null || nuid == null || nuid.trim().isEmpty()) {
            return 0.0;
        }

        int count = 0;
        double totalPoints = 0.0;

        for (StudentGrade grade : business.getGradeList()) {
            if (nuid.equals(grade.getNuid())) {
                count++;
                totalPoints += convertGradeToPoints(grade.getGrade());
            }
        }

        if (count == 0) {
            return 0.0;
        }

        return totalPoints / count;
    }

    public static int calculateCreditsCompleted(Business business, UserAccount studentAccount) {
        String nuid = getNuid(studentAccount);
        if (business == null || nuid == null || nuid.trim().isEmpty()) {
            return 0;
        }

        int credits = 0;
        ArrayList<String> countedCourses = new ArrayList<String>();

        for (StudentGrade grade : business.getGradeList()) {
            if (nuid.equals(grade.getNuid()) && !countedCourses.contains(grade.getCourseNumber())) {
                countedCourses.add(grade.getCourseNumber());
                credits += getCreditsForCourse(business, grade.getCourseNumber());
            }
        }

        return credits;
    }

    private static int getCreditsForCourse(Business business, String courseNumber) {
        if (business != null
                && business.getDepartment() != null
                && business.getDepartment().getCourseCatalog() != null
                && business.getDepartment().getCourseCatalog().getCourseByNumber(courseNumber) != null) {
            return business.getDepartment().getCourseCatalog().getCourseByNumber(courseNumber).getCredits();
        }

        return 4;
    }

    public static String getCompletedCourses(Business business, UserAccount studentAccount) {
        String nuid = getNuid(studentAccount);
        if (business == null || nuid == null || nuid.trim().isEmpty()) {
            return "";
        }

        String courses = "";

        for (StudentGrade grade : business.getGradeList()) {
            if (nuid.equals(grade.getNuid())) {
                String courseDisplay = grade.getCourseNumber() + " (" + grade.getGrade() + ")";
                if (courses.trim().isEmpty()) {
                    courses = courseDisplay;
                } else if (!courses.contains(courseDisplay)) {
                    courses = courses + ", " + courseDisplay;
                }
            }
        }

        return courses;
    }

    public static String calculateAcademicStanding(Business business, UserAccount studentAccount, AdvisorRecord record) {
        double gpa = calculateGpa(business, studentAccount);
        int completed = calculateCreditsCompleted(business, studentAccount);
        int required = 120;

        if (record != null) {
            required = record.getCreditsRequired();
        }

        int remaining = Math.max(required - completed, 0);

        if (completed == 0 && gpa == 0.0) {
            return "Needs Review";
        }

        if (gpa < 2.0) {
            return "Academic Review";
        }

        if (remaining <= 15) {
            return "Near Completion";
        }

        return "On Track";
    }

    public static String calculateGraduationStatus(Business business, UserAccount studentAccount, AdvisorRecord record) {
        int completed = calculateCreditsCompleted(business, studentAccount);
        int required = 120;

        if (record != null) {
            required = record.getCreditsRequired();
        }

        int remaining = Math.max(required - completed, 0);

        if (remaining == 0) {
            return "Eligible to Graduate";
        }

        if (remaining <= 15) {
            return "Near Completion";
        }

        return "In Progress";
    }

    public static String calculateReviewPriority(Business business, UserAccount studentAccount, AdvisorRecord record) {
        String standing = calculateAcademicStanding(business, studentAccount, record);

        if (record == null || record.getLastMeetingDate() == null
                || record.getLastMeetingDate().trim().isEmpty()
                || record.getLastMeetingDate().equals("Not recorded")) {
            return "Needs Meeting";
        }

        if (standing.equals("Academic Review") || standing.equals("Needs Review")) {
            return "High Priority";
        }

        return "Routine Follow Up";
    }

    public static void syncAdvisorRecord(Business business, AdvisorRecord record) {
        if (record == null || record.getStudentAccount() == null) {
            return;
        }

        UserAccount studentAccount = record.getStudentAccount();
        record.setCreditsCompleted(calculateCreditsCompleted(business, studentAccount));
        record.setGpa(calculateGpa(business, studentAccount));
        record.setAcademicStanding(calculateAcademicStanding(business, studentAccount, record));
    }

    public static double convertGradeToPoints(String grade) {
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

    public static String formatGpa(double gpa) {
        return String.format("%.2f", gpa);
    }

    public static String courseDisplay(Course course) {
        if (course == null) {
            return "";
        }
        return course.getCOurseNumber() + " - " + course.getName();
    }
}
