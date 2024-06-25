package org.example.designpattern.structural;

public class DecoratorPatternExample {
}

interface Shape {
    void draw();
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}


abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw() {
        decoratedShape.draw();
    }
}


class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}

class BlueFillDecorator extends ShapeDecorator {

    public BlueFillDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setBlueFill(decoratedShape);
    }

    private void setBlueFill(Shape decoratedShape) {
        System.out.println("Fill Color: Blue");
    }
}


class DecoratorPatternDemo {

    public static void main(String[] args) {
        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        Shape blueFilledRedCircle = new BlueFillDecorator(redCircle);

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle with red border");
        redCircle.draw();

        System.out.println("\nRectangle with red border");
        redRectangle.draw();

        System.out.println("\nCircle with red border and blue fill");
        blueFilledRedCircle.draw();
    }
}
