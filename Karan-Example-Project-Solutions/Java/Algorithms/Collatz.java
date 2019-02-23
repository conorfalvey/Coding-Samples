import java.util.Scanner;

public class Collatz {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Choose number to analyze with Collatz Conjecture: ");
    int n = input.nextInt();

    while (n < 2) {
      System.out.println("Must start with number greater than 1! New number: ");
      n = input.nextInt();
    }

    System.out.println("Collatz Conjecture took " + collatz(n) + " steps to reach 1.");
  }

  private static int collatz(int n) {
    int count = 0;
    while (n != 1) {
      if (n % 2 == 0) {
        n = n/2;
      } else {
        n = n * 3 + 1;
      }
      count++;
    }

    return count;
  }
}
