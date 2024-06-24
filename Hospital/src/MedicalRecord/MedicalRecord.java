package MedicalRecord;

import java.time.LocalDate;

public abstract class MedicalRecord {
    protected static int recordCount = 0;
    protected int recordNumber;
    protected String recordCode;
    protected String patientCode;
    protected String patientName;
    protected LocalDate admissionDate;
    protected LocalDate dischargeDate;
    protected String reasonForAdmission;

    public MedicalRecord(String recordCode, String patientCode, String patientName, LocalDate admissionDate, LocalDate dischargeDate, String reasonForAdmission) {
        this.recordNumber = ++recordCount;
        this.recordCode = recordCode;
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.reasonForAdmission = reasonForAdmission;
    }

    public abstract String toCSVString();

    public int getRecordNumber() {
        return recordNumber;
    }

    public String getRecordCode() {
        return recordCode;
    }

    public static int getRecordCount() {
        return recordCount;
    }

    public static void setRecordCount(int recordCount) {
        MedicalRecord.recordCount = recordCount;
    }

    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getReasonForAdmission() {
        return reasonForAdmission;
    }

    public void setReasonForAdmission(String reasonForAdmission) {
        this.reasonForAdmission = reasonForAdmission;
    }
}
