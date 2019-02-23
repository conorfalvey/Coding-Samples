import java.util.Scanner;
import java.lang.Math;

public class MortgageCalculator {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter the interest rate: ");
    double interest = input.nextDouble();
    System.out.println("What is the loan's term in months: ");
    int months = input.nextInt();
    System.out.println("What is the amount initially borrowed: ");
    double principal = input.nextDouble();

    input.close();

    System.out.println("Monthy payment of $" + principal + " loan over "
                        + months + " months at " + (interest * 100) + "% is "
                        + paymentCalc(interest, months, principal));
  }

  private static double paymentCalc(double interest, int months, double principal) {
    if (interest <= 0) {
      return principal / months;
    } else {
      return (interest * principal * Math.pow(1 + interest, months))/(Math.pow(1 + interest, months) - 1);
    }
  }

}
