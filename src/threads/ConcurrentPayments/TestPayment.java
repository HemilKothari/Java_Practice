package threads.ConcurrentPayments;

import java.util.Scanner;

public class TestPayment {
    public static void main(String[] args) throws InterruptedException {
        MerchantAccount merchantAccount = new MerchantAccount();
        CustomerPayment[] customerPayments = new CustomerPayment[10];
        Scanner scanner = new Scanner(System.in);
        String customerName;
        double paymentAmount;

        for (int i = 0; i < customerPayments.length; i++) {
            System.out.print("\nEnter customer name: ");
            customerName = scanner.nextLine();
            System.out.print("\nEnter payment amount: ");
            paymentAmount = scanner.nextDouble();
            scanner.nextLine();
            customerPayments[i] = new CustomerPayment(merchantAccount, customerName, paymentAmount);
        }

        for (CustomerPayment customerPayment : customerPayments) {
            customerPayment.start(); 
        }

        for (CustomerPayment customerPayment : customerPayments) {
            customerPayment.join();
        }

        System.out.println("==============================");
        System.out.println("Final Balance in Merchant Account: " + merchantAccount.getBalance());
        System.out.println("==============================");

        scanner.close();
    }

}
