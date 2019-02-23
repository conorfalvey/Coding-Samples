import java.util.Scanner;
import java.util.Arrays;;

public class BinaryToDecimal {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter number to convert: ");
    String in = input.next();
    int num = Integer.parseInt(in);

    if (isBinary(num)) {
      System.out.println("Binary number " + num + " in decimal is " + binaryToDecimal(num));
    } else {
      System.out.println("Decimal number " + num + " in binary is " + decimalToBinary(num));
    }
  }

  private static int binaryToDecimal(int n) {
    int result = 0;
    int count = 0;
    while (n > 0) {
      if (n % 10 == 1) {
        result += Math.pow(2, count);
      }
      count++;
      n = n / 10;
    }
    return result;
  }

  private static int decimalToBinary(int n) {
    int count = 0;
    int result[] = new int[32];
    int out = 0;
    while (n > 0) {
      result[count] = n % 2;
      n = n / 2;
      count++;
    }
    result = Arrays.copyOfRange(result, 0, count);
    for (int i = result.length - 1; i >= 0; i--) {
      out += Math.pow(10, i) * result[i];
    }
    return out;
  }

  private static boolean isBinary(int n) {
    while (n > 1) {
      if (n % 10 > 1) { return false; }
      n = n / 10;
    }
    return true;
  }
}
