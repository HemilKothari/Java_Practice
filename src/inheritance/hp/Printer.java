package inheritance.hp;

public class Printer extends Product implements Printable {

    private String dataPrinted;

    public Printer(String modelNumber, double price) {
        super(modelNumber, price);
    }

    @Override
    public void printData() {
        System.out.println(dataPrinted);
        System.out.println("Data Printed");
        System.out.println("----------------");
    }

    public String getDataPrinted() {
        return dataPrinted;
    }

    public void setDataPrinted(String dataPrinted) {
        this.dataPrinted = dataPrinted;
    }

}
