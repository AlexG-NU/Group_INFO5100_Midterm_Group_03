/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Advising.AdvisorRecordDirectory;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.AcademicAdvisorDirectory;
import Business.Profiles.AcademicAdvisorProfile;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.FacultyDirectory;
import Business.Profiles.FacultyProfile;
import Business.Profiles.Profile;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;
import Department.Department;

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
    
   public Profile findProfileByPersonId(String id) {
        if (id == null) {
            return null;
        }

        StudentProfile studentProfile = studentdirectory.findStudent(id);
        if (studentProfile != null) {
            return studentProfile;
        }

        FacultyProfile facultyProfile = facultydirectory.findFaculty(id);
        if (facultyProfile != null) {
            return facultyProfile;
        }

        AcademicAdvisorProfile advisorProfile = academicadvisordirectory.findAcademicAdvisor(id);
        if (advisorProfile != null) {
            return advisorProfile;
        }

        EmployeeProfile employeeProfile = employeedirectory.findEmployee(id);
        if (employeeProfile != null) {
            return employeeProfile;
        }

        return null;
    }

}
