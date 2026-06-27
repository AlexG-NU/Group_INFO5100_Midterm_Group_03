/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccounts;

import Business.Profiles.Profile;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



/**
 *
 * @author kal bugrara
 */
public class UserAccount {
    
    Profile profile;
    String username;
    String password;
    private String status = "Active";
    
    private LocalDateTime lastLoginDate;

    public void setUserLoginName(String username) {
        setLastUpdatedDate(LocalDateTime.now());
        this.username = username;
    }

    public void setPassword(String password) {
        setLastUpdatedDate(LocalDateTime.now());
        this.password = password;
    }
    private LocalDateTime lastUpdatedDate;

    public String getStatus() {
        
        return status;
    }

    public void setStatus(String status) {
        setLastUpdatedDate(LocalDateTime.now());
        this.status = status;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }
    
    public String getLastLoginDateString() {
        if (lastLoginDate==null){
            return "Never";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return lastLoginDate.format(formatter);
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }
    
    public String getLastUpdatedDateString() {
        if (lastUpdatedDate==null){
            return "Never";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return lastUpdatedDate.format(formatter);
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
    
    public UserAccount (Profile profile, String un, String pw){
        username = un;
         password = pw;
         this.profile = profile;
         setLastUpdatedDate(LocalDateTime.now());

    }

    public String getPersonId(){
        return profile.getPerson().getPersonId();
    }
    public String getUserLoginName(){
        return username;
    }
    

        public boolean isMatch(String id){
        if(getPersonId().equals(id)) return true;
        return false;
    }
        public boolean IsValidUser(String un, String pw){
        
            if (username.equalsIgnoreCase(un) && password.equals(pw) && "Active".equals(status)) return true;
            else return false;
        
        }
        public String getRole(){
            return profile.getRole();
        }
        
        public Profile getAssociatedPersonProfile(){
            return profile;
        }
        
    @Override
        public String toString(){
            
            return getUserLoginName();
        }
        
}

