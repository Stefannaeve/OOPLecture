package Static;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4);

        System.out.println("Height: " + triangle.getHeight() + ", Width: " + triangle.getWidth());
        System.out.println("Area: " + triangle.getArea() + ", Circumference: " + triangle.getCircumference());

        Rectangle rectangle = new Rectangle(3, 4);
        Rectangle rectangle2 = new Rectangle(3, 4);
        Rectangle rectangle3 = new Rectangle(3, 4);
        Rectangle rectangle4 = new Rectangle(3, 4);

        System.out.println("Height: " + rectangle.getHeight() + ", Width: " + rectangle.getWidth());
        System.out.println("Area: " + rectangle.getArea() + ", Circumference: " + rectangle.getCircumference());

        System.out.println("How many objects have been made from shape: " + Shape.getCount());
        System.out.println("How many objects have been made from shape: " + triangle.getCount());
    }
}