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
        AdvisorRecord existing = findRecordByUserAccount(studentAccount);
        if (existing != null) {
            return existing;
        }

        AdvisorRecord record = new AdvisorRecord(studentAccount);
        advisorRecords.add(record);
        return record;
    }

    public AdvisorRecord findRecordByUserAccount(UserAccount studentAccount) {
        if (studentAccount == null) {
            return null;
        }

        String nuid = studentAccount.getAssociatedPersonProfile().getPerson().getNuid();
        AdvisorRecord byNuid = findRecordByStudentNuid(nuid);
        if (byNuid != null) {
            return byNuid;
        }

        return findRecordByStudentId(studentAccount.getAssociatedPersonProfile().getPerson().getPersonId());
    }

    public AdvisorRecord findRecordByStudentId(String studentId) {
        for (AdvisorRecord record : advisorRecords) {
            if (record.getStudentId().equals(studentId)) {
                return record;
            }
        }
        return null;
    }

    public AdvisorRecord findRecordByStudentNuid(String nuid) {
        if (nuid == null) {
            return null;
        }

        for (AdvisorRecord record : advisorRecords) {
            if (record.getStudentNuid().equals(nuid)) {
                return record;
            }
        }
        return null;
    }
}