# Midterm INFO5100 Group 3 Digital University System

**Team Information**
Alexander Goldblatt- Admin Role
Abhinav Tripathi- Faculty Role  NUID: 003979804
Connor Ewart - Student Role
Janet Chong​ -  Advisor Role

**Features Implemented**
Faculty Role (Abhinav Tripathi)


## Student Use Case - Connor Ewart

The Student role allows authenticated student users to access academic self-service features in the Digital University System. The Student user can manage coursework, register for classes, perform a graduation audit, and review transcript information.

### Implemented Student Responsibilities

* Manage Coursework: Students can view coursework, submit assignments, and track assignment progress.
* Register for Classes: Students can view available course offerings, enroll in courses, drop registered courses, and prevent duplicate registration.
* Graduation Audit: Students can review credits completed, credits required, remaining credits, GPA, expected graduation date, and graduation status.
* Review Transcript: Students can view completed courses, course grades, credits earned, and calculated GPA.

### Implemented Student Classes and Panels

* `UserInterface.WorkAreas.StudentRole.StudentWorkAreaJPanel`
* `UserInterface.WorkAreas.StudentRole.StudentCourseworkJPanel`
* `UserInterface.WorkAreas.StudentRole.StudentRegistrationJPanel`
* `UserInterface.WorkAreas.StudentRole.StudentTranscriptJPanel`
* `UserInterface.WorkAreas.StudentRole.StudentGraduationAuditJPanel`
* `Coursework.CourseworkAssignment`

### Student Data Sources Used

* `Business.Person.Person`: Used for student name, NUID, email, and department information.
* `Business.Advising.AdvisorRecord`: Used for GPA, credits completed, credits required, remaining credits, academic standing, and expected graduation date.
* `Coursework.CourseworkAssignment`: Used for coursework assignment tracking and submission status.
* `StudentRegistrationJPanel`: Uses local course registration data to demonstrate course enrollment, duplicate registration validation, and course dropping.
* `StudentTranscriptJPanel`: Uses local transcript data to demonstrate completed courses, course grades, credits earned, and GPA calculation.

### Student Login

Username: `adam`
Password: `****`

### Student Testing Plan

* Verify that a Student login opens the Student work area.
* Verify that the Course Work button opens the coursework panel.
* Verify that coursework submission validates empty input and updates assignment status.
* Verify that the Registration button opens the registration panel.
* Verify that students can enroll in and drop courses.
* Verify that duplicate course registration is prevented.
* Verify that the Transcript button opens the transcript panel.
* Verify that the transcript displays completed courses, grades, credits earned, and GPA.
* Verify that the Graduation Audit button opens the graduation audit panel.
* Verify that graduation audit displays credits completed, credits required, remaining credits, GPA, expected graduation date, and graduation status.
* Verify that each Back button returns to the Student work area.
