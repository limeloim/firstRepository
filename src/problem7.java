//Выписав первые шесть простых чисел, получим 2, 3, 5, 7, 11 и 13. Очевидно, что 6-е простое число - 13.

//Какое число является 10001-м простым числом?
//Просто преребор и проверка на простоту непойдут?
// пока counter не 10001 Берем число +1 проверяем его на простоту
public class problem7 {
    public static void main(String[] args) {
        long counter = 0;
        boolean isTrue;
        for (long number = 1; counter <= 10001; number++) {
            isTrue = false;
            for (long j = 2; j < Math.sqrt(number) + 1; j++) {
                if (number % j == 0) { // если не поделились на все Хорошо        если поделось на что то Сразу плохо
                    isTrue = true;
                }
            }
            if (isTrue == false) {
                counter += 1;
                if (counter == 10001) {
                    System.out.println(number);
                }
            }
        }
    }
}
