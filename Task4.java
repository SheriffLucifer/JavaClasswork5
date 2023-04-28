import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// Взять набор строк, например,
// Мороз и солнце день чудесный 
// Еще ты дремлешь друг прелестный 
// Пора красавица проснись.
// Написать метод, который отсортирует эти строки по длине с помощью TreeMap. 
// Строки с одинаковой длиной не должны “потеряться”.

public class Task4 {
    public static void main(String[] args) {
        String line = "Мороз и солнце день чудесный\n" +
                "Еще ты дремлешь друг прелестный\n" +
                "Пора красавица проснись.";
        ex4(line);
    }

    static void ex4(String line) {
        line = line.replace("\n", " ");
        line = line.replace(".", "");
        String[] words = line.split(" ");
        Map<Integer, List<String>> map = new TreeMap<>(Comparator.reverseOrder());
        for (String word : words) {
            int len = word.length();
            if (map.containsKey(len)) {
                List<String> list = map.get(len);
                list.add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(len, list);
            }
        }
        System.out.println(map);
    }
}
