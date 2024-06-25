package org.example.oopconcepts;

// Base Class
class Shape {
    void draw() {
        System.out.println("Drawing a shape");
    }

    void name() {
        System.out.println("This is a Shape");
    }
}

// Subclass 1
class Circle extends Shape {
    @Override
    void draw() { // Method overriding
        System.out.println("Drawing a circle");
    }

    void draw(int radius) { // Method overloading
        System.out.println("Drawing a circle with radius " + radius);
    }
}

// Subclass 2
class Rectangle extends Shape {
    @Override
    void draw() { // Method overriding
        System.out.println("Drawing a rectangle");
    }

    void draw(int width, int height) { // Method overloading
        System.out.println("Drawing a rectangle with width " + width + " and height " + height);
    }
}

// Main Class
public class PolymorphismExample {
    public static void main(String[] args) {
        Shape shape1 = new Circle();
        Shape shape2 = new Rectangle();
        Shape shape3 = new Shape();

        shape1.draw();      // Calls Circle's draw()
        shape2.draw();      // Calls Rectangle's draw()
        shape3.draw();      // Calls Shape's draw()

        // shape1.draw(5);   // Error: draw(int) is not defined in Shape
        ((Circle) shape1).draw(5); // Calls Circle's draw(int)
        //shape2.draw(10, 20); // Error: draw(int, int) is not defined in Shape
        ((Rectangle) shape2).draw(10, 20); // Calls Rectangle's draw(int, int)

        shape1.name();      // Calls Shape's name()
        shape2.name();      // Calls Shape's name()
        shape3.name();      // Calls Shape's name()
    }
}

