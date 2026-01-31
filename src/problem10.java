//Сумма простых чисел меньше 10 равна 2 + 3 + 5 + 7 = 17.
//Найдите сумму всех простых чисел меньше двух миллионов.

public class problem10 {
    public static void main(String[] args) {
        long sum = 2;
        boolean isTrue = true;
        for (long number = 3; number < 2000000L; number += 2) {
            isTrue = true;
            for(long devider = 3; devider <= Math.sqrt(number) + 1; devider +=2) {
                if (number % devider == 0) {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue){
                sum += number;
            }
        }
        System.out.println(sum);
    }
}
