import java.util.Scanner;

public class NextPrimeNumber {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Find prime? y/n: ");
    char in = input.next().charAt(0);
    boolean state = false;

    System.out.println(in);
    if (in == 'y') {
      state = true;
    } else {
      state = false;
    }

    int count = 2;
    while (state) {
      if (isPrime(count)) {
        System.out.print("Next Prime is " + count);
        System.out.print(". Find another prime? y/n: ");
        in = input.next().charAt(0);
        if (in == 'n') {
          state = false;
        }
      }
      count++;
    }
  }

  private static boolean isPrime(int n) {
    int remain;
    for (int i = 2; i <= n / 2; i++) {
      remain = n % i;
      if (remain == 0) {
        return false;
      }
    }
    return true;
  }
}
