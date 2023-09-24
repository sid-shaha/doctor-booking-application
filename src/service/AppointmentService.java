package service;

import dao.AppointmentDao;
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

    public void bookAppointment(Doctor doctor, Patient patient, Slot slot) throws Exception {

        // Verify if Patient has any other appointment in same Slot

        List<Appointment> patientAppointment=getPatientAppointment(patient);

        for(Appointment appointment : patientAppointment){
            if(appointment.getSlot().equals(slot)){
                throw new Exception("patient has booked another appointment in same slot");
            }
        }

        // Check the Doctors Availability for the slot
        List<Slot> slots = doctor.getSlots();

        Appointment appointment = new Appointment(doctor,patient,slot,"NEW");
        appointmentDao.bookAppointment(doctor,patient,appointment);
        return;

        // book the appointment
//        for(Slot doctorSlot: slots){
//            if(doctorSlot.equals(slot)){
//                Appointment appointment = new Appointment();
//                appointmentDao.bookAppointment(doctor,patient,appointment);
//                return;
//            }
//        }

    }

    public List<Appointment> getPatientAppointment(Patient patient){
        return appointmentDao.getPatientAppointment(patient);

    }

    public List<Appointment> getDoctorBookedAppointment(Doctor doctor){
        return appointmentDao.getDoctorAppointment(doctor);
    }
    public void cancelAppointment(Appointment appointment){
        appointmentDao.cancelAppointment(appointment);
        return;
    }
}
