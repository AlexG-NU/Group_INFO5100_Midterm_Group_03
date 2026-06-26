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
public class FacultyProfile extends Profile {

//    Transcript transcript;
    //   EmploymentHistroy employmenthistory;

    public FacultyProfile(Person p) {
        super(p);

//        transcript = new Transcript(this);
//        employmenthistory = new EmploymentHistroy();
    }

    @Override
    public String getRole() {
        return "Faculty";
    }

    @Override
    public boolean isMatch(String id) {
        return getPerson().getPersonId().equals(id);
    }

}
