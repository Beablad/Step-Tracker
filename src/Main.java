import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            System.out.println(command);
            if (command==1) {
                System.out.println("За какой месяц нужно ввести шаги?");
                printNamesOfMonth();
                int month = scanner.nextInt();
                System.out.println("За какой день?");
                int day = scanner.nextInt();
                System.out.println("Введите колчество шагов");
                int steps = scanner.nextInt();
                if (steps >= 0) {
                    stepTracker.addDataToMap(month, --day, steps);
                }
            } else if (command == 2){
                System.out.println("Введите месяц, за который нужна статистика");
                printNamesOfMonth();
                int month = scanner.nextInt();
                stepTracker.printStats(month);
                System.out.println("Суммарно было пройдено: " + stepTracker.sumOfStepsByMonth(month)+ " шагов.");//кол-во шагов за месяц
                System.out.println("Максимальное количество шагов за месяц: "+stepTracker.maxStepsPerMonth(month));//максимальное кол-во шагов
                System.out.println("Среднее количество шагов за месяц: "+ stepTracker.avgStepsByMonth(month));//среднее кол-во
                System.out.println("Пройденная дистанция " + converter.trackerOfDist(stepTracker.sumOfStepsByMonth(month)));//пройденная дистанция
                System.out.println("Всего было потрачено килокалорий: " + converter.trackerOfKkal(stepTracker.sumOfStepsByMonth(month)));//кол-во каллорий
                System.out.println ("Лучшая серия выполнения цели: " + stepTracker.bestSeriesOfGoal(month));//лучшая серия

            } else  if (command ==3){
                System.out.println("Введите новую цель по количеству шагов");
                stepTracker.goalOfSteps = scanner.nextInt();
            }
            else if (command==4){
                break;
            } else {
                System.out.println("Такой команды еще нет.");
            }
        }
    }

        public static void printNamesOfMonth(){

            System.out.println("1-Январь");
            System.out.println("2-Февраль");
            System.out.println("3-Март");
            System.out.println("4-Февраль");
            System.out.println("5-Май");
            System.out.println("6-Июнь");
            System.out.println("7-Июль");
            System.out.println("8-Август");
            System.out.println("9-Сентябрь");
            System.out.println("10-Октябрь");
            System.out.println("11-Ноябрь");
            System.out.println("12-Декабрь");
        }

    public static void printMenu(){
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
        System.out.println("Что нужно сделать?");
    }
}

