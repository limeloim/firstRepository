public class problem6 {
    public static void main(String[] args) {
        long sumOfSquares = 0;
        long sum = 0;
        for (int i = 1; i <= 100; i++) {
            sumOfSquares += i * i;
            sum += i;
        }
        long squareOfSum = sum * sum;
        long difference = squareOfSum - sumOfSquares;
        System.out.println("Разность: " + difference);
    }

}
