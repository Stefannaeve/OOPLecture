package Interface;

import static java.lang.Math.sqrt;

public class Triangle implements Shape {
    private int width;
    private int height;

    public Triangle(int width, int height) {
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

    @Override
    public int getArea(){
        return (width*height)/2;
    }

    @Override
    public int getCircumference(){
        return (width+height)+(int)sqrt(width*width+height*height);
    }
}
