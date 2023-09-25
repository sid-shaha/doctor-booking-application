package dao;

import doamin.Doctor;
import doamin.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientDao {
    private static PatientDao patientDao;

    private final List<Patient> patients;
    private PatientDao(){
        patients = new ArrayList<>();
    }

    public static PatientDao getPatientDao() {
        if(patientDao == null){
            patientDao = new PatientDao();
        }
        return patientDao;
    }
    public void addPatient(Patient patient) {
        patients.add(patient);
    }
    public void removePatient(int id) {
        for(int index=0;index<patients.size();index++){
            if(patients.get(index).getId() == id){
                patients.remove(index);
                break;
            }
        }
    }
    public Patient getPatientById(int id) {
        for(int index=0;index<patients.size();index++){
            if(patients.get(index).getId() == id){
                return patients.get(index);
            }
        }
        throw new RuntimeException("Patient not found");
    }
}
