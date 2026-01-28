
public class problem9 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 1;
        for (a = 1; a <= 1000; a++) {
            for (b = a + 1; b  <= 1000; b++) {
                c = 1000 - (a + b);
                if (a*a + b*b == c*c) {
                    int abc = a * b * c;
                    System.out.println(String.format("произведение abc %s", abc));
                }
            }
        }
    }
}