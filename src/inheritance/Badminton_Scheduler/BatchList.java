package inheritance.Badminton_Scheduler;

public class BatchList{

    private Batch[] batchList = new Batch[6];

    public BatchList() {
        batchList[0] = new Batch("7AM - 8AM", 6);
        batchList[1] = new Batch("8AM - 9AM", 4);
        batchList[2] = new Batch("9AM - 10AM", 0);
        batchList[3] = new Batch("10AM - 11AM", 5);
        batchList[4] = new Batch("11AM - 12PM", 2);
        batchList[5] = new Batch("5PM - 6PM", 3);
    }
    
    public void displayBatchList() {
        int index = 0;
        for (Batch batch : batchList) {
            System.out.println(index + " -> Slot: " + batch.getSlot() + ", Spots: " + batch.getSpots());
            index++;
        }
    }

    public Batch[] getBatchList() {
        return batchList;
    }
}
