package fileHandling.serialization;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String studentName;
    private float percentage;
    public Student() {
    }
    public Student(int id, String studentName, float percentage) {
        this.id = id;
        this.studentName = studentName;
        this.percentage = percentage;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public float getPercentage() {
        return percentage;
    }
    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
    public void printDetails() {
        System.out.println("Id: " + this.id + "\nName: " + this.studentName + "\nPercentage: " + this.percentage);
    }
}
