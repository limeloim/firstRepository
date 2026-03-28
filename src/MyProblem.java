import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

interface Feedable {
    public void receiveFeed();
}
interface Accessable {

    public void openAccess();
    public void closeAccess();
}

interface AbleToCastration {
    public void receiveCastration();
}

public class MyProblem {

    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Animal> animals = new ArrayList<>(2);

        while (true) {

            if (animals.isEmpty()) {
                System.out.println("[Список пуст]");
            } else {
                for (Animal exactAnimal : animals) {
                    if (exactAnimal != null) {
                        System.out.print(" [ " + exactAnimal.toString() + " ] ");
                    } else {
                        System.out.print(" [ пусто ] ");
                    }
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
                    manager.delete(animals, scanner);
                    break;
                case "e":
                    Manager.autoCare(animals);
                    break;
            }
        }
    }
}

class Manager {

    public void create(ArrayList<Animal> animals, Scanner scanner) {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите возраст:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Тип животного: a = Monkey, b = Lion, c = Penguin, d = Cat");
        String command = scanner.nextLine();
        switch (command) {
            case "a":
                animals.add(new Monkey(name, age));
                System.out.println("Создан Monkey");
                break;
            case "b":
                Lion lion = new Lion(name, age, scanner);
                System.out.println("Создан Lion");
                System.out.println("болен Lion: Да Нет");
                if (scanner.nextLine().equals("Да")) {
                    lion.setIll(true);
                } else {
                    lion.setIll(false);
                }
                animals.add( lion);
                break;
            case "c":
                animals.add( new Penguin(name, age, scanner));
                System.out.println("Создан Penguin");
                break;
            case "d":
                animals.add( new Cat(name, age));
                System.out.println("Создан Cat");
            break;
        }
    }

    public void read(ArrayList<Animal> animals,Scanner scanner) {

        System.out.println("Введите номер животного");
        int i = scanner.nextInt() - 1;
        scanner.nextLine();
        System.out.println(animals.get(i).toString());
    }

    public void update(ArrayList<Animal> animals,Scanner scanner) {
        System.out.println("Введите номер Для редактирования");
        int j = scanner.nextInt() - 1;
        scanner.nextLine();
        System.out.println("Введите комманду для редактирования: a = Имя, b = Возраст, c = Дата прибытия, d = Обновить болезнь");
        String command2 = scanner.nextLine();
        switch (command2) {
            case "a":
                System.out.println("Введите новое имя");
                String name = scanner.nextLine();
                animals.get(j).setName(name);
                break; 
            case "b":
                System.out.println("Введите новый Возраст");
                int age = scanner.nextInt();
                animals.get(j).setAge(age);
                break; 
            case "c":
                System.out.println("Введите новое время прибытия: yyyy [ENTER] mm [ENTER] dd [ENTER]");
                int yyyy = scanner.nextInt();
                int mm = scanner.nextInt();
                int dd = scanner.nextInt();
                animals.get(j).setDateOfArrival(yyyy, mm, dd);
                break;
            case "d":
                Animal animal = animals.get(j);
                Lion lionLink = (Lion) animal;
                System.out.println("Обновление болезни");
                System.out.println("животное болеет: Да Нет");
                if (scanner.nextLine().equals("Да")) {
                    lionLink.setIll(true);
                } else {
                    lionLink.setIll(false);
                }
                break;

        }
    }

    public static void autoCare(ArrayList<Animal> animals) {
        for (Animal animal : animals) {
            if (animal != null) {
                animal.carCare();
            }
        }
    }

    public void delete(ArrayList<Animal> animals, Scanner scanner) {
        System.out.println("Выберите номер для удаления");
        int k = scanner.nextInt() - 1;
        scanner.nextLine();
        animals.set(k, null);
    }
}

    
class Animal {

    protected String name;
    protected int age;
    protected LocalDate dateOfArrival;
    protected static Long countId = 1L;
    protected Long id;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(LocalDate dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public static Long getCountId() {
        return countId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static void setCountId(Long countId) {
        Animal.countId = countId;
    }

    public Animal(String name, int age) {
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

    @Override
    public String toString() {
        return String.format("[ Возраст:%d Имя:%s Дата прибытия:%s ID: %d]", this.age, this.name, this.dateOfArrival, this.id);

    }

    void setDateOfArrival(int yyyy, int mm, int dd) {
        this.dateOfArrival = LocalDate.of(yyyy, mm, dd);
    }

    public void carCare() {

    }

}

class Monkey extends Animal{
    
    public Monkey(String name, int age) {
        super(name, age);
    }

    public void carCare() {
        //TODO: вызвать метод автоухода
    }
}

class Lion extends Animal implements Accessable {

    private boolean isIll;

    private LocalDate dateOfBirth;

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setIll(boolean isIll) {
        this.isIll = isIll;
    }

    public boolean getIll() {
        return isIll;
    }

    @Override
    public void openAccess(){
        //TODO: открыть доступ льву
    }

    @Override
    public void closeAccess(){
        //TODO: закрыть доступ льву
    }

    @Override
    public String toString() {
        return String.format("[ Возраст:%d Имя:%s Дата прибытия:%s ID: %d Болеет:%s Деньрождения:%s]", this.age, this.name, this.dateOfArrival, this.id, this.isIll, this.dateOfBirth);

    }

    public Lion(String name, int age, Scanner scanner) {

        super(name, age);

        System.out.println("Введите дату рождения (год [Enter] месяц [Enter] день [Enter]):");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        scanner.nextLine();

        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    @Override
    public void carCare() {
        openAccess();
        closeAccess();
    }


    public boolean isIll() {
        return isIll;
    }
}

class Penguin extends Animal implements AbleToCastration, Feedable {

    private LocalDate dateOfBirth;

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Penguin(String name, int age, Scanner scanner) {
        super(name, age);

        System.out.println("Введите дату рождения (год [Enter] месяц [Enter] день [Enter]):");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера после nextInt()

        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    @Override
    public String toString() {
        return String.format("[ Возраст:%d Имя:%s Дата прибытия:%s ID: %d Деньрождения:%s]", this.age, this.name, this.dateOfArrival, this.id, this.dateOfBirth);

    }

    @Override
    public void carCare() {
        receiveCastration();
        receiveFeed();
    }

    @Override
    public void receiveCastration(){
        //TODO: автоматизировать кострацию
    }

    @Override
    public void receiveFeed(){
        //TODO: автоматизировать корм
    }
}

class Cat extends Animal{

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void carCare() {
    }

}