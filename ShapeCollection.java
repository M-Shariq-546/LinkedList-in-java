import java.util.Date;
import java.util.Scanner;

public class ShapeCollection {

    public static void main(String[] args) {
        LinkedList shapeList = new LinkedList();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the shape name (Rectangle/Square/Triangle):");
        String shapeName = scanner.nextLine();

        if (shapeName.equalsIgnoreCase("Rectangle")) {
            System.out.println("Enter width:");
            double width = scanner.nextDouble();
            System.out.println("Enter height:");
            double height = scanner.nextDouble();
            Rectangle rectangle = new Rectangle(width, height);
            shapeList.addShape(rectangle);
        } else if (shapeName.equalsIgnoreCase("Square")) {
            System.out.println("Enter side length:");
            double side = scanner.nextDouble();
            Square square = new Square(side);
            shapeList.addShape(square);
        } else if (shapeName.equalsIgnoreCase("Triangle")) {
            System.out.println("Enter base length:");
            double base = scanner.nextDouble();
            System.out.println("Enter height:");
            double height = scanner.nextDouble();
            Triangle triangle = new Triangle(base, height);
            shapeList.addShape(triangle);
        } else {
            System.out.println("Invalid shape name.");
        }

        scanner.close();

        System.out.println("\nShape List:\n" + shapeList);
    }
}

class Shape {
    private static int nextID = 1;

    private int id;
    private Date creationTime;

    public Shape() {
        this.id = nextID++;
        this.creationTime = new Date();
    }

    public int getId() {
        return id;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    @Override
    public String toString() {
        return "Shape ID: " + id + ", Created at: " + creationTime;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString() + ", Width: " + width + ", Height: " + height;
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        super();
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return super.toString() + ", Side: " + side;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        super();
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString() + ", Base: " + base + ", Height: " + height;
    }
}

class LinkedList {
    private Node head;

    public void addShape(Shape shape) {
        Node newNode = new Node(shape);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.shape).append("\n");
            current = current.next;
        }
        return sb.toString();
    }

    private class Node {
        Shape shape;
        Node next;

        public Node(Shape shape) {
            this.shape = shape;
            this.next = null;
        }
    }
}
