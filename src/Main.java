import doamin.*;
import service.AppointmentService;
import service.RegisterationService;
import service.SearchService;
import service.impl.DefaultSearchService;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


//Description:
//        We are required to build an app that lets patients connect to doctors and book appointments.
//        The day is divided into time slots of 30 mins each, starting from 9 am to 9 pm.
//        Doctors can login to the portal and declare their availability for the given day in terms of slots.
//        Patients can book appointments/ cancel existing appointments.
//        For simplicity you can assume that the doctors’ availability is declared for that particular day only.
//
//        Features:
//        A new doctor should be able to register, and mention his/her speciality among (Cardiologist, Dermatologist, Orthopedic, General Physician)
//        A doctor should be able to declare his/her availability in each slot for the day. For example, the slots will be of 30 mins like 9am-9.30am, 9.30am-10am..
//        Patients should be able to register.
//        Patients should be able to search available slots based on speciality.
//        The slots should be displayed in a ranked fashion. Default ranking strategy should be to rank by start time. But we should be able to plugin more strategies like Doctor’s rating etc in future.
//        Patients should be able to book appointments with a doctor for an available slot.A patient can book multiple appointments in a day.
//        A patient cannot book two appointments with two different doctors in the same time slot.
//        Patients can also cancel an appointment, in which case that slot becomes available for someone else to book.
//        Build a waitlist feature:
//        If the patient wishes to book a slot for a particular doctor that is already booked, then add this patient to the waitlist.
//        If the patient with whom the appointment was booked originally cancels the appointment, then the first in the waitlist gets the appointment.
//        A patient/doctor should be able to view his/her booked appointments for the day.


// RegistrationService - Register Doctors, Patients
// SearchService -
// AppointmentService -
public class Main {
    public static void main(String[] args) throws Exception {

        // Services initalization
        RegisterationService registerationService = new RegisterationService();
        SearchService searchService = new DefaultSearchService();
        AppointmentService appointmentService = new AppointmentService();

        // Doctor registeration

        List<Slot> slots = new ArrayList<>();
        Doctor doctor = new Doctor(Speciality.Dermatologist,1,30,"Sid");
        registerationService.registerDoctor(doctor);

        //Patient registration
        Patient patient = new Patient(1,"patientA",21);
        registerationService.registerPatient(patient);

        // Doctor hours registeration
        Slot slot = new Slot("Monday",11,12);
        slots.add(slot);
        registerationService.registerDoctorsAvailablility(doctor.getId(),slots);

        // Print Doctor Details
        System.out.println("Doctor details "+doctor.toString());

        // Book Appointment
        appointmentService.bookAppointment(doctor.getId(),patient.getId(),slot);


        // view patients appointments
        List<Appointment> appointments = appointmentService.getPatientAppointment(patient.getId());
        System.out.println("Patients Appointments");
        for(int i=0;i<appointments.size();i++){
            System.out.println(appointments.get(i).toString());
        }

        // view doctor appointments
        List<Appointment> docAppointments = appointmentService.getDoctorBookedAppointment(doctor.getId());
        System.out.println("Doctors Appointments");
        for(int i=0;i<docAppointments.size();i++){
            System.out.println(docAppointments.get(i).toString());
        }

       // Search doctor based on speciality
        Speciality speciality = Speciality.Dermatologist;
        System.out.println(speciality);

        List<Doctor> doctors = searchService.search(speciality);
        // HashMap<Doctor, List<Slot>> doctorSlotHashMap = searchService.search(speciality);
        for(int i=0;i<doctors.size();i++){
            System.out.println(doctors.get(i).toString());
        }

        System.out.println("Hello world!");
    }
}