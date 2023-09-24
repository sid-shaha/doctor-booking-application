package doamin;


public class Slot {
    private String day;
    private int start_time;
    private int end_time;

    public Slot(String day, int start_time, int end_time) {
        this.day = day;
        this.start_time = start_time;
        this.end_time = end_time;
    }



    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }


}
