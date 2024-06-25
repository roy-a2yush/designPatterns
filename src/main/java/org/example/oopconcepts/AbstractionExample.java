package org.example.oopconcepts;

// Abstract Class
abstract class Vehicle {
    // Abstract methods (no implementation)
    abstract void start();
    abstract void accelerate();
    abstract void stop();

    // Concrete method (with implementation)
    void displayInfo() {
        System.out.println("This is a vehicle.");
    }
}

// Concrete Class (Implementing the Abstraction)
class Car extends Vehicle {
    void start() {
        System.out.println("Car engine started.");
    }

    void accelerate() {
        System.out.println("Car is accelerating.");
    }

    void stop() {
        System.out.println("Car brakes applied.");
    }
}

// Main Class
public class AbstractionExample {
    public static void main(String[] args) {
        Vehicle myCar = new Car();  // Create a Car object using Vehicle reference
        myCar.start();
        myCar.accelerate();
        myCar.stop();
        myCar.displayInfo();
    }
}