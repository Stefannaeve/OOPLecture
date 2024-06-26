package abstractionAndInheritance;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4);

        System.out.println("Height: " + triangle.getHeight() + ", Width: " + triangle.getWidth());
        System.out.println("Area: " + triangle.getArea() + ", Circumference: " + triangle.getCircumference());

        Rectangle rectangle = new Rectangle(3, 4);

        System.out.println("Height: " + rectangle.getHeight() + ", Width: " + rectangle.getWidth());
        System.out.println("Area: " + rectangle.getArea() + ", Circumference: " + rectangle.getCircumference());
    }
}