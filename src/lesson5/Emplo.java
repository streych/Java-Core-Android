package lesson5;

public class Emplo {

    //region task
/*
Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
Создать массив из 5 сотрудников.
Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);
С помощью цикла вывести информацию только о сотрудниках старше 40 лет.

 */
//endregion

    //region Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    public    String fio;
    public   String position;
    public   String mail;
    public   String phone; //может начинаться с +
    public   int salary;
    public   int age;
    public static Emplo[] abc = new Emplo[5];


    //endregion
    public Emplo(String fio, String position, String mail, String phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.mail = mail;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    //region Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    public void print()
    {
        System.out.println("ФИО: " + fio + "Должность: " + position + "Почта: " + mail + "Телефон: " + phone + "ЗП: " + salary + " Возраст: " + age);
    }
    //endregion

    public static void main(String[] args) {

        //region Создать массив из 5 сотрудников.
        //Создать массив из 5 сотрудников.
        abc[0] = new Emplo("Петров А.А ", "РОП ", "1@mail.ru ","+7 000 000 0000 ", 70000, 45);
        abc[1] = new Emplo("Иванов А.А ", "Сервис менеджер ", "2@mail.ru ","+7 000 000 0001 ", 60000, 40);
        abc[2] = new Emplo("Пупкин А.Г ", "Торговый ", "3@mail.ru ","+7 000 000 0002 ", 50000, 34);
        abc[3] = new Emplo("Кополов А.А ", "Бухгалтер ", "4@mail.ru ","+7 000 000 0003 ", 40000, 29);
        abc[4] = new Emplo("Кузнецов А.П ", "Разнорабочий ", "5@mail.ru ","+7 000 000 0004 ", 30000, 26);
        //endregion

        //С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        for (Emplo employeers : abc) {
            if (employeers.age >= 40) {
                employeers.print();
            }
        }
    }
}
