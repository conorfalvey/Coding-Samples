import java.util.Scanner;

public class CountVowels {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter word/sentence to count: ");
    String user = input.nextLine();

    user = user.replaceAll("[^aeiouAEIOU]", "");
    System.out.println("There are " + user.length() + " vowels");
  }
}
