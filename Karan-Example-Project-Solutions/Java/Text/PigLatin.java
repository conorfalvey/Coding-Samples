import java.util.Scanner;
import java.util.Arrays;

public class PigLatin {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter word to convert: ");
    String in = input.nextLine();

    in = in.replaceAll("[^a-z\\sA-Z]","");

    System.out.println(convert(in));
  }

  private static String convert(String in) {
    String[] array = in.split(" ");

    for (int i = 0; i < array.length; i++) {
      if ("AEIOUaeiou".indexOf(array[i].charAt(0)) < 0) {
        array[i] = array[i].substring(1) + array[i].charAt(0) + "ay";
      } else {
        array[i] += "yay";
      }
    }

    return Arrays.toString(array);
  }
}
