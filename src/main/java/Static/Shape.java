package Static;

public abstract class Shape {
    private int width;
    private int height;
    // Make this variable private for encapsulation
    // Set it as static, so we can grab this variable from the class
    // instead from the instance of a class (object)
    // This is, so we can have a count of all the objects which has been made
    private static int count;

    // count++ ensures that we add 1 to the count everytime an object is made
    // When an object is made the constructor is called, this is why this
    // way to do it works
    public Shape(int width, int height) {
        this.width = width;
        this.height = height;
        count++;
    }

    // If we are to grab a static variable, we want a static methods to grab
    // it, instead of using an object, which would defeat the purpose
    public static int getCount() {
        return count;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract int getArea();

    public abstract int getCircumference();
}
