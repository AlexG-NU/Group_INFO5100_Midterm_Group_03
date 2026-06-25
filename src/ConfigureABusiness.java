/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/

//added by janet
import Business.Business;
import Business.Advising.AdvisorRecord;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;
import Business.Profiles.AcademicAdvisorProfile;
//added by Abhi
import Business.Profiles.FacultyProfile;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;


/**
 *
 * @author kal bugrara + editted by janet
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Information Systems");

// Create Persons
      PersonDirectory persondirectory = business.getPersonDirectory();
// person representing sales organization        
        Person person001 = persondirectory.newPerson("John Smith");
        Person person002 = persondirectory.newPerson("Gina Montana");
        
        Person person003 = persondirectory.newPerson("Adam Rollen");
        person003.setFirstName("Adam");
        person003.setLastName("Rollen");
        person003.setEmail("adam.rollen@northeastern.edu");
        person003.setPhone("555-3001");
        person003.setNuid("900002001");
        person003.setDepartment("Information Systems");
        person003.setTitle("Student");
        
        
        // Person 4 added by Janet 
        Person person004 = persondirectory.newPerson("Janet Chong");
        person004.setFirstName("Janet");
        person004.setLastName("Chong");
        person004.setEmail("janet.chong@northeastern.edu");
        person004.setPhone("123-4567");
        person004.setNuid("100001002");
        person004.setDepartment("Advisement");
        person004.setTitle("Academic Advisor");

 
        Person person005 = persondirectory.newPerson("Jim Dellon");
        Person person006 = persondirectory.newPerson("Anna Shnider");
        Person person007 = persondirectory.newPerson("Laura Brown");
        Person person008 = persondirectory.newPerson("Jack While");
        Person person009 = persondirectory.newPerson("Fidelity"); //we use this as customer


        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);
        
        StudentDirectory studentdirectory = business.getStudentDirectory();
        StudentProfile studentprofile0 = studentdirectory.newStudentProfile(person003);
        
        // 4 added by Janet 
        AcademicAdvisorProfile advisorprofile0 = new AcademicAdvisorProfile(person004);
        


   
// Create User accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "admin", "****"); 
        UserAccount ua4 = uadirectory.newUserAccount(studentprofile0, "adam", "****"); 
        UserAccount ua5 = uadirectory.newUserAccount(advisorprofile0, "advisor", "****"); //  4 added by Janet 
       
        AdvisorRecord adamRecord = business.getAdvisorRecordDirectory().getOrCreateRecord(ua4);
        adamRecord.setCreditsCompleted(92);
        adamRecord.setCreditsRequired(120);
        adamRecord.setGpa(3.45);
        adamRecord.setAcademicStanding("On Track");
        adamRecord.setPotentialGraduationDate("May 2027");
        adamRecord.setRecommendedCourses("INFO 5100, INFO 6205, Database Design");
        adamRecord.setAdvisorNotes("Student is progressing well. Review elective planning next meeting.");
        adamRecord.setLastMeetingDate("2026-06-20");
        
        //creating Courses by Abhi
        
        business.getDepartment().getCourseCatalog().newCourse("Application Engineering and Design", "INFO5100", 4);
        business.getDepartment().getCourseCatalog().newCourse("Process Design", "INFO5200", 4);
        business.getDepartment().getCourseCatalog().newCourse("Database Management", "INFO5300", 4);
        
        //creating faculty user
        Person person010 = persondirectory.newPerson("Maria Garcia");
        person010.setFirstName("Maria");
        person010.setLastName("Garcia");
        person010.setEmail("maria.garcia@northeastern.edu");
        person010.setPhone("978-333-2222");
        person010.setNuid("21000032");
        person010.setDepartment("Information Systems");
        person010.setTitle("Faculty");
        
        FacultyProfile facultyprofile0 = new FacultyProfile(person010);
        UserAccount ua6 = uadirectory.newUserAccount(facultyprofile0,"maria", "****");
        
        
        return business;

    }

}
