public class problem2 {
    public static void main(String[] args) {
        int number1 = 0;
        int number2 = 1;
        int sum = 0;
        int i = 0;

        while(i < 4000000) {
            i = number1 + number2;
            number1 = number2;
            number2 = i;
            if (i % 2 == 0) {
                sum += i;
            }
        }

        System.out.println(String.format("Ответ %s", sum));
    }
}

