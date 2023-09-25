package service;

import dao.AppointmentDao;
import dao.DoctorDao;
import dao.PatientDao;
import doamin.Appointment;
import doamin.Doctor;
import doamin.Patient;
import doamin.Slot;

import java.util.List;
import java.util.Map;

public class AppointmentService {

    private AppointmentDao appointmentDao = null;
    public AppointmentService() {
        appointmentDao = AppointmentDao.getAppointmentDao();
    }

    public void bookAppointment(int doctorId,int patientId, Slot slot) throws Exception {

        // Verify if Patient has any other appointment in same Slot

        Doctor doctor = DoctorDao.getDoctorDao().getDoctorById(doctorId);
        Patient patient = PatientDao.getPatientDao().getPatientById(patientId);

        List<Appointment> patientAppointment=getPatientAppointment(patient.getId());

        for(Appointment appointment : patientAppointment){
            if(appointment.getSlot().equals(slot)){
                throw new RuntimeException("patient has booked another appointment in same slot");
            }
        }

        // Check the Doctors Availability for the slot
        List<Slot> slots = doctor.getSlots();

        // book the appointment
        for(Slot doctorSlot: slots){
            if(doctorSlot.equals(slot)){
                Appointment appointment = new Appointment(doctor,patient,slot,"NEW");
                slots.remove(doctorSlot);
                appointmentDao.bookAppointment(doctor,patient,appointment);
                System.out.println("Setting up appointment");
                return;
            }
        }
        throw new RuntimeException("Doctor is not available for this slot");
    }

    public List<Appointment> getPatientAppointment(int patientId){
        Patient patient = PatientDao.getPatientDao().getPatientById(patientId);
        return appointmentDao.getPatientAppointment(patient);

    }

    public List<Appointment> getDoctorBookedAppointment(int doctorId){
        Doctor doctor = DoctorDao.getDoctorDao().getDoctorById(doctorId);
        return appointmentDao.getDoctorAppointment(doctor);
    }
    public void cancelAppointment(Appointment appointment){
        appointmentDao.cancelAppointment(appointment);
        return;
    }
}
