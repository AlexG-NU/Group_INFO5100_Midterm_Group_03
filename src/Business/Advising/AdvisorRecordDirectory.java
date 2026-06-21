package Business.Advising;

import Business.UserAccounts.UserAccount;
import java.util.ArrayList;

public class AdvisorRecordDirectory {

    private ArrayList<AdvisorRecord> advisorRecords;

    public AdvisorRecordDirectory() {
        advisorRecords = new ArrayList<AdvisorRecord>();
    }

    public ArrayList<AdvisorRecord> getAdvisorRecords() {
        return advisorRecords;
    }

    public AdvisorRecord getOrCreateRecord(UserAccount studentAccount) {
        AdvisorRecord existing = findRecordByStudentId(studentAccount.getAssociatedPersonProfile().getPerson().getPersonId());
        if (existing != null) {
            return existing;
        }
        AdvisorRecord record = new AdvisorRecord(studentAccount);
        advisorRecords.add(record);
        return record;
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
