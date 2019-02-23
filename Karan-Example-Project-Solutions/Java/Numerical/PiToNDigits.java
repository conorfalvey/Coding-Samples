import java.util.Scanner;
import java.lang.Math;

public class PiToNDigits {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("How many digits? ");
    int n = input.nextInt();

    if (n > 16) {
      System.out.println("Java.lang.Math.PI is only accurate up to 16 digits");
      System.exit(0);
    }
    System.out.println("Pi to " + n + " digits is " + piToNDigits(n));
  }

  private static double piToNDigits(int n) {
    if (n == 0) { return 0; }
    return Double.parseDouble(Double.toString(Math.PI).substring(0, n + 1));
  }
}
