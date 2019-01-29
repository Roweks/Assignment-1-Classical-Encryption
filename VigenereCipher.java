package Assignment1;

import java.io.PrintWriter;

public class VigenereCipher {
  public static void main(String[] args) {
    encode("helloworld", "cap");
    decode("jeanolqraf", "cap");
  }

  public static void encode(String str, String key) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String newStr = new String("");
    for (int i = 0; i < str.length(); i++) {
      int num = (int) str.charAt(i);
      int numKey = (int) key.charAt(i % key.length());
      if (num >= 97) {
        num -= 97;
        numKey -= 97;
        num = (num + numKey) % 26;
        num = num + 97;
      } else if (num >= 65) {
        num -= 65;
        numKey -= 65;
        num = (num + numKey) % 26;
        num = num + 65;
      }
      char ch = (char) num;
      newStr += ch;
    }
    pen.println(newStr);
  }

  public static void decode(String str, String key) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String newStr = new String("");
    for (int i = 0; i < str.length(); i++) {
      int num = (int) str.charAt(i);
      int numKey = (int) key.charAt(i % key.length());
      if (num >= 97) {
        num -= numKey;
        if (num > 0) {
          num = num % 26;
        } else if (num < 0) {
          num = 26 + num;
        }
        num = num + 97;
      } else if (num >= 65) {
        num -= numKey;
        if (num > 0) {
          num = num % 26;
        } else if (num < 0) {
          num = 26 + num;
        }
        num = num + 65;
      }
      char ch = (char) num;
      newStr += ch;
    }
    pen.println(newStr);
  } // method decode
}
