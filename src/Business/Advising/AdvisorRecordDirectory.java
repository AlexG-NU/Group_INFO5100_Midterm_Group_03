/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Advising;

import Business.UserAccounts.UserAccount;
import java.util.ArrayList;


/**
 *
 * @author janet
 */

public class AdvisorRecordDirectory {

    private ArrayList<AdvisorRecord> advisorRecords;

    public AdvisorRecordDirectory() {
        advisorRecords = new ArrayList<AdvisorRecord>();
    }

    public ArrayList<AdvisorRecord> getAdvisorRecords() {
        return advisorRecords;
    }

    public AdvisorRecord getOrCreateRecord(UserAccount studentAccount) {
        AdvisorRecord existing = findRecordByStudentAccount(studentAccount);
        if (existing != null) {
            return existing;
        }
        AdvisorRecord record = new AdvisorRecord(studentAccount);
        advisorRecords.add(record);
        return record;
    }

    public AdvisorRecord findRecordByStudentAccount(UserAccount studentAccount) {
        for (AdvisorRecord record : advisorRecords) {
            if (record.getStudentAccount() == studentAccount) {
                return record;
            }
        }
        return null;
    }

    public AdvisorRecord findRecordByStudentNuid(String nuid) {
        for (AdvisorRecord record : advisorRecords) {
            if (record.getStudentNuid().equals(nuid)) {
                return record;
            }
        }
        return null;
    }

    public AdvisorRecord findRecordByStudentId(String studentId) {
        for (AdvisorRecord record : advisorRecords) {
            if (record.getStudentId().equals(studentId)) {
                return record;
            }
        }
        return null;
    }
}
