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
* `CourseCatalog.StudentGrade`: Used as the shared source for student grades, course numbers, and transcript records.
* `CourseCatalog.CourseCatalog` and `CourseCatalog.Course`: Used to retrieve course names and credit values from course numbers.
* `Business.Advising.AdvisorAcademicData`: Used to calculate GPA, completed credits, graduation status, and shared academic standing information from grade/course data.
* `Business.Advising.AdvisorRecord`: Used for advisor-specific planning information, including credits required, expected graduation date, advisor notes, course recommendations, and last meeting date.
* `Coursework.CourseworkAssignment`: Used for coursework assignment tracking and submission status.
* `StudentRegistrationJPanel`: Uses local course registration data to demonstrate course enrollment, duplicate registration validation, and course dropping.

### Student Login

Username: `adam`
Password: `****`

### Student Testing Plan

* Verified that a Student login opens the Student work area.
* Verified that the Course Work button opens the coursework panel.
* Verified that coursework submission validates empty input and updates assignment status.
* Verified that the Registration button opens the registration panel.
* Verified that students can enroll in and drop courses.
* Verified that duplicate course registration is prevented.
* Verified that the Transcript button opens the transcript panel.
* Verified that the transcript displays completed courses, grades, credits earned, and GPA from shared `StudentGrade` and `CourseCatalog` data.
* Verified that the Graduation Audit button opens the graduation audit panel.
* Verified that graduation audit displays credits completed, credits required, remaining credits, GPA, expected graduation date, and graduation status.
* Verified that GPA and completed credits are calculated through `AdvisorAcademicData` instead of hardcoded transcript data.
* Verified that each Back button returns to the Student work area.
* Verified that Advisor role screens still display student academic information after the Student Transcript and Graduation Audit data-source updates.
