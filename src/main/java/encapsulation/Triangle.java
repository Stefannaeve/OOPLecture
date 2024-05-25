package encapsulation;

import static java.lang.Math.sqrt;

// First example for encapsulation
public class Triangle {

    // Make variables private to ensure we handle variables through
    // our own internal logic in the setters, and in the constructor
    private int width;
    private int height;

    // To ensure the internal logic, you could enforce the internal logic
    // By calling the setters in the constructor
    public Triangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    // We don't allow the user to set the variable to anything less than 1
    public void setWidth(int width) {
        if (width < 1){
            this.width = 1;
        } else {
            this.width = width;
        }
    }

    public int getHeight() {
        return height;
    }

    // We don't allow the user to set the variable to anything less than 1
    public void setHeight(int height) {
        if (height < 1){
            this.height = 1;
        } else {
            this.height = height;
        }
    }

    // Mathematical equations for area and circumference of triangle
    public int getArea(){
        return (width*height)/2;
    }

    public int getCircumference(){
        return (width+height)+(int)sqrt(width*width+height*height);
    }
}
