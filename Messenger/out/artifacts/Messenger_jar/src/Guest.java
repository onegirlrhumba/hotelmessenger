import java.util.HashMap;

public class Guest {

    private int id;
    private String firstName;
    private String lastName;
    private HashMap<String, Long> reservation;
    private Long startTimestamp;
    private Long endTimestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public HashMap<String, Long> getReservation() {
        return reservation;
    }

    public void setReservation(HashMap<String, Long> reservation) {
        this.reservation = reservation;
    }

    public Long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Long getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }
}
