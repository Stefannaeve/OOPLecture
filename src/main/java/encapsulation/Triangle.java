package encapsulation;

import static java.lang.Math.sqrt;

public class Triangle {
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
        if (width < 1){
            this.width = 1;
        } else {
            this.width = width;
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < 1){
            this.height = 1;
        } else {
            this.height = height;
        }
    }

    public int getArea(){
        return (width*height)/2;
    }

    public int getCircumference(){
        return (width+height)+(int)sqrt(width*width+height*height);
    }
}
