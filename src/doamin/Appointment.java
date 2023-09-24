package doamin;

public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private Slot slot;
    private String AppointmentStatus;

    public Appointment(Doctor doctor, Patient patient, Slot slot, String appointmentStatus) {
        this.doctor = doctor;
        this.patient = patient;
        this.slot = slot;
        AppointmentStatus = appointmentStatus;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public String getAppointmentStatus() {
        return AppointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        AppointmentStatus = appointmentStatus;
    }


}
