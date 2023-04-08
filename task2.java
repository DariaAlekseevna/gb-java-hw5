package hw.hw5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
/*
 * Пусть дан список сотрудников: 
 * Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. 
 * Отсортировать по убыванию популярности.
 */
public class task2 {
    public static void main(String[] args) throws Exception {

        ArrayList<String> empl = ReadFile("text1.txt");
        System.out.println(empl);
        HashMap<String, Integer> NameFrequence = createHM(empl);
        // System.out.println(NameFrequence);
        System.out.println();
        RepeateName(NameFrequence, "Повторяющиеся имена:");
        System.out.println();
        SortName(NameFrequence, "Сортировка по убыванию: ");
    }
    // Повторяющиеся имена
    private static void RepeateName(HashMap<String, Integer> HM, String message) {
        System.out.println(message);
        for (Entry<String, Integer> pair : HM.entrySet()) {
            if(pair.getValue() > 1)
                System.out.println(String.format("%s: %d", pair.getKey(), pair.getValue()));
        }
    }

    // Сортировка
    private static void SortName(HashMap<String, Integer> HM, String message) {
        System.out.println(message);

        ArrayList<Integer> list = new ArrayList<>();
        for (Entry<String, Integer> pair : HM.entrySet()) {
            if (list.contains(pair.getValue())==false)
                list.add(pair.getValue());
        }
        Collections.sort(list, Collections.reverseOrder());
        int k = 1;
        for (int i = 0; i < list.size(); i++) {
            for (Entry<String, Integer> pair : HM.entrySet()) {
                if(list.get(i) == pair.getValue())
                    System.out.println(String.format("%d. %s: %d", k++, pair.getKey(), pair.getValue()));
            }
        }

    }

    // метод создает хешмап, ключ имя, значения как часто встречается
    private static HashMap<String, Integer> createHM(ArrayList<String> AL) {
        HashMap<String, Integer> HM = new HashMap<>();
        int count = 1;
        for (int i = 0; i < AL.size(); i++) {
            count = 1;
            for (int j = i+1; j < AL.size(); j++) {
                if (AL.get(i).equals(AL.get(j))) 
                    count++;
            }
            if (HM.containsKey(AL.get(i)) == false)
                HM.put(AL.get(i), count);
        }
        return HM;
    }

    //считываю имена в массив
    private static ArrayList<String> ReadFile(String FileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(FileName));
        String str;
        ArrayList<String> empl = new ArrayList<>();
        int i = 0;
        while ((str = br.readLine()) != null) {
            empl.add(i, str.split(" ")[0]);
            i++;
        }
        br.close();
        return empl;
    }
}