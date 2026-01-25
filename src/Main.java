//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Введи длину шифра");
        int length = scanner.nextInt();
            int[] cipher= new int[length];
        for (int i = 0; i < length; i++){
            System.out.println("Введи " + (i+1) + " ую цифру");
            int x = scanner.nextInt();
            cipher[i] = x;
        }
            System.out.println(Arrays.toString(cipher));
        for (int i = length - 1; i >= 0; i--){
            if (cipher[i]%2 == 0) {
                System.out.print("-");
            } else {
                System.out.print(".");
            }
        }
    }
}
