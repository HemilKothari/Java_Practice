package model;

public class Batch {
    private int batchId;
    private String batchTiming;
    private int maxCapacity;

    public Batch() {
    }

    public Batch(int batchId, String batchTiming, int maxCapacity) {
        this.batchId = batchId;
        this.batchTiming = batchTiming;
        this.maxCapacity = maxCapacity;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getBatchTiming() {
        return batchTiming;
    }

    public void setBatchTiming(String batchTiming) {
        this.batchTiming = batchTiming;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "batchId=" + batchId +
                ", batchTiming='" + batchTiming + '\'' +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}
