package abstractionAndInheritance;

import static java.lang.Math.sqrt;

// Child class
public class Triangle extends Shape{

    // Call super to grab the constructor of the parent class (Shape in this case)
    public Triangle(int width, int height){
        super(width, height);
    }

    // We have to override these two methods, as they are abstract methods in
    // the parent class. This ensures we have to make our own body for this version
    // of these methods, in this class
    @Override
    public int getArea(){
        return (getWidth()*getHeight())/2;
    }

    @Override
    public int getCircumference(){
        return (getWidth()+getHeight())+(int)sqrt(getWidth()*getWidth()+getHeight()*getHeight());
    }


}
