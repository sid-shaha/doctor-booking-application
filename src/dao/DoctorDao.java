package dao;

import doamin.Doctor;
import doamin.Doctor;
import doamin.Slot;
import doamin.Speciality;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DoctorDao {
    private static DoctorDao doctorDao;
    private final List<Doctor> doctors;
    private DoctorDao(){
        doctors = new ArrayList<>();
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
    public List<Doctor> getDoctorBySpeciality(Speciality speciality){
        List<Doctor> temp = new ArrayList<>();
        for(int index=0;index<doctors.size();index++){
            if(Objects.equals(doctors.get(index).getSpeciality(), speciality)){
                temp.add(doctors.get(index));
            }
        }
        return temp;
    }

    public void updateDoctorAvailablity(int id, List<Slot> availableSlots) {
       Doctor doctor = getDoctorById(id);
       doctor.setSlots(availableSlots);

    }

    public void removeDoctor(int id) {
        for(int index=0;index<doctors.size();index++){
            if(doctors.get(index).getId() == id){
                doctors.remove(index);
                break;
            }
        }
    }
    public Doctor getDoctorById(int id) {
        for(int index=0;index<doctors.size();index++){
            if(doctors.get(index).getId() == id){
                return doctors.get(index);
            }
        }
        throw new RuntimeException("Doctor not found");
    }
}
