package abstractionAndInheritance;

public class Rectangle extends Shape{

    public Rectangle(int width, int height) {
        super(width, height);
    }

    @Override
    public int getArea(){
        return getWidth()*getHeight();
    }

    @Override
    public int getCircumference(){
        return (getWidth()+getHeight())*2;
    }
}
