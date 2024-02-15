import org.w3c.dom.ls.LSOutput;

import java.util.*;
class Window {
    private String type;
    public Window(String type) {
        this.type = type;
    }
    public double area(double unit1, double unit2) {
        double area = 0;
        switch (type.toLowerCase()) {
            case "square":
                area = unit1 * unit2;
                break;
            case "rectangle":
                area = unit1 * unit2;
                break;
            case "triangle":
                area = 0.5 * unit1 * unit2;
                break;
            default:
                System.out.println("Invalid window type. Pick from the options list.");
        }
        return area;
    }
}
public class Main {
    private static double cost;
    private static int doors;
    private static int windows;
    public Main(int doors, int windows, double cost) {
        this.cost = cost;
        this.doors = doors;
        this.windows = windows;
    }
    public static double room(double height, double width, double length) {
        return (2 * height * width) + (2 * height * length) + (1 * length * width);
    }
    public static double door(double width, double height) {
        return height * width;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome! What is your cost(in GBP) per litre: ");
        int cost = s.nextInt();
        System.out.println("How many Doors: ");
        int doors = s.nextInt();
        if(doors <= 0){
            System.out.println("You need a door to enter. Give new number: ");
            doors = s.nextInt();
        }
        System.out.println("Number of Windows: ");
        int windows = s.nextInt();
        if(windows <= 0){
            System.out.println("You need circulation. Give new number: ");
            windows = s.nextInt();
        }
        Main main = new Main(cost, doors, windows);
        //room
        System.out.println("Input room width: ");
        double roomWidth = s.nextDouble();
        System.out.println("Input room length: ");
        double roomLength = s.nextDouble();
        System.out.println("Input room height: ");
        double roomHeight = s.nextDouble();
        double currentRoom = room(roomHeight, roomWidth, roomLength);
        //door(s)
        System.out.println("Input door width: ");
        double doorWidth = s.nextDouble();
        if(roomWidth <= doorWidth || doorWidth < 0){
            System.out.println("Invalid width");
            doorWidth = s.nextDouble();
        }
        System.out.println("Input door height: ");
        double doorHeight = s.nextDouble();
        if(roomHeight <= doorHeight || doorHeight < 0){
            System.out.println("Invalid height");
            doorHeight = s.nextDouble();
        }
        double doorArea = doors * door(doorWidth, doorHeight);
        //window(s)
        double windowArea = 0.0d;
            for(int i = 0; i < windows; i++ ){
                System.out.println("What type of window (Square, Rectangule or Triangular): ");
                String type = s.next();
                Window w = new Window(type);
                System.out.println("Give your first window dimension (Triangle = base)");
                double unit1 = s.nextDouble();
                if(roomHeight <= unit1 || roomWidth <= unit1 || unit1 < 0){
                    System.out.println("Invalid size");
                    unit1 = s.nextDouble();
                }
                System.out.println("Give your second window dimension (Triangle = height)");
                double unit2 = s.nextDouble();
                if(roomHeight <= unit2 || roomWidth <= unit2 || unit2 < 0){
                    System.out.println("Invalid size");
                    unit2 = s.nextDouble();
                }
                windowArea += w.area(unit1, unit2);
            }
        //Answer
        System.out.println("You need £"+cost * (currentRoom - doorArea - windowArea));
    }
}