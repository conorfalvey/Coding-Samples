import java.util.Scanner;

public class FloorTiling {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("What is the width of the area to tile: ");
    int width = input.nextInt();
    System.out.println("What is the length of the area to tile: ");
    int length = input.nextInt();
    System.out.println("What is the square footage cost: ");
    int cost = input.nextInt();
    int total = width * length * cost;

    input.close();

    System.out.println("The total cost to tile a floor with dimensions " + width + "x" + length
                        + " with cost $" + cost + " per square foot is $" + total);
  }
}
