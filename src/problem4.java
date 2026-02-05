public class problem4 {
    public static void main(String[] args) {
        int max = 0;
        for (int i = 1; i <= 999; i++) {
            for (int j = 1; j <= 999; j++) {
                int mult = i * j;
                String result = new StringBuilder(String.valueOf(mult)).reverse().toString();
                if (String.valueOf(mult).equals(result)) {
                    max = Math.max(max, mult);
                }
            }
        }
        System.out.println(max);
    }
}
// Выдает 906609