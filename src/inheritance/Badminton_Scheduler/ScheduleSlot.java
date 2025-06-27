package inheritance.Badminton_Scheduler;

import java.util.Scanner;

public class ScheduleSlot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BatchList batchList = new BatchList();
        Batch[] batch = batchList.getBatchList();

        System.out.println("Enter number of users: ");
        User[] userList = new User[scanner.nextInt()];
        scanner.nextLine();

        for (int i = 0; i < userList.length; i++) {
            userList[i] = new User();
            System.out.println("Enter your name: ");
            userList[i].setUserName(scanner.nextLine());
            boolean flag = true;
            while (flag) {
                System.out.println("1. View Batch \n2. Book Batch\n3. Cancel Batch\n4. Exit\nEnter a choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        batchList.displayBatchList();
                        break;

                    case 2:
                        if (userList[i].getBookedBatchIndex() != -1) {
                            System.out.println("You can book only one batch.");
                            continue;
                        }
                        System.out.println("Enter index value of your slot: ");
                        int selectedIndex = scanner.nextInt();
                        scanner.nextLine();
                        if (selectedIndex < 0 || selectedIndex >= batch.length) {
                            System.out.println("Invalid batch index.");
                            continue;
                        }
                        userList[i].setBookedBatchIndex(selectedIndex);
                        if (batch[userList[i].getBookedBatchIndex()].getSpots() == 0)
                            System.out.println("The required batch is full.");
                        else {
                            userList[i].bookBatch(batch[userList[i].getBookedBatchIndex()].getSlot());
                            System.out.println("Batch Booked.");
                            System.out.println(userList[i]);
                            batch[userList[i].getBookedBatchIndex()]
                                    .setSpots(batch[userList[i].getBookedBatchIndex()].getSpots() - 1);
                        }

                        break;

                    case 3:
                        int bookedIndex = userList[i].getBookedBatchIndex();
                        if (bookedIndex != -1) {
                            batch[bookedIndex].setSpots(batch[bookedIndex].getSpots() + 1);
                            userList[i].cancelBatch();
                            System.out.println("Batch cancelled.");
                            System.out.println(userList[i]);
                        } else {
                            System.out.println("You have not booked any batch yet.");
                        }
                        break;

                    case 4:
                        flag = false;
                        break;

                    default:
                        System.out.println("Select an appropriate choice.");
                }
            }
        }
        scanner.close();
    }
}
