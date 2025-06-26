package inheritance.hp;

public class PrintScan{
    private Printer printer;
    private Scanner scanner;

    public PrintScan(String modelNumber, double price) {
        this.printer = new Printer(modelNumber, price);
        this.scanner = new Scanner(modelNumber, price);
    }

    public void sendDataToPrinter(String data) {
        printer.setDataPrinted(data);
    }

    public void sendDataToScanner(String data) {
        scanner.setDataScanned(data);
    }

    public void printDataFromPrinter() {
        printer.printData();
    }

    public void printDataFromScanner() {
        scanner.scanData();
    }
}