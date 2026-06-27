/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Advising.AdvisorRecordDirectory;
import Business.Person.PersonDirectory;
import Business.Profiles.AcademicAdvisorDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.FacultyDirectory;
import Business.Profiles.StudentDirectory;
import Department.Department;
import CourseCatalog.StudentGrade;
import java.util.ArrayList;

import Business.UserAccounts.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
public class Business {

    String name;
    PersonDirectory persondirectory; //all people profiles regardless of the role

    EmployeeDirectory employeedirectory;
    UserAccountDirectory useraccountdirectory;
    StudentDirectory studentdirectory;
    AdvisorRecordDirectory advisorrecorddirectory;
    FacultyDirectory facultydirectory;
    AcademicAdvisorDirectory academicadvisordirectory;
    Department department;
    ArrayList<StudentGrade> gradeList;

    


    public Business(String n) {
        name = n;

        persondirectory = new PersonDirectory();
        employeedirectory = new EmployeeDirectory(this);
        useraccountdirectory = new UserAccountDirectory();
        studentdirectory = new StudentDirectory();
        advisorrecorddirectory = new AdvisorRecordDirectory();
        facultydirectory = new FacultyDirectory();
        academicadvisordirectory = new AcademicAdvisorDirectory(this);
        department = new Department ("MSIS");
        gradeList = new ArrayList<>();


    }

    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return useraccountdirectory;
    }


    public EmployeeDirectory getEmployeeDirectory() {
        return employeedirectory;
    }

    public StudentDirectory getStudentDirectory(){
        return studentdirectory;
    }

    public AdvisorRecordDirectory getAdvisorRecordDirectory() {
        return advisorrecorddirectory;
    }
    

    public FacultyDirectory getFacultyDirectory() {
        return facultydirectory;
    }
    
    public AcademicAdvisorDirectory getAcademicAdvisorDirectory() {
        return academicadvisordirectory;
    }
    public Department getDepartment(){
        return department;

    }
    public ArrayList<StudentGrade> getGradeList() {
    return gradeList;
}

}
