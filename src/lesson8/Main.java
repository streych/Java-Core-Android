package lesson8;
/*
Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
Создайте два класса: беговая дорожка и стена, при прохождении через которые,
участники должны выполнять соответствующие действия (бежать или прыгать),
результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
* У препятствий есть длина (для дорожки) или высота (для стены),
а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий,
то дальше по списку он препятствий не идет.
 */

public class Main {
    public static void main(String[] args) {
        RunGo cat = new Cat("Мурзик");
        RunGo human = new Human("Бобби");
        RunGo robot = new Robot("Робо");

        RunGo[] mains = {cat, human, robot};

        RunGo wall1 = new Wall();
        RunGo wall2 = new Wall();
        RunGo threadMill1 = new ThreadMill();
        RunGo threadMill2 = new ThreadMill();

        RunGo[] hurdles = {wall1, wall2, threadMill1, threadMill2};

        for (RunGo hurdle : hurdles) {
            for (RunGo m : mains) {
                m.run();
                m.go();
                hurdle.go();
                hurdle.run();
            }
        }
    }
}
