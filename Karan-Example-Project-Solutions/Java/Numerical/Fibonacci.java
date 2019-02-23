import java.util.Scanner;

public class Fibonacci {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter number of terms: ");
    int n = input.nextInt();
    System.out.println("Fibonacci Sequence up to " + n + " terms:");

    System.out.print(0);
    for (int i = 1; i <= n; i++) {
      System.out.print(", " + fibonacci(i));
    }
    System.out.println();
  }

  private static int fibonacci(int n) {
    if (n <= 1) {
      return n;
    }
    return fibonacci(n-1) + fibonacci(n-2);
  }
}
