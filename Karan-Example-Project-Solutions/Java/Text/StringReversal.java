import java.util.Scanner;

public class StringReversal {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter string to be reversed: ");
    String user = input.nextLine();

    System.out.println(reverse(user));
  }

  private static String reverse(String user) {
    String out = "";
    for (int i = user.length() - 1; i >= 0; i--) {
      out = out + user.charAt(i);
    }
    return out;
  }
}
