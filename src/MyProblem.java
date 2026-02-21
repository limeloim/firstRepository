import java.time.LocalDate; // разделить на операции функции main
import java.util.Scanner;

public class MyProblem {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        Monkey[] monkeys = new Monkey[2];
        while (true) {
            if (isFull(monkeys)) {
                monkeys = adSpace(monkeys);
            }
            for (int i = 0; i < monkeys.length; i++) {
                if (monkeys[i] == null) {
                    System.out.printf(" %s[    ]", i + 1);
                } else {
                    System.out.print(" " + (i + 1) + monkeys[i].toString());
                }
            }
            System.out.println();
            System.out.println("Введите команду: a = Create, b = Read, c = Update, d = Delete");
            String command = scanner.nextLine();
            String name = "null";
            switch (command) {
                case "a":
                    manager.create(monkeys, scanner);
                    break;
                case "b":
                    manager.read(monkeys, scanner);
                    break;
                case "c":
                    manager.update(monkeys, scanner);
                    break;
                case "d":
                    manager.deleate(monkeys, scanner);
                    break;
            }
        }
    }
    public static boolean isFull(Monkey[] monkeys) {
        for (Monkey m : monkeys) {
            if (m == null) return false; // есть свободное место
        }
        return true; // все места заняты
    }

    public static Monkey[] adSpace(Monkey[] monkeys) {
        Monkey[] newArray = new Monkey[monkeys.length * 2];
        for (int i = 0; i < monkeys.length; i++) {
            newArray[i] = monkeys[i];
        }
        return newArray;
    }
}


class Manager {

     public void create(Monkey[] monkeys, Scanner scanner) {
         for (int i = 0; i < monkeys.length; i++) {
             if (monkeys[i] == null) {
                 System.out.println("Введите имя:");
                 String name = scanner.nextLine();

                 System.out.println("Введите возраст:");
                 int age = scanner.nextInt();
                 scanner.nextLine();
                 monkeys[i] = new Monkey(name, age);
                 System.out.println("Обезьяна создана!");
                 return;
             }
         }
     }


    public void read(Monkey[] monkeys,Scanner scanner) {
        System.out.println("Введите номер обезьяны");
        int i = scanner.nextInt() - 1;
        scanner.nextLine();
        if (monkeys[i] == null) {
            System.out.println("Нет");
        } else {
            System.out.println(monkeys[i].getAllFilds());
        }
    }

    public void update(Monkey[] monkeys,Scanner scanner) {
        System.out.println("Введите номер Для редактирования");
        int j = scanner.nextInt() - 1;
        scanner.nextLine();
        System.out.println("Введите комманду для редактирования: a = Имя, b = Возраст, c = Дата прибытия");
        String command2 = scanner.nextLine();
        switch (command2) {
            case "a": // Изменить имя
                System.out.println("Введите новое имя");
                String name = scanner.nextLine();
                monkeys[j].setName(name);
                break;
            case "b": // Изменить возраст
                System.out.println("Введите новый Возраст");
                int age = scanner.nextInt();
                monkeys[j].setAge(age);
                break;
            case "c": case "с":
                System.out.println("Введите новое время прибытия: yyyy [ENTER] mm [ENTER] dd [ENTER]");
                int yyyy = scanner.nextInt();
                int mm = scanner.nextInt();
                int dd = scanner.nextInt();
                monkeys[j].setTime(yyyy, mm, dd);
                break;
        }
    }
    public void deleate(Monkey[] monkeys,Scanner scanner) {
        System.out.println("Выберите номер для удаления");
        int k = scanner.nextInt() - 1;
        scanner.nextLine();
        monkeys[k] = null;
    }
}


class Monkey {

    private String name;
    private int age;
    private LocalDate dateOfArrival;

    public Monkey(String name,int age) { //конструктор
        if (name.isEmpty()){
            System.out.println("Вы ввели пустое имя Установлено стандартное имя ( name = null )");
            this.name = "null";
        } else {
            this.name = name;
        }
        if (age < 0){
            System.out.println("Вы ввели ( age < 0 ) Установден стандартный ( age = 0 ) )");
            this.age = 0;
        } else {
            this.age = age;
        }
        dateOfArrival = LocalDate.now();
    }

    public String getAllFilds(){
        return String.format("[ Возраст:%d Имя:%s Дата прибытия:%s ]", this.age, this.name, this.dateOfArrival);

    }

    void setName(String name) {
        this.name = name;
    }

    void setAge(int age) {
        this.age = age;
    }

    void setTime(int yyyy, int mm, int dd) {
        this.dateOfArrival = LocalDate.of(yyyy, mm, dd);
    }

    public String toString (){
        return String.format ("[ Возраст:%d Имя:%s Дата прибытия:%s ]", this.age, this.name, this.dateOfArrival); // переделать
    }
}
