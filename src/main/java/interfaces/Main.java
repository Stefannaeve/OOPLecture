package interfaces;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Square square = new Square(3,4);
        Triangle triangle = new Triangle(3, 4);

        ArrayList<Shape> lists = new ArrayList();
        lists.add(triangle);

    }
}
