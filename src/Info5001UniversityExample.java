/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import Department.Department;
import Persona.Person;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.StudentProfile;

/**
 *
 * @author kal bugrara
 */
public class Info5001UniversityExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Department department = new Department("Information Systems");
        CourseCatalog coursecatalog = department.getCourseCatalog();
        
        Course course = coursecatalog.newCourse("app eng", "info 5100", 4);
        
        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");

        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        if (courseoffer==null)return;
        courseoffer.generatSeats(10);
        PersonDirectory pd = department.getPersonDirectory();
        Person person = pd.newPerson("0112303");
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student = sd.newStudentProfile(person);
        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
//        
        courseload.newSeatAssignment(courseoffer); //register student in class
        
        int total = department.calculateRevenuesBySemester("Fall2020");
        System.out.print("Total: " + total);

    }

}
