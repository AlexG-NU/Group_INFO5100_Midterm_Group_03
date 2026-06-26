/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Business;
import Business.Person.Person;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class AcademicAdvisorDirectory {

    Business business;
    ArrayList<AcademicAdvisorProfile> academicadvisorlist;

    public AcademicAdvisorDirectory(Business d) {

        business = d;
        academicadvisorlist = new ArrayList();

    }

    public AcademicAdvisorProfile newAcademicAdvisorProfile(Person p) {

        AcademicAdvisorProfile ap = new AcademicAdvisorProfile(p);
        academicadvisorlist.add(ap);
        return ap;
    }

    public AcademicAdvisorProfile findAcademicAdvisor(String id) {

        for (AcademicAdvisorProfile ap : academicadvisorlist) {

            if (ap.isMatch(id)) {
                return ap;
            }
        }
            return null; //not found after going through the whole list
         }
    public ArrayList<AcademicAdvisorProfile> getAcademicAdvisorList() {
        return academicadvisorlist;
    }
    
    public void removeAcademicAdvisorProfile(AcademicAdvisorProfile ap) {
        academicadvisorlist.remove(ap);
    }
    
    
}
