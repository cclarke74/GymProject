import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Batch {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy");

    private final ArrayList<Participant> participants;
    private final LocalDate date;
    private final String name;

    public Batch(String name, LocalDate date) {
        this.name = name;
        this.date = date;
        this.participants = new ArrayList<>();
    }

    public void addParticipant(Participant participant) {
        this.participants.add(participant);
    }

    public void displayBatch() {
        for (Participant participant : this.participants) {
            System.out.println(participant);
        }
    }

    public boolean equals(String batchName) {
        return this.name.equalsIgnoreCase(batchName);
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public String getDate() {
        return date.format(formatter);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Batch name: " + this.name + ", date: " + getDate();
    }
}