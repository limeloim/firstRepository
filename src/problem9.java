//Тройка Пифагора - три натуральных числа a < b < c, для которых выполняется равенство
//
//a2 + b2 = c2
//
//Существует только одна тройка Пифагора, для которой a + b + c = 1000.
//Найдите произведение abc.

public class problem9 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 1;
        int abc = 0;
        for (; a <= 1000; a++) {
            if (a * a + b * b == c * c && a + b + c == 1000) {
                abc = a * b * c;
            }
            b = 1;
            for (; b <= 1000; b++) {
                if (a * a + b * b == c * c && a + b + c == 1000) {
                    abc = a * b * c;
                }
                c = 1;
                for (; c <= 1000; c++) {
                    if (a * a + b * b == c * c && a + b + c == 1000) {
                        abc = a * b * c;
                    }
                }
            }
        }
        System.out.println(String.format("произведение abc %s", abc));
    }
}
