package hw.hw5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

/*
 * Реализуйте структуру телефонной книги с помощью HashMap, 
 * учитывая, что 1 человек может иметь несколько телефонов.
 */
public class task1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // создаем цикл для основного метода
        boolean bool = true;
        HashMap<String, ArrayList<Integer>> db = new HashMap<>();
        while (bool == true) {
            String StartEnd = readString(scanner, "Введи: \n1 - для начала/продолжения работы\n0 - для завершения программы\n: ");
            if (StartEnd.equals("0")) {
                System.out.println("bye");
                bool = false;
            } else {
                // метод считывает имя
                String Name = readString(scanner, "input name: ");
                // метод считывает телефон
                int Number = readInt(scanner, "input phone num: ");

                addNumber(Name, Number, db);
                //метод печатает список контактов
                printPhoneBook(db);
            }
        }
        scanner.close();
    }
    
    //метод печатает список контактов
    private static void printPhoneBook(HashMap<String, ArrayList<Integer>> hm) {
        for (var item : hm.entrySet()) {
            String phones = "";
            for (int elem : item.getValue()) {
                phones = phones + elem + ", ";
            }
            System.out.printf("%s: %s \n", item.getKey(), phones);
        }
    }

    //добавляем номера в книгу
    public static void addNumber(String key, int value, HashMap<String, ArrayList<Integer>> hm) {
        if (hm.containsKey(key)) {
            hm.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            hm.put(key, list);
        }
    }

    // читаем name
    private static String readString(Scanner scanner, String message) {
        System.out.print(message);
        String text = scanner.next();
        return text;
    }
    // читаем phone
    private static int readInt(Scanner scanner, String message) {
        System.out.print(message);
        int num = scanner.nextInt();
        return num;
    }

}
