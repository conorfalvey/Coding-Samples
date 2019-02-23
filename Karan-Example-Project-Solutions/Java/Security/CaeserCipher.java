import java.util.Scanner;

public class CaeserCipher {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter Phrase to encode: ");
    String user = input.nextLine();
    System.out.println("Enter offset: ");
    int offset = input.nextInt();

    String out = "";
    char c = 'a';
    for (int i = 0; i < user.length(); i++) {
      if (Character.isUpperCase(user.charAt(i))) {
        c = (char)(((int)user.charAt(i) + offset - 65) % 26 + 65);
      } else if (Character.isLowerCase(user.charAt(i))) {
        c = (char)(((int)user.charAt(i) + offset - 97) % 26 + 97);
      }
      out += c;
    }

    System.out.println(out);
  }
}
