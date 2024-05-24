package encapsulation;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4);

        System.out.println("Height: " + triangle.getHeight() + ", Width: " + triangle.getWidth());
        System.out.println("Area: " + triangle.getArea() + ", Circumference: " + triangle.getCircumference());

        triangle.setWidth(0);
        triangle.setHeight(69);

        System.out.println("Height: " + triangle.getHeight() + ", Width: " + triangle.getWidth());
        System.out.println("Area: " + triangle.getArea() + ", Circumference: " + triangle.getCircumference());
    }
}
