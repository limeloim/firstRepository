public class problem5 {
    public static void main(String[] args) {
        for (int number = 2; number <= 20; number++) {
            for (int i = 2; i < number - 1; i++) {
                if (number % i == 0) {

                } else {
                    System.out.println(number);
                }

            }
        }
    }
}
