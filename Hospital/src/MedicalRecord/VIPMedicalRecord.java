package MedicalRecord;


import java.time.LocalDate;

public class VIPMedicalRecord extends MedicalRecord {
    private String vipType;
    private LocalDate vipValidity;

    public VIPMedicalRecord(String recordCode, String patientCode, String patientName, LocalDate admissionDate, LocalDate dischargeDate, String reasonForAdmission, String vipType, LocalDate vipValidity) {
        super(recordCode, patientCode, patientName, admissionDate, dischargeDate, reasonForAdmission);
        this.vipType = vipType;
        this.vipValidity = vipValidity;
    }

    @Override
    public String toCSVString() {
        return String.format("%d,%s,%s,%s,%s,%s,%s,%s", recordNumber, recordCode, patientCode, patientName, admissionDate.toString(), dischargeDate.toString(), vipType, vipValidity.toString());
    }

    public String getVipType() {
        return vipType;
    }

    public void setVipType(String vipType) {
        this.vipType = vipType;
    }

    public LocalDate getVipValidity() {
        return vipValidity;
    }

    public void setVipValidity(LocalDate vipValidity) {
        this.vipValidity = vipValidity;
    }
}
