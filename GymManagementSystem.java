import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GymManagementSystem {

    private static final Scanner input = new Scanner(System.in);

    private final ArrayList<Batch> batches;

    public GymManagementSystem() {
        this.batches = new ArrayList<>();
    }

    public void showMenu() {
        System.out.println("\nHere are some options for you:\n1.\tCreate a New Group\n" +
                "2.\tAdd Participant to Group\n3.\tShow all Group Participants\n" +
                "4.\tShow all Batched\n5.\tEXIT");

        System.out.print("\nEnter your choice: ");

        int choice = input.nextInt();

        System.out.println();
        controls(choice);
    }

    private void controls(int choice) {
        switch (choice) {
            case 1 -> createNewBatch();
            case 2 -> addParticipant();
            case 3 -> showParticipants();
            case 4 -> showAllBatches();
            case 5 -> System.exit(0);
            default -> System.out.println("Invalid input provided.");
        }

        showMenu();
    }

    private void createNewBatch() {
        input.nextLine();

        System.out.print("Enter batch name: ");
        String batchName = input.nextLine();

        for (Batch batch : this.batches) {
            if (batch.equals(batchName)) {
                System.out.println("A batch with similar name already exists!");
                return;
            }
        }

        System.out.print("Enter date when the batch starts (YYYY-MM-DD): ");
        String dateStr = input.nextLine();

        LocalDate date = LocalDate.parse(dateStr);

        final Batch batch = new Batch(batchName, date);

        this.batches.add(batch);

        System.out.println("\nNew Batch '" + batchName + "' at " + dateStr + " added!");
    }

    private void addParticipant() {
        input.nextLine();

        System.out.print("Enter batch name: ");
        String batchName = input.nextLine();

        for (Batch batch : this.batches) {
            if (batch.equals(batchName)) {
                System.out.print("Enter name: ");
                String name = input.nextLine();

                System.out.print("Enter phone: ");
                String phone = input.nextLine();

                final Participant participant = new Participant(name, phone);
                batch.addParticipant(participant);

                System.out.println("\nNew Participant added.");
                System.out.println("Name " + batchName + " has started!");
                System.out.println(name + ", your group has started!");
                return;
            }
        }

        System.out.println("\nNo batch found with the name provided!");
    }

    private void showParticipants() {
        input.nextLine();

        System.out.print("Enter batch name: ");
        String batchName = input.nextLine();

        for (Batch batch : this.batches) {
            if (batch.equals(batchName)) {
                System.out.println();
                batch.displayBatch();
                return;
            }
        }

        System.out.println("\nNo batch found with the name provided!");
    }


    private void showAllBatches() {
        for (Batch batch : this.batches) {
            System.out.println(batch);
        }
      
    }

}

