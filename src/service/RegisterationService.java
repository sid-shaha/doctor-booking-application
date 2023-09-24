package service;

import dao.DoctorDao;
import dao.PatientDao;
import doamin.Doctor;
import doamin.Patient;
import doamin.Slot;

import java.util.List;

public class RegisterationService {
    public void registerDoctor(Doctor doctor){
        DoctorDao doctorDao = DoctorDao.getDoctorDao();
        doctorDao.addDoctor(doctor);
    }
    public void registerPatient(Patient patient){
        PatientDao patientDao = PatientDao.getPatientDao();
        patientDao.addPatient(patient);
    }
    public void registerDoctorsAvailablility(Doctor doctor, List<Slot> slots){
        doctor.setSlots(slots);
    }
}
