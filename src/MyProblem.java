import java.time.LocalDate;
import java.util.Scanner;

interface Feedable {
    public void receiveFeed();
}
interface openAccessExtension {
    public void receiveAccessExtension();
}
interface ableToCastration {
    public void receiveCastration();
}


public class MyProblem {

    public static void main(String[] args) {

    Manager manager = new Manager();
    Scanner scanner = new Scanner(System.in);
    SuperClass[] animals = new SuperClass[2];

    while (true) {
        if (isFull(animals)) {
            animals = adSpace(animals);
        }
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                System.out.printf(" %s[    ]", i + 1);
            } else {
                System.out.print(" " + (i + 1) + animals[i].getAllFilds());
            }
        }
        System.out.println();
        System.out.println("Введите команду: a = Create, b = Read, c = Update, d = Delete, e = Вызвать автоуход");
        String command2 = scanner.nextLine();
        switch (command2) {
            case "a":
                manager.create(animals, scanner);
                break;
            case "b":
                manager.read(animals, scanner);
                break;
            case "c":
                manager.update(animals, scanner);
                break;
            case "d":
                manager.deleate(animals, scanner);
                break;
            case "e":
                SuperClass.autoCare(animals);
                break;
        }
    }


}

public static boolean isFull(SuperClass[] animals) {
    for (SuperClass m : animals) {
        if (m == null) return false;
    }
    return true;
}

public static SuperClass[] adSpace(SuperClass[] animals) {
    SuperClass[] newArray = new SuperClass[animals.length * 2];
    for (int i = 0; i < animals.length; i++) {
        newArray[i] = animals[i];
    }
    return newArray;
}
}
class Manager {

    public void create(SuperClass[] animals, Scanner scanner) {
            for (int i = 0; i < animals.length; i++) {
                if (animals[i] == null) {
                    System.out.println("Введите имя:");
                    String name = scanner.nextLine();
                    System.out.println("Введите возраст:");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Тип животного: a = Monkey, b = Lion, c = enguin, d = Cat");
                    String command = scanner.nextLine();
                    switch (command) {
                        case "a":
                            animals[i] = new Monkey(name, age);
                            System.out.println("Создан Monkey");
                            break;
                        case "b":
                            animals[i] = new Lion(name, age);
                            System.out.println("Создан Lion");
                            break;
                        case "c":
                            animals[i] = new Penguin(name, age);
                            System.out.println("Создан Penguin");
                            break;
                        case "d":
                            animals[i] = new Cat(name, age);
                            System.out.println("Создан Cat");
                            break;
                    }
                    return;
                }
            }
        }


        public void read(SuperClass[] animals,Scanner scanner) {

            System.out.println("Введите номер животного");
            int i = scanner.nextInt() - 1;
            scanner.nextLine();
            if (animals[i] == null) {
                System.out.println("Нет");
            } else {
                System.out.println(animals[i].getAllFilds());
            }
        }

        public void update(SuperClass[] animals,Scanner scanner) {
            System.out.println("Введите номер Для редактирования");
            int j = scanner.nextInt() - 1;
            scanner.nextLine();
            System.out.println("Введите комманду для редактирования: a = Имя, b = Возраст, c = Дата прибытия");
            String command2 = scanner.nextLine();
            switch (command2) {
                case "a": // Изменить имя
                    System.out.println("Введите новое имя");
                    String name = scanner.nextLine();
                    animals[j].setName(name);
                    break;
                case "b": // Изменить возраст
                    System.out.println("Введите новый Возраст");
                    int age = scanner.nextInt();
                    animals[j].setAge(age);
                    break;
                case "c": case "с":
                    System.out.println("Введите новое время прибытия: yyyy [ENTER] mm [ENTER] dd [ENTER]");
                    int yyyy = scanner.nextInt();
                    int mm = scanner.nextInt();
                    int dd = scanner.nextInt();
                    animals[j].setTime(yyyy, mm, dd);
                    break;
            }
        }

        public void deleate(SuperClass[] animals,Scanner scanner) {
            System.out.println("Выберите номер для удаления");
            int k = scanner.nextInt() - 1;
            scanner.nextLine();
            animals[k] = null;
        }
    }
class SuperClass { // Общие данные и методы животных должны быть вынесены в отдельный родительский класс (суперкласс).
    
    private String name;
    private int age;
    private LocalDate dateOfArrival;
    private static Long countId = 1L;
    private Long id;

    public SuperClass(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = countId++;
        this.dateOfArrival = LocalDate.now();// затычка
    }

    void setName(String name) {
        this.name = name;
    }

    void setAge(int age) {
        this.age = age;
    }

    public String getAllFilds() {
        return String.format("[ Возраст:%d Имя:%s Дата прибытия:%s ID: %d]", this.age, this.name, this.dateOfArrival, this.id);
    }

    void setTime(int yyyy, int mm, int dd) {
        this.dateOfArrival = LocalDate.of(yyyy, mm, dd);
    }
    public static void autoCare(SuperClass[] animals) {
        for (SuperClass animal : animals) {
            if (animal != null) {
                animal.carCare();
            }
        }
    }
    public void carCare() {

    }

}

class Monkey extends SuperClass{
    
    public Monkey(String name, int age) {
        super(name, age);
    }

    public void carCare() {
        // вызов метода автоухода
    }


}

class Lion extends SuperClass implements openAccessExtension {

    boolean isIll;

    public Lion(String name, int age) {
        super(name, age);
    }

    public void carCare() {
        receiveAccessExtension();
    }

    public void receiveAccessExtension(){
        // Открыть доступ льву
    }
}

class Penguin extends SuperClass implements ableToCastration, Feedable {

    LocalDate dateOfBearth;

    public Penguin(String name, int age) {
        super(name, age);
    }

    public void carCare() {
        receiveCastration();
        receiveFeed();
    }

    public void receiveCastration(){
        //
    }
    public void receiveFeed(){
        //
    }
}

class Cat extends SuperClass{

    public Cat(String name, int age) {
        super(name, age);
    }

    public void carCare() {
    }
}