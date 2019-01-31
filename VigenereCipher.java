package Assignment1;

import java.io.PrintWriter;

public class VigenereCipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    // Check inputs for correctness and method choice
    if (args.length != 3)
      pen.println("Incorrect number of parameters");
    else {
      String command = args[0];
      if (command.equals("encode"))
        encode(args[1], args[2]);
      else if (command.equals("decode"))
        decode(args[1], args[2]);
      else
        pen.println("Valid options are \"encode\" or \"decode\"");
    } // else
  } // main

  // Method to encrypt string with given key
  public static void encode(String str, String key) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String newStr = new String("");
    // Iterate through the string
    for (int i = 0; i < str.length(); i++) {
      int num = (int) str.charAt(i);
      int numKey = (int) key.charAt(i % key.length());
      num -= 97;
      numKey -= 97;
      num = (num + numKey) % 26;
      num = num + 97;
      char ch = (char) num;
      newStr += ch;
    }
    pen.println(newStr);
  } // method encode

  // Method to decrypt a string with a given key
  public static void decode(String str, String key) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String newStr = new String("");
    // Iterate through the string
    for (int i = 0; i < str.length(); i++) {
      int num = (int) str.charAt(i);
      int numKey = (int) key.charAt(i % key.length());
      num -= numKey;
      if (num > 0) {
        num = num % 26;
      } else if (num < 0) {
        num = 26 + num;
      }
      num = num + 97;
      char ch = (char) num;
      newStr += ch;
    }
    pen.println(newStr);
  } // method decode
}
