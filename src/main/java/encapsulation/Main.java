package encapsulation;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4);

        System.out.println("Height: " + triangle.getHeight() + ", Width: " + triangle.getWidth());
        System.out.println("Area: " + triangle.getArea() + ", Circumference: " + triangle.getCircumference());

        // Here we set the width to 0, to show that the internal logic
        // in our encapsulated class is working as expected
        triangle.setWidth(0);
        triangle.setHeight(69);

        System.out.println("Height: " + triangle.getHeight() + ", Width: " + triangle.getWidth());
        System.out.println("Area: " + triangle.getArea() + ", Circumference: " + triangle.getCircumference());
    }
}
