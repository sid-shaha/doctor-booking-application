package dao;

import doamin.Doctor;
import doamin.Patient;

public class PatientDao {
    private static PatientDao patientDao;

    private PatientDao(){

    }

    public static PatientDao getPatientDao() {
        if(patientDao == null){
            patientDao = new PatientDao();
        }
        return patientDao;
    }
    public void addPatient(Patient patient) {

    }
}
