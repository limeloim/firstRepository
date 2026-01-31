public class problem33 {
    public static void main(String[] args) {
        long number = 600851475143L;
        long maxDevider = 0;
        for (long j = 2; j < Math.sqrt(number) + 1; j++) {
            if (number % j == 0) { // Если number поделилось на j То Число является делителем И надо его проверить на  то что оно простое  и сравнить с max
                boolean isTrue;
                for (int i = 0; i < j; i++) {
                    isTrue = false;
                    for (long k = 2; k < Math.sqrt(j) + 1; k++) {
                        if (j % k == 0) {
                            isTrue = true;
                        }
                    }
                    if (isTrue == false) {
                        maxDevider = j;
                    }
                }
            }
        }
        System.out.println(maxDevider);
    }
}

