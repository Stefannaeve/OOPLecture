package Static;

public abstract class Shape {
    private int width;
    private int height;
    private static int count;


    public Shape(int width, int height) {
        this.width = width;
        this.height = height;
        count++;
    }

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
