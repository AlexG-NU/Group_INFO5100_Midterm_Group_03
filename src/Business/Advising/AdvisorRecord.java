package Business.Advising;

import Business.UserAccounts.UserAccount;

public class AdvisorRecord {

    private UserAccount studentAccount;
    private int creditsCompleted;
    private int creditsRequired;
    private double gpa;
    private String academicStanding;
    private String potentialGraduationDate;
    private String recommendedCourses;
    private String advisorNotes;
    private String lastMeetingDate;

    public AdvisorRecord(UserAccount studentAccount) {
        this.studentAccount = studentAccount;
        this.creditsCompleted = 0;
        this.creditsRequired = 120;
        this.gpa = 0.0;
        this.academicStanding = "Needs Review";
        this.potentialGraduationDate = "TBD";
        this.recommendedCourses = "";
        this.advisorNotes = "";
        this.lastMeetingDate = "Not recorded";
    }

    public UserAccount getStudentAccount() {
        return studentAccount;
    }

    public String getStudentId() {
        return studentAccount.getAssociatedPersonProfile().getPerson().getPersonId();
    }

    public String getStudentName() {
        return studentAccount.getAssociatedPersonProfile().getPerson().getFullName();
    }

    public String getDepartment() {
        return studentAccount.getAssociatedPersonProfile().getPerson().getDepartment();
    }

    public int getCreditsCompleted() {
        return creditsCompleted;
    }

    public void setCreditsCompleted(int creditsCompleted) {
        this.creditsCompleted = creditsCompleted;
    }

    public int getCreditsRequired() {
        return creditsRequired;
    }

    public void setCreditsRequired(int creditsRequired) {
        this.creditsRequired = creditsRequired;
    }

    public int getRemainingCredits() {
        return Math.max(creditsRequired - creditsCompleted, 0);
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getAcademicStanding() {
        return academicStanding;
    }

    public void setAcademicStanding(String academicStanding) {
        this.academicStanding = academicStanding;
    }

    public String getPotentialGraduationDate() {
        return potentialGraduationDate;
    }

    public void setPotentialGraduationDate(String potentialGraduationDate) {
        this.potentialGraduationDate = potentialGraduationDate;
    }

    public String getRecommendedCourses() {
        return recommendedCourses;
    }

    public void setRecommendedCourses(String recommendedCourses) {
        this.recommendedCourses = recommendedCourses;
    }

    public String getAdvisorNotes() {
        return advisorNotes;
    }

    public void setAdvisorNotes(String advisorNotes) {
        this.advisorNotes = advisorNotes;
    }

    public String getLastMeetingDate() {
        return lastMeetingDate;
    }

    public void setLastMeetingDate(String lastMeetingDate) {
        this.lastMeetingDate = lastMeetingDate;
    }
}
