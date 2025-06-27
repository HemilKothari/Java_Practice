package inheritance.Badminton_Scheduler;

public class User extends Batch {

    private String userName;
    private int bookedBatchIndex = -1;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getBookedBatchIndex() {
        return bookedBatchIndex;
    }
    public void setBookedBatchIndex(int bookedBatchIndex) {
        this.bookedBatchIndex = bookedBatchIndex;
    }

    public void bookBatch(String slot) {
        this.setSlot(slot);
    }

    public void cancelBatch() {
        this.setSlot(null);
        this.bookedBatchIndex = -1;
    }

    @Override
    public String toString() {
        return "User [userName: " + userName + super.toString() + "]";
    }

    
    
}
