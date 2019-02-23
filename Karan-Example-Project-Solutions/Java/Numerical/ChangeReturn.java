import java.util.Scanner;
import java.lang.Math;

public class ChangeReturn {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("What is the cost of the item: ");
    double cost = input.nextDouble();
    System.out.println("What is the amount paid with: ");
    double given = input.nextDouble();

    if (cost > given) {
      System.out.println("Not enough money given!");
    } else if (cost == given) {
      System.out.println("Exact change given!");
    } else {
      change(given - cost);
    }

    input.close();
  }

  private static void change(double n) {
    int total = (int)(n * 100);

    int quarters = 0;
    int dimes = 0;
    int nickels = 0;
    int pennies = 0;

    while (total >= 5) {
      if (total - 25 >= 0) {
        quarters++;
        total -= 25;
      } else if (total - 10 >= 0) {
        dimes++;
        total -= 10;
      } else if (total - 5 >= 0) {
        nickels++;
        total -= 5;
      }
    }
    pennies = total;
    System.out.println(quarters + " Quarters, " + dimes + " Dimes, "
                        + nickels + " Nickels, " + pennies + " Pennies. Total: $"
                         + Math.floor(n * 100) / 100);
  }

}
