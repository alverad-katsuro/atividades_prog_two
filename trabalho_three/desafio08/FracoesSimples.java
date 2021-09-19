import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Collections;
 public class FracoesSimples {
    public static int mdc(int n1, int n2) {
      Set<Integer> a1 = new HashSet<>();
      Set<Integer> a2 = new HashSet<>();
      for (int i = 2; i <= n1; i++) {
        if ((n1%i) == 0) {
          a1.add(i);
        }
      }
      for (int j = 2; j <= n2; j++) {
        if ((n2%j) == 0) {
          a2.add(j);
        }
      }
      try {
        a1.retainAll(a2);
        int mdc = Collections.max(a1);
        return mdc;
      }
      catch (NoSuchElementException e) {
        return -1;
      }

    }
    public static void main(String[] args) throws IOException {
        String fileName = "frac.txt"; //se der erro prestar atencao no path
        File file = new File(fileName);   
        byte[] fileContent = Files.readAllBytes(file.toPath());
        String expression = "";
        String expression2 = "";
        int n1 = 0;
        int n2 = 1;
        boolean o1 = false;
        for(byte b : fileContent) {
          char singleChar = (char) b;
          if (((int) singleChar) == 10) {
            for (int a = 0; a < expression.length(); a++) {
              if (((int) expression.charAt(a)) == 47) {
                n1 = Integer.parseInt(expression2);
                expression2 = "";
                o1 = true;
                continue;
              }
              expression2 += expression.charAt(a);
              if (a == (expression.length() - 1)) {
                if (o1 == false) {
                  n1 = Integer.parseInt(expression2);
                  n2 = 1;
                  expression2 = "";
                }
                else {
                  n2 = Integer.parseInt(expression2);
                  expression2 = "";
                }
              }
            }
            if ((n1 == n2) || (n2 == 1)) {
              o1 = false;
            }
            if (o1 == true) {
              try {
                if ((n1/n2) != 0) {
                  System.out.printf("%d %d/%d%n", (n1/n2), (n1%n2), n2);
                }
                else {
                  int this_mdc = mdc(n1, n2);
                  if (this_mdc != -1) {
                    System.out.printf("%d/%d%n", n1/this_mdc, n2/this_mdc);
                  }
                  else {
                    System.out.printf("%d/%d%n", n1, n2);
                  }
                }
                o1 = false;
              }
              catch (ArithmeticException e) {
                System.out.println("ERR");

              }

            }
            else {
              System.out.printf("%d%n", (n1/n2));
            }
            expression = "";
            continue;
          }
          expression += singleChar;
          //System.out.print(singleChar);
        }
    }
}
