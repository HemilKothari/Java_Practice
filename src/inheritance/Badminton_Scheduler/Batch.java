package inheritance.Badminton_Scheduler;

public class Batch {
    private String slot;
    private int spots;

    public Batch() {}

    public Batch(String slot, int spots) {
        this.slot = slot;
        this.spots = spots;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public int getSpots() {
        return spots;
    }

    public void setSpots(int spots) {
        this.spots = spots;
    }

    @Override
    public String toString() {
        return ", slot: " + slot ;
    };

    
    

    

    // Batch[] batchList = new Batch[] {
    //     new Batch("7AM - 8AM", 6),
    //     new Batch("8AM - 9AM", 8),
    //     new Batch("9AM - 10AM", 7),
    //     new Batch("10AM - 11AM", 4),
    //     new Batch("11AM - 12PM", 2),
    //     new Batch("2PM - 3PM", 3),
    // };
}
