package inheritance.abstractClass;

public class Circle extends Shape {

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void findArea() {
        area = radius * radius * 3.14;
    }

    void display() {
        System.out.println("Radius: " + radius);
        super.display();
    }

}
