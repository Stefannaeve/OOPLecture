package abstractionAndInheritance;

// abstract Parent(super) class
public abstract class Shape {
    private int width;
    private int height;


    public Shape(int width, int height) {
        this.width = width;
        this.height = height;
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

    // abstract Methods, these do not have a body, as it is expected that
    // an abstract method is enforced in a child class, which will
    // add a body
    public abstract int getArea();

    public abstract int getCircumference();
}
