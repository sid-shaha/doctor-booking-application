package doamin;

import java.util.List;

public class Doctor implements Cloneable{
    String speciality;
    int age;
    String name;

    public Doctor(String speciality, int age, String name, List<Slot> availableSlots) {
        this.speciality = speciality;
        this.age = age;
        this.name = name;
        this.availableSlots = availableSlots;
    }

    List<Slot> totalRegisteredSlots;
    List<Slot> availableSlots;

    public List<Slot> getSlots() {
        return availableSlots;
    }

    public void setSlots(List<Slot> slots) {
        this.availableSlots = slots;
    }

    public void addSlot(Slot slot) {
        this.availableSlots.add(slot);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
