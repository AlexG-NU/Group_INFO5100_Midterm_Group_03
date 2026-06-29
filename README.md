# Midterm INFO5100 Group 3 Digital University System

# Team Information
* Alexander Goldblatt- Admin Role NUID: 003185762
* Abhinav Tripathi- Faculty Role  NUID: 003979804
* Connor Ewart - Student Role NUID: 003963690
* Janet Chong​ -  Advisor Role NUID: 003977104

**Responsibilities**
* Member 1 Manage person/profile info for Students, Faculty, Advisors, and Staff Manage user accounts for all users Manage own profile
* Member 2 Manage courses (view, update course details) Manage own profile Generate performance reports (student grades in the class) Manage student profiles (view hobbies, interests, academic progress)
* Member 3 Manage coursework (submit assignments, track progress) Register for classes (enroll, drop courses) Perform graduation audit (track credits and graduation requirements) Review transcript (view academic history)
* Member 4 Provide student advising by reviewing student profile and academic progress (adding advising notes), graduation planning (add graduation audit notes), course recommendations on classes based on courses currently taken.
  
# Project Overview
The purpose of this project is to build a Digital University System and integrate an access control layer that supports authentication and role based access. The system allows users to log in and access features based on their assigned role. The objective is to create a functional university application that supports admin, faculty member, student, and academic advisor users. Each role is designed with its own work area and responsibilities, allowing users to perform tasks relevant to their role while restricting access to features that are outside their scope of work.

**Key features implemented**
* User authentication and role based login
* Separate work areas for each user role (Admin, Faculty Member, Student, and Academic Advisor)
* Role based authorization to restrict access to assigned features for all use cases
* Administrator work area with system management functionality
* Faculty Member work area with course and student management features
* Student work area with course enrollment and academic tracking features
* Academic Advisor work area with student advising functionality

# Installation & Setup Instructions
Prerequisites:
* Java JDK 19 
* Apache NetBeans IDE 16
* Git
* Github account

## Clone the Repository

```bash
git clone https://github.com/AlexG-NU/Group_INFO5100_Midterm_Group_03.git
```

* Setup Instructions

1.	Copy the repository URL from GitHub. 
2.	Open Apache NetBeans IDE 16. 
3.	Select Team → Git → Clone. 
4.	Paste the repository URL. 
5.	Sign in to GitHub if prompted. 
6.	Select the main branch. 
7.	Choose the local destination folder. 
8.	Click Finish. 
9.	When prompted, select Open Project.


# Authentication & Access Control

The application uses an access control layer to authenticate users before granting access to the system.

After a successful login:

* The system validates the username and password
* The user's assigned role is identified
* The corresponding work area is loaded
* Users are restricted to features assigned to their role

## Authorization Rules

### Administrator

* Manage user accounts
* Manage people and profiles
* Manage administrator profile
* Cannot access Faculty, Student, or Advisor work areas

### Faculty Member

* Manage assigned courses
* View student profiles
* Generate performance reports
* Maintain faculty profile
* Cannot manage user accounts

### Student

* Register and drop courses
* Submit coursework
* Review transcript
* Review graduation audit
* Cannot modify university records

### Academic Advisor

* View student records
* Review transcript information
* Monitor academic progress
* Review graduation audit
* Create course recommendations
* Maintain advisor profile
* Cannot modify grades
* Cannot edit transcripts
* Cannot register students for courses
* Cannot manage user accounts
* Cannot access Admin, Student, Faculty work areas

# Features Implemented

## Administrator - Alexander Goldblatt (Member 1)

### Features

* Manage user accounts
* Register students, faculty, and academic staff 
* Manage student records 
* Manage faculty records 
* Maintain administrator profile 

### Responsibilities

* Register students, faculty, advisors, and staff
* Manage all user accounts within the system
* Ensure person records and user accounts remain synchronized
* Maintain administrator information


## Faculty - Abhinav Tripathi (Member 2)

### Features

* Manage assigned courses
* Add and update course information
* View student academic profiles
* Generate student performance reports
* Maintain faculty profile

### Responsibilities

* View and manage assigned courses
* Update course information
* Review student academic progress
* Generate performance reports
* Maintain faculty profile


## Student - Connor Ewart (Member 3)

### Features

* Coursework Management
* Course Registration
* Transcript Review
* Graduation Audit

### Responsibilities

* Submit coursework assignments
* Track assignment progress
* Register for available courses
* Drop registered courses
* Review transcript information
* Monitor graduation progress

---

## Academic Advisor - Janet Chong (Member 4)

### Features

* View Student Records
* Student Details
* Academic Progress
* Degree Audit
* Course Recommendations
* Advisor Profile

### Responsibilities

* Review student personal information
* Monitor academic progress using transcript information
* Review graduation planning
* Create advising notes
* Recommend future courses
* Maintain advisor profile


# Usage Instructions

## Starting the Application

1. Launch the project in Apache NetBeans IDE 16.
2. Build and run the project.
3. Log in using a valid username and password.
4. The system automatically opens the appropriate work area based on the user's assigned role.

## Administrator Example

### Login

* Username: **admin**
* Password: **\*\*\*\***

### Available Functions

* Manage Students
* Manage Faculty
* Manage Advisors
* Manage Staff
* Administer User Accounts
* My Profile

### Example Scenario

1. Login as Administrator.
2. Select **Manage Students**.
3. Add a new student record.
4. Create a user account using the student's NUID.
5. Verify the account appears in the User Account list.

## Faculty Example

### Login

* Username: **maria**
* Password: **\*\*\*\***

### Available Functions

* Manage Courses
* Student Profiles
* Performance Reports
* My Profile

### Example Scenario

1. Login as Faculty.
2. Select **Manage Courses**.
3. Click **Add Course**.
4. Enter the course number, course name, and credits.
5. Verify the course appears in the course table.


## Student Example

### Login

* Username: **adam**
* Password: **\*\*\*\***

### Available Functions

* Coursework
* Registration
* Transcript
* Graduation Audit

### Example Scenario

1. Login as Student.
2. Open **Registration**.
3. Select an available course.
4. Register for the course.
5. Verify the course appears in the registered courses table.
6. Drop the course and verify it is removed.

## Academic Advisor Example

### Login

* Username: **Advisor**
* Password: **\*\*\*\***

### Available Functions

* View Students
* Student Details
* Academic Progress
* Degree Audit
* Course Recommendations
* My Profile

### Example Scenario

1. Login as Academic Advisor.
2. Open **View Students**.
3. Select a student.
4. Review Student Details.
5. Open Academic Progress to review GPA and transcript information.
6. Review Degree Audit information.
7. Enter advising notes and course recommendations.
8. Save the recommendation.

# Testing Guide

The application was tested to verify functionality, authentication, and role-based authorization across all four user roles.

## Authentication Testing

* Verify that valid usernames and passwords successfully log into the system.
* Verify that invalid usernames or passwords are rejected.
* Verify that inactive user accounts cannot log in.
* Verify that users are directed to the correct work area after authentication.

## Authorization Testing

* Confirm that each role can access only its assigned features.
* Verify that users cannot access work areas belonging to other roles.
* Verify that role restrictions are enforced throughout the application.


## Administrator Test Cases

### Test Case 1 – Login

**Steps**

1. Login using Administrator credentials.
2. Verify the Administrator portal opens.

**Expected Result**

* Administrator work area loads successfully.

### Test Case 2 – Manage People

**Steps**

1. Create a new Student, Faculty, Advisor, or Staff profile.
2. Edit the profile.
3. Delete the profile.

**Expected Result**

* Records are successfully created, updated, and removed.
* Profiles with active user accounts cannot be deleted until the account is removed.

### Test Case 3 – User Accounts

**Steps**

1. Create a new user account.
2. Edit an existing account.
3. Deactivate an account.
4. Delete an account.

**Expected Result**

* User accounts update successfully.
* Duplicate usernames are prevented.
* Inactive accounts cannot log in.


## Faculty Test Cases

### Test Case – Manage Courses

**Steps**

1. Login as Faculty.
2. Open **Manage Courses**.
3. Add a new course.
4. Enter the course number, course name, and credits.

**Expected Result**

* Course is successfully added to the course list.
* Tuition price is automatically calculated based on credits.


## Student Test Cases

### Test Case 1 – Student Login

**Steps**

1. Login using Student credentials.

**Expected Result**

* Student portal opens successfully.

### Test Case 2 – Coursework

**Steps**

1. Select Coursework.
2. Submit an assignment.

**Expected Result**

* Assignment status changes to **Submitted**.
* Validation message appears if submission text is empty.

### Test Case 3 – Course Registration

**Steps**

1. Register for a course.
2. Attempt to register again.
3. Drop the course.

**Expected Result**

* Duplicate registration is prevented.
* Dropped courses are removed successfully.

### Test Case 4 – Transcript

**Steps**

1. Open Transcript.

**Expected Result**

* Completed courses
* Grades
* Credits Earned
* GPA

are displayed correctly.

### Test Case 5 – Graduation Audit

**Steps**

1. Open Graduation Audit.

**Expected Result**

* Student information
* Credits Completed
* Credits Required
* Remaining Credits
* GPA
* Expected Graduation Date
* Graduation Status

are displayed correctly.

## Academic Advisor Test Cases

### Test Case 1 – Advisor Login

**Steps**

1. Login as Academic Advisor.

**Expected Result**

* Advisor work area opens successfully.

### Test Case 2 – Student Details

**Steps**

1. Select View Students.
2. Select a student.
3. Open Student Details.

**Expected Result**

* Student information displays correctly.

### Test Case 3 – Academic Progress

**Steps**

1. Select Academic Progress.
2. Select a student.

**Expected Result**

* Transcript information displays correctly, including:
  * Completed Courses
  * Grades
  * Credits Earned
  * GPA

### Test Case 4 – Degree Audit

**Steps**

1. Open Degree Audit.

**Expected Result**

* Credits Completed
* Credits Required
* Remaining Credits
* Graduation Status
* Expected Graduation Date

are displayed correctly.

### Test Case 5 – Course Recommendations

**Steps**

1. Select Course Recommendations.
2. Select a student.
3. Enter advising notes.
4. Save the recommendation.

**Expected Result**

* Recommendation saves successfully.
* Validation messages appear when required fields are missing.


# Challenges & Solutions

## Challenges

* Integrating four independently developed use cases into a single application.
* Coordinating updates to shared classes while minimizing merge conflicts.
* Ensuring data consistency between Student, Faculty, and Academic Advisor features.
* Integrating authentication and role-based authorization without affecting existing functionality.

## Solutions

* Established a shared GitHub workflow using feature branches and pull requests.
* Communicated major code changes before modifying shared classes.
* Performed integration testing after each merge.
* Leveraged shared student data structures so transcript, GPA, and graduation information remained consistent across all user roles.

# Future Enhancements

Potential improvements include:

* Advisor appointment scheduling
* Student-advisor messaging
* Email notifications
* Provide a history of advisor meeting dates for students
* Degree requirement tracking by catalog year
* More courses and students with different majors
* Export Transcript as PDF
* Export Graduation Audit as PDF
* Search and filter student records
* Course prerequisite validation
* Dashboard analytics for administrators and advisors


# Contribution Breakdown

## Alexander Goldblatt (Administrator)
Creating the repository for the team and merging the skeletons into the main branch. Implementing the admin use case, including managing people, profiles, and user accounts for all individuals in the university system. Testing of admin workflows. Merging and uploading of video files.

## Abhinav Tripathi (Faculty)
Implemented faculty use case which included manage courses, myprofile, performance reports, and student profile. Involved in collaboration with team members through microsoft teams. Conducted testing for faculty work area, and contributed to documentation.  

## Connor Ewart (Student)
Implemented the Student use case, including coursework management, course registration, transcript review, and graduation audit. Created Student role panels, connected StudentWorkArea navigation, tested Student workflows, updated Student documentation, and used AI assistance for debugging support, Swing layout guidance, and documentation wording.

## Janet Chong (Academic Advisor)
Implemented the Academic Advisor use case, including the advisor work area and its features for viewing student information, reviewing academic progress, graduation planning, and course recommendations. Integrated the advisor role into the application's login flow, helped with project integration and testing, created the project schedule, contributed to the project documentation, and tested relationships between student, faculty, and advisor data to ensure information was populated and updated correctly throughout the application. Responsible for formatting our readme for our group and Will be submitting final documentation for team. 
