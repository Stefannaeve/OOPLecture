package Static;

import static java.lang.Math.sqrt;

public class Triangle extends Shape {

    public Triangle(int width, int height){
        super(width, height);
    }

    @Override
    public int getArea(){
        return (getWidth()*getHeight())/2;
    }

    @Override
    public int getCircumference(){
        return (getWidth()+getHeight())+(int)sqrt(getWidth()*getWidth()+getHeight()*getHeight());
    }


}
