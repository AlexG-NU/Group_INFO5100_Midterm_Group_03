/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Person.Person;


/**
 *
 * @author kal bugrara
 */
public class StudentProfile extends Profile {
//    Transcript transcript;
    //   EmploymentHistroy employmenthistory;
private String hobbies;
private String interests;
    public StudentProfile(Person p) {
        super(p);

//        transcript = new Transcript(this);
//        employmenthistory = new EmploymentHistroy();
    }

    @Override
    public String getRole() {
        return "Student";
    }
    public String getHobbies() {
    return hobbies;
}

public void setHobbies(String hobbies) {
    this.hobbies = hobbies;
}

public String getInterests() {
    return interests;
}

public void setInterests(String interests) {
    this.interests = interests;
}

    public boolean isMatch(String id) {
        return getPerson().getPersonId().equals(id);
    }

}
