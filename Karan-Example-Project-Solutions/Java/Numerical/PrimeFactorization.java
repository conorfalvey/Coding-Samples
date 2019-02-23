import java.util.Scanner;
import java.lang.Math;

public class PrimeFactorization {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Which number would you like to factor? ");
    int n = input.nextInt();

    factor(n);
    System.out.println();
  }

  private static void factor(int n) {

    while (n % 2 == 0) {
      System.out.print(2 + " ");
      n = n / 2;
    }

    for (int i = 3; i < Math.sqrt(n); i += 2) {
      while (n % i == 0) {
        System.out.print(i + " ");
        n = n / i;
      }
    }

    if (n > 2) {
      System.out.print(n);
    }
  }
}
