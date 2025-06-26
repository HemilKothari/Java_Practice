package inheritance.hp;

public class Scanner extends Product implements Scannable {
    String dataScanned;

    public Scanner(String modelNumber, double price) {
        super(modelNumber, price);
    }



    @Override
    public void scanData() {
        System.out.println(dataScanned);
        System.out.println("Data Scanned.");
        System.out.println("----------------");
    }



    public String getDataScanned() {
        return dataScanned;
    }



    public void setDataScanned(String dataScanned) {
        this.dataScanned = dataScanned;
    }
}
