public class problem4 {
    public static void main(String[] args) {
        int max = 0;
        for (int i = 1; i <= 999; i++) {
            for (int j = 1; j <= 999; j++) {
                if (String.valueOf(i * j).equals(new StringBuilder(String.valueOf(i * j)).reverse().toString())) {
                    if (max < i * j) {
                        max = i * j;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
// Выдает 906609