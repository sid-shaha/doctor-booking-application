package dao;

import doamin.Doctor;
import doamin.Slot;

import java.util.ArrayList;
import java.util.List;

public class DoctorDao {
    private static DoctorDao doctorDao;
    List<Doctor> doctors = new ArrayList<>();
    private DoctorDao(){

    }

    public static DoctorDao getDoctorDao() {
        if(doctorDao == null){
            doctorDao = new DoctorDao();
        }
        return doctorDao;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }
    public List<Doctor> getDoctorBySpeciality(String speciality){
        return doctors;
    }

    public void updateDoctorAvailablity(Doctor doctor, List<Slot> availableSlots) {
       // Check how to update this

    }
}
