package dao;

import doamin.Appointment;
import doamin.Doctor;
import doamin.Patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentDao {

    private static AppointmentDao appointmentDao;


    private Map<Patient,List<Appointment>> patientAppointmentHashMap;
    private Map<Doctor, List<Appointment>> doctorAppointmentHashMap;

    private AppointmentDao(){
        patientAppointmentHashMap = new HashMap<>();
        doctorAppointmentHashMap = new HashMap<>();
    }
    public static AppointmentDao getAppointmentDao() {
        if(appointmentDao == null){
            appointmentDao = new AppointmentDao();
        }
        return appointmentDao;
    }

    public List<Appointment> getPatientAppointment(Patient patient){
        return patientAppointmentHashMap.getOrDefault(patient,new ArrayList<>());
    }

    public List<Appointment> getDoctorAppointment(Doctor doctor){
        return doctorAppointmentHashMap.getOrDefault(doctor,new ArrayList<>());
    }

    public void bookAppointment(Doctor doctor, Patient patient,Appointment appointment){

        List<Appointment> patientAppointment = patientAppointmentHashMap.getOrDefault(patient,new ArrayList<>());
        patientAppointment.add(appointment);
        patientAppointmentHashMap.put(patient,patientAppointment);

        List<Appointment> doctorAppointment = doctorAppointmentHashMap.getOrDefault(doctor,new ArrayList<>());
        doctorAppointment.add(appointment);
        doctorAppointmentHashMap.put(doctor,doctorAppointment);
    }

    public void cancelAppointment(Appointment appointment){
        List<Appointment> patientAppointment = patientAppointmentHashMap.get(appointment.getPatient());
        patientAppointment.remove(appointment);

        List<Appointment> doctorAppointment = doctorAppointmentHashMap.get(appointment.getDoctor());
        doctorAppointment.remove(appointment);
    }
}
