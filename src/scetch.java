public class scetch {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 1;
        for (a = 1; a + b + c <= 1000; a++) {
            for (b = 1; a + b + c <= 1000; b++) {
                for (c = 1; a + b + c <= 1000; c++) {
                    if (a*a + b*b == c*c) {
                        int abc = a * b * c;
                        System.out.println(String.format("произведение abc %s", abc));
                    }
                }
            }
        }
    }
}
// 2 условие a + b + c == 1000 можно убрать и изменить for и убрать c
