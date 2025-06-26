package inheritance.hp;

public class TestProduct {
    public static void main(String[] args) {
        PrintScan printScan = new PrintScan("101", 10000);
        printScan.sendDataToPrinter("This data is from printer");
        printScan.sendDataToScanner("This data is in scanner.");

        printScan.printDataFromPrinter();
        printScan.printDataFromScanner();
    }
}
