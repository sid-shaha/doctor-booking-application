package service;

import doamin.Doctor;
import doamin.Slot;
import doamin.Speciality;

import java.util.HashMap;
import java.util.List;

public interface SearchService {
    public List<Doctor> search(Speciality speciality);
}
