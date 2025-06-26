package inheritance.abstractClass;

public class Square extends Shape {

    double side;

    @Override
    void findArea() {
        area = side * side;
    }
    
    void display() {
        System.out.println("Side: " + side);
        super.display();
    }
}
