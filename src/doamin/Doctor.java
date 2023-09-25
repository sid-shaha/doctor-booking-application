package doamin;

import java.util.List;

public class Doctor{
    private int id;
    private Speciality speciality;
    private int age;
    private String name;

    List<Slot> totalRegisteredSlots;
    List<Slot> availableSlots;

    public Doctor(Speciality speciality,int id, int age, String name) {
        this.id = id;
        this.speciality = speciality;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", speciality=" + speciality +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", totalRegisteredSlots=" + totalRegisteredSlots +
                ", availableSlots=" + availableSlots +
                '}';
    }

    public Doctor(Speciality speciality, int id, int age, String name, List<Slot> availableSlots) {
        this.id = id;
        this.speciality = speciality;
        this.age = age;
        this.name = name;
        this.availableSlots = availableSlots;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Slot> getSlots() {
        return availableSlots;
    }

    public void setSlots(List<Slot> slots) {
        this.availableSlots = slots;
    }

    public void addSlot(Slot slot) {
        this.availableSlots.add(slot);
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
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
