package com.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int batchId;
    private String batchTiming;
    private int maxCapacity = 0;

    @OneToMany(mappedBy = "batchInfo")
    private List<User> users;

    public Batch() {
    }

    public Batch(int batchId, String batchTiming, int maxCapacity, List<User> users) {
        this.batchId = batchId;
        this.batchTiming = batchTiming;
        this.maxCapacity = maxCapacity;
        this.users = users;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
