package threads.ConcurrentPayments;

public class MerchantAccount {
    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    public synchronized void receivePayment(String customerName, double amount ) {
        System.out.println("==============================");
        System.out.println("Paying " + amount + " from " + customerName);
        System.out.println("------------------------------");
        setBalance(amount);
        System.out.println("Customer Name: " + customerName + "\nAmount Paid: " + amount + "\nUpdated Balance: " + getBalance());
    }
}
