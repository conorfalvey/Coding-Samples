import java.util.Scanner;
import java.lang.Math;

public class EToNDigits {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("How many digits? ");
    int n = input.nextInt();

    if (n > 16) {
      System.out.println("Java.lang.Math.E is only accurate up to 16 digits");
      System.exit(0);
    }
    System.out.println("E to " + n + " digits is " + eToNDigits(n));
  }

  private static double eToNDigits(int n) {
    if (n == 0) { return 0; }
    return Double.parseDouble(Double.toString(Math.E).substring(0, n + 1));
  }
}
