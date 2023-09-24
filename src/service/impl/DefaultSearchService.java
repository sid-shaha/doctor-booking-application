package service.impl;

import dao.DoctorDao;
import doamin.Doctor;
import doamin.Slot;
import doamin.Speciality;
import service.SearchService;

import java.util.HashMap;
import java.util.List;

public class DefaultSearchService implements SearchService {

    @Override
    public List<Doctor> search(String speciality) {
        DoctorDao dao = DoctorDao.getDoctorDao();
        return dao.getDoctorBySpeciality(String.valueOf(Speciality.General_Physician));
    }
}
