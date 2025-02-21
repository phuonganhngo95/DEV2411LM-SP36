package com.lesson02.dependency_injection;

@FunctionalInterface
interface Shape {
    void draw();
}

class CircleShape implements Shape {
    public void draw() {
        System.out.println("CircleShape draw:");
    }
}

class RectangleShape implements Shape {
    public void draw() {
        System.out.println("RectangleShape draw:");
    }
}

public class DrawShape {
    private Shape shape;

    public DrawShape(Shape shape) {
        this.shape = shape;
    }

    public void draw() {
        shape.draw();
    }

    public static void main(String[] args) {
        DrawShape drawShape = new DrawShape(new CircleShape());
        drawShape.draw();

        drawShape = new DrawShape(new RectangleShape());
        drawShape.draw();
    }
}
