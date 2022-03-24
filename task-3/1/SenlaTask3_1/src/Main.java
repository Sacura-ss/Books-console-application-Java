/*
* Написать программу выводящую на экран
* 3 случайно сгенерированных трехзначных числа
* и разницу между числом,
* получившимся методом последовательной записи 1-го и 2-го числа,
* и третьим чисом
*/

public class Main {
    public static void main(String[] args) {
        int min = 100;
        int max = 999;
        int diff = max - min;
        Integer num1 = (new java.util.Random()).nextInt(diff + 1) + min;
        Integer num2 = (new java.util.Random()).nextInt(diff + 1) + min;
        Integer num3 = (new java.util.Random()).nextInt(diff + 1) + min;
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println("Different between number1+number2 and number3 is "
                + (Integer.valueOf(num1 + num2.toString()) - num3));
    }
}
