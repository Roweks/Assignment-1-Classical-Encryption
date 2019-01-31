package Assignment1;

import java.io.PrintWriter;

public class CaesarCipher {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    // Check inputs for correctness and to run methods
    if (args.length != 2)
      pen.println("Incorrect number of parameters");
    else {
      String command = args[0];
      if (command.equals("encode"))
        encode(args[1]);
      else if (command.equals("decode"))
        decode(args[1]);
      else
        pen.println("Valid options are \"encode\" or \"decode\"");
    } // else
  } // main

  // Method to encrypt an input
  public static void encode(String str) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    // Encrypt for each letter
    for (int i = 0; i < 26; i++) {
      String newStr = new String("");
      // Encrypt each letter of the string
      for (int j = 0; j < (str.length()); j++) {
        int num = (int) str.charAt(j);
        num -= 97;
        num = (num + i) % 26;
        num = num + 97;
        char ch = (char) num;
        newStr += ch;
      } // inner for
      pen.println("n = " + i + ": " + newStr);
    } // outer for
    pen.flush();
  } // method encode

  // Method to decrypt string
  public static void decode(String str) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    // Decrypt for every letter
    for (int i = 0; i < 26; i++) {
      String newStr = new String("");
      // Decrypt each character
      for (int j = 0; j < (str.length()); j++) {
        int num = (int) str.charAt(j);
        num -= 97 + i;
        if (num > 0) {
          num = num % 26;
        } else if (num < 0) {
          num = 26 + num;
        }
        num = num + 97;
        char ch = (char) num;
        newStr += ch;
      } // inner for
      pen.println("n = " + i + ": " + newStr);
    } // outer for
    pen.flush();
  } // decode
}
