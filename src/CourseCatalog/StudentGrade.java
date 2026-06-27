/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CourseCatalog;

/**
 *
 * @author abhit
 */
public class StudentGrade {
    
   private String studentName;
    private String nuid;
    private String courseNumber;
    private String grade;

    public StudentGrade(String studentName, String nuid, String courseNumber, String grade) {
        this.studentName = studentName;
        this.nuid = nuid;
        this.courseNumber = courseNumber;
        this.grade = grade;
    }

    public String getStudentName() { return studentName; }
    public String getNuid() { return nuid; }
    public String getCourseNumber() { return courseNumber; }
    public String getGrade() { return grade; }
}
    

