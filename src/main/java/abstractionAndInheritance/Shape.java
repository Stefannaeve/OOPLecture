package abstractionAndInheritance;

public class Shape {
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

    public int getArea(){
        return 0;
    }

    public int getCircumference(){
        return 0;
    }
}
