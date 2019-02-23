import java.util.Scanner;

public class Factorial {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter number: ");
    int num = input.nextInt();

    System.out.println(fact(num));

    input.close();
  }

  private static int fact(int num) {
    if (num <= 1) {
      return 1;
    }
    return num * fact(num - 1);
  }
}
