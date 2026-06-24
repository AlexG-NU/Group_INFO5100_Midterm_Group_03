# Midterm INFO5100 Group 3 Digital University System

## Student Use Case - Connor Ewart

The Student role allows authenticated student users to access academic self-service features in the Digital University System. The Student user can manage coursework, register for classes, perform a graduation audit, and review transcript information.

### Planned Student Responsibilities

- Manage Coursework: View coursework, submit assignments, and track assignment progress.
- Register for Classes: View available course offerings, enroll in courses, and drop registered courses.
- Graduation Audit: Review credits completed, credits required, remaining credits, expected graduation term, and graduation status.
- Review Transcript: View completed courses, course grades, credits earned, and GPA.

### Planned Student Classes and Panels

- StudentWorkAreaJPanel
- StudentCourseworkJPanel
- StudentCourseRegistrationJPanel
- StudentGraduationAuditJPanel
- StudentTranscriptJPanel

### Planned Supporting Classes and Methods

- Transcript: getCompletedCourses(), getCourseGrades(), calculateGPA(), getCreditsCompleted()
- CourseLoad: getRegisteredCourses(), enrollCourse(), dropCourse(), isRegistered()
- GraduationAudit: runAudit(), getCreditsRequired(), getCreditsCompleted(), getRemainingCredits(), getGraduationStatus(), getExpectedGraduationTerm()
- CourseRegistration: registerForCourse(), dropCourse(), isAlreadyRegistered(), hasOpenSeat()

### Student Testing Plan

- Verify that a Student login opens the Student work area.
- Verify that non-Student users cannot access Student-only features.
- Verify that students can enroll in and drop courses.
- Verify that duplicate course registration is prevented.
- Verify that the transcript displays completed courses and grades.
- Verify that graduation audit calculations display credits completed, credits required, remaining credits, and graduation status.
- Verify that coursework submission validates empty input and updates assignment status.