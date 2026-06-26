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
public class EmployeeDirectory {

    Business business;
    ArrayList<EmployeeProfile> employeelist;

    public EmployeeDirectory(Business d) {

        business = d;
        employeelist = new ArrayList();

    }

    public EmployeeProfile newEmployeeProfile(Person p) {

        EmployeeProfile ep = new EmployeeProfile(p);
        employeelist.add(ep);
        return ep;
    }

    public EmployeeProfile findEmployee(String id) {

        for (EmployeeProfile ep : employeelist) {

            if (ep.isMatch(id)) {
                return ep;
            }
        }
            return null; //not found after going through the whole list
         }
    
    public ArrayList<EmployeeProfile> getEmployeeList() {
        return employeelist;
    }
    
    public void removeEmployeeProfile(EmployeeProfile ep) {
        employeelist.remove(ep);
    }
    
}
