package abstractionAndInheritance;

// Child class
public class Rectangle extends Shape{

    // Call super to grab the constructor of the parent class (Shape in this case)
    public Rectangle(int width, int height) {
        super(width, height);
    }

    // We have to override these two methods, as they are abstract methods in
    // the parent class. This ensures we have to make our own body for this version
    // of these methods, in this class
    @Override
    public int getArea(){
        return getWidth()*getHeight();
    }

    @Override
    public int getCircumference(){
        return (getWidth()+getHeight())*2;
    }
}
