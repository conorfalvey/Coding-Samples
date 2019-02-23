import java.util.Scanner;

public class TaxCalculator {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter pre-tax total: ");
    double price = input.nextDouble();
    System.out.println("Enter tax rate: ");
    double tax = input.nextDouble();

    System.out.println("Post-tax price is $" + price * (1 + tax));

    input.close();
  }
}
