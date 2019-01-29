package Assignment1;

import java.io.PrintWriter;
public class CaesarCipher {
    public static void main(String[] args) throws Exception {
        encode("Helloworld");
        decode("dahhksknhz");
    }
    public static void encode(String str) throws Exception {
        PrintWriter pen = new PrintWriter(System.out, true);
        for (int i = 0; i < 26;i++) {
            String newStr = new String("");
            for (int j = 0; j < (str.length()); j++) {
                int num = (int)str.charAt(j);
                if (num >= 97) {
                    num -= 97;
                    num = (num + i)%26;
                    num = num +97;
                }
                else if (num >= 65) {
                    num -= 65;
                    num = (num + i)%26;
                    num = num + 65;
                }
                char ch = (char)num;
                newStr += ch;
            }
            pen.println("n = " + i + ": " + newStr);
        }
        pen.flush();
    }
    public static void decode(String str) throws Exception {
        PrintWriter pen = new PrintWriter(System.out, true);
        for (int i = 0; i < 26;i ++) {
             String newStr = new String("");
            for (int j = 0; j < (str.length()); j++) {
                int num = (int)str.charAt(j);
                if (num >= 97) {
                    num -= 97 + i;
                    if (num > 0) {
                        num = num%26;}
                    else if (num < 0) {
                        num = 26 + num;}
                    num = num + 97;
                }
                else if (num >= 65) {
                    num -= 65 + i;
                    if (num > 0) {
                        num = num%26;}
                    else if (num < 0) {
                        num = 26 + num;}
                    num = num + 65;
                }
                char ch = (char)num;
                newStr += ch;
            }
            pen.println("n = " + i + ": " + newStr);
        }
        pen.flush();
    }           
}
