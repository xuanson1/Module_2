package MedicalRecord;

import java.time.LocalDate;

public class RegularMedicalRecord extends MedicalRecord {
    private double hospitalFee;

    public RegularMedicalRecord(String recordCode, String patientCode, String patientName, LocalDate admissionDate, LocalDate dischargeDate, String reasonForAdmission, double hospitalFee) {
        super(recordCode, patientCode, patientName, admissionDate, dischargeDate, reasonForAdmission);
        this.hospitalFee = hospitalFee;
    }

    @Override
    public String toCSVString() {
        return String.format("%d,%s,%s,%s,%s,%s,%s", recordNumber, recordCode, patientCode, patientName, admissionDate.toString(), dischargeDate.toString(), hospitalFee);
    }

    public double getHospitalFee() {
        return hospitalFee;
    }

    public void setHospitalFee(long hospitalFee) {
        this.hospitalFee = hospitalFee;
    }
}
