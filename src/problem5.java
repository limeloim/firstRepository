/* 2520 - самое маленькое число, которое делится без остатка на все числа от 1 до 10.
Какое самое маленькое число делится нацело на все числа от 1 до 20? */

public class problem5 {
    public static void main(String[] args) {
        boolean isDivided = false;
        int number = 1;
        for (number = 1; !isDivided; number++) {
            isDivided = true;
            for (int i = 2; i <= 20; i++) {
                if (number % i != 0) {  // если число не делится на i подбирается след число
                    isDivided = false;
                    break;
                }
            }
        }
        if (isDivided) {
            System.out.println(String.format("Искомое число %s", number - 1));
        }
    }
}
