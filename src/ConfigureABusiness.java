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
import Business.Profiles.AcademicAdvisorDirectory;
import Business.Profiles.FacultyDirectory;
import Business.Profiles.FacultyProfile;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import CourseCatalog.StudentGrade;

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
        Person person001 = persondirectory.newPerson("900002007");
        person001.setFirstName("John");
        person001.setLastName("Smith");
        
        Person person002 = persondirectory.newPerson("900002008");
        person002.setFirstName("Gina");
        person002.setLastName("Montana");
        
        Person person003 = persondirectory.newPerson("900002001");
        person003.setFirstName("Adam");
        person003.setLastName("Rollen");
        person003.setEmail("adam.rollen@northeastern.edu");
        person003.setPhone("555-3001");
        //person003.setNuid("900002001");
        person003.setDepartment("Information Systems");
        person003.setTitle("Student");
        
        
        // Person 4 added by Janet 
        Person person004 = persondirectory.newPerson("100001002");
        person004.setFirstName("Janet");
        person004.setLastName("Chong");
        person004.setEmail("janet.chong@northeastern.edu");
        person004.setPhone("123-4567");
        //person004.setNuid("100001002");
        person004.setDepartment("Advisement");
        person004.setTitle("Academic Advisor");

 
        Person person005 = persondirectory.newPerson("100003333");
        person005.setFirstName("Jim");
        person005.setLastName("Dellon");
        person005.setEmail("jim.dellon@northeastern.edu");
        person005.setPhone("100-1010");
        //person005.setNuid("100003333");
        person005.setDepartment("Information Systems");
        person005.setTitle("Faculty");
        Person person006 = persondirectory.newPerson("900002003");
        person006.setFirstName("Anna");
        person006.setLastName("Shnider");
        Person person007 = persondirectory.newPerson("900002004");
        person007.setFirstName("Laura");
        person007.setLastName("Brown");
        Person person008 = persondirectory.newPerson("900002005");
        person008.setFirstName("Jack");
        person008.setLastName("White");
        
        Person person009 = persondirectory.newPerson("900002006"); //we use this as customer


        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);
        
        StudentDirectory studentdirectory = business.getStudentDirectory();
        StudentProfile studentprofile0 = studentdirectory.newStudentProfile(person003);
        
        // 4 added by Janet 
        AcademicAdvisorDirectory academicadvisordirectory = business.getAcademicAdvisorDirectory();
        AcademicAdvisorProfile advisorprofile0 = academicadvisordirectory.newAcademicAdvisorProfile(person004);
        

        


   
// Create User accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "admin", "****"); 
        UserAccount ua4 = uadirectory.newUserAccount(studentprofile0, "adam", "****"); 
        UserAccount ua5 = uadirectory.newUserAccount(advisorprofile0, "advisor", "****"); //  4 added by Janet 
        //UserAccount ua6 = uadirectory.newUserAccount(facultyprofile0, "jim", "****");
        
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
        Person person010 = persondirectory.newPerson("21000032");
        person010.setFirstName("Maria");
        person010.setLastName("Garcia");
        person010.setEmail("maria.garcia@northeastern.edu");
        person010.setPhone("978-333-2222");
        //person010.setNuid("21000032");
        person010.setDepartment("Information Systems");
        person010.setTitle("Faculty");
        
        FacultyDirectory facultydirectory = business.getFacultyDirectory();
        FacultyProfile facultyprofile0 = facultydirectory.newFacultyProfile(person010);
        
        UserAccount ua6 = uadirectory.newUserAccount(facultyprofile0,"maria", "****");
        
        // Student grades by Abhi
business.getGradeList().add(new StudentGrade("Adam Rollen", "900002001", "INFO5100", "A"));
business.getGradeList().add(new StudentGrade("Jack White", "900002005", "INFO5100", "B+"));
business.getGradeList().add(new StudentGrade("Anna Shnider", "900002003", "INFO5100", "A-"));
business.getGradeList().add(new StudentGrade("Laura Brown", "900002004", "INFO5200", "B"));
business.getGradeList().add(new StudentGrade("Jack White", "900002005", "INFO5200", "A"));
        
// Additional students + advisor records by Abhi (for Manage Student Profiles)
StudentProfile sp1 = studentdirectory.newStudentProfile(person006); // Anna Shnider
person006.setFirstName("Anna"); person006.setLastName("Shnider");
person006.setEmail("anna.shnider@northeastern.edu"); //person006.setNuid("900002003");
person006.setDepartment("Information Systems"); person006.setTitle("Student");
UserAccount uaAnna = uadirectory.newUserAccount(sp1, "anna", "****");
AdvisorRecord annaRec = business.getAdvisorRecordDirectory().getOrCreateRecord(uaAnna);
annaRec.setCreditsCompleted(60); annaRec.setCreditsRequired(120); annaRec.setGpa(3.80);
annaRec.setAcademicStanding("On Track"); annaRec.setPotentialGraduationDate("Dec 2027");

StudentProfile sp2 = studentdirectory.newStudentProfile(person007); // Laura Brown
person007.setFirstName("Laura"); person007.setLastName("Brown");
person007.setEmail("laura.brown@northeastern.edu"); //person007.setNuid("900002004");
person007.setDepartment("Information Systems"); person007.setTitle("Student");
UserAccount uaLaura = uadirectory.newUserAccount(sp2, "laura", "****");
AdvisorRecord lauraRec = business.getAdvisorRecordDirectory().getOrCreateRecord(uaLaura);
lauraRec.setCreditsCompleted(30); lauraRec.setCreditsRequired(120); lauraRec.setGpa(3.20);
lauraRec.setAcademicStanding("Needs Review"); lauraRec.setPotentialGraduationDate("May 2028"); 

StudentProfile sp3 = studentdirectory.newStudentProfile(person008); // Jack White
sp3.setHobbies("Soccer, gaming, cooking");
sp3.setInterests("Database systems, cloud computing, cybersecurity");

person008.setEmail("jack.white@northeastern.edu");
person008.setDepartment("Information Systems");
person008.setTitle("Student");

UserAccount uaJack = uadirectory.newUserAccount(sp3, "jack", "****");
AdvisorRecord jackRec = business.getAdvisorRecordDirectory().getOrCreateRecord(uaJack);
jackRec.setCreditsCompleted(45);
jackRec.setCreditsRequired(120);
jackRec.setGpa(3.55);
jackRec.setAcademicStanding("On Track");
jackRec.setPotentialGraduationDate("May 2028");

studentprofile0.setHobbies("Basketball, coding, photography");
studentprofile0.setInterests("Software engineering, healthcare technology, databases");

sp1.setHobbies("Painting, tennis, reading");
sp1.setInterests("UX design, data analytics, application development");

sp2.setHobbies("Volunteering, music, hiking");
sp2.setInterests("Project management, information systems, business analysis");

        return business;

    }

}
