package threads.ConcurrentPayments;

public class CustomerPayment extends Thread {
    private MerchantAccount merchantAccount;
    private String customerName;
    private double paymentAmount;

    public CustomerPayment(MerchantAccount merchantAccount, String customerName, double paymentAmount) {
        this.merchantAccount = merchantAccount;
        this.customerName = customerName;
        this.paymentAmount = paymentAmount;
    }

    @Override
    public void run() {
        merchantAccount.receivePayment(customerName, paymentAmount);
    }
}
